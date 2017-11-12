/**
 * 
 */
package com.marc.excelTransformer;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * Class to write the modified datas in new csv-file
 * 
 * @author Marc
 *
 */
public class WriteCSV {

	public WriteCSV(String json, String fileName, String targetFolder)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		List<DataSetModified> modList = new ArrayList<>();
		// _priceOffset = priceOffset;

		DataSetOrigin[] fromJson = new Gson().fromJson(json, DataSetOrigin[].class);
		for (DataSetOrigin o : fromJson) {
			DataSetModified generatedModifiedDataSet = generateModifiedDataSet(o, fileName);

			modList.add(generatedModifiedDataSet);
		}

		fileName = targetFolder + "\\" + "import_" + fileName;
		writeCSVFile(fileName, modList);
	}

	/**
	 * Write the list of Datas in csv-files
	 * 
	 * @param csvFileName
	 * @param listDataSets
	 * @param pictureURL 
	 */
	static void writeCSVFile(String csvFileName, List<DataSetModified> listDataSets) {
		ICsvBeanWriter beanWriter = null;
		CellProcessor[] processors = new CellProcessor[] { null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null };

		try {
			beanWriter = new CsvBeanWriter(new FileWriter(csvFileName), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
			String[] header = { "ordernumber", "mainnumber", "additionalText", "name", "supplier", "tax", "price_EK",
					"pseudoprice_EK", "baseprice_EK", "price_H", "pseudoprice_H", "baseprice_H", "active", "unknown",
					"instock", "stockmin", "description", "description_long", "shippingtime", "added", "changed",
					"releasedate", "shippingfree", "topseller", "keywords", "minpurchase", "purchasesteps",
					"maxpurchase", "purchaseunit", "packunit", "unitID", "pricegroupID", "pricegroupActive",
					"laststock", "suppliernumber", "weight", "width", "height", "length", "ean", "similar",
					"configuratorsetID", "configuratortype", "configuratorOptions", "categories", "propertyGroupName",
					"propertyValueName", "accessory", "imageUrl", "main", "attr1", "attr2", "attr3", "purchasePrice",
					"metatitle" };
			beanWriter.writeHeader(header);

			for (DataSetModified aDataSet : listDataSets) {
				beanWriter.write(aDataSet, header, processors);
			}

		} catch (IOException ex) {
			System.err.println("Error writing the CSV file: " + ex);
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("Error closing the writer: " + ex);
				}
			}
		}
	}

	/**
	 * sets the edited values from the original csv file to modified file
	 * 
	 * @param o
	 * @param fileName 
	 * @return
	 */
	private DataSetModified generateModifiedDataSet(DataSetOrigin o, String fileName) {
		DataSetModified m = new DataSetModified();
		m.setOrdernumber(o.getTec_ID());
		m.setMainnumber("EBC"+o.getTec_ID());
		m.setAdditionalText("");
		m.setName(createName(o));
		m.setSupplier("EBC-Brakes");
		m.setTax("19.00");

		// calc new price
		float multiplier = 0.9f;
		float preisBrutto = Float.valueOf(o.getPreis_brutto());
		float price = preisBrutto * multiplier;
		m.setPrice_EK(String.format(Locale.ROOT, "%.2f", price)); // Preis Brutto*0,9

		m.setPseudoprice_EK(o.getPreis_brutto());
		m.setBaseprice_EK("");
		m.setPrice_H("");
		m.setPseudoprice_H("");
		m.setBaseprice_H("");
		m.setActive("1");
		m.setInstock(20);
		m.setStockmin("5");
		m.setDescription(o.getKurzbeschreibung());
		m.setDescription_long(createDescLong(o));
		m.setShippingtime("90");
		m.setAdded(getDate());
		m.setChanged("");
		m.setReleasedate("");
		m.setShippingfree("0");
		m.setTopseller("0");
		m.setKeywords("");
		m.setMinpurchase("1");
		m.setPurchasesteps("");
		m.setMaxpurchase("");
		m.setPurchaseunit("");
		m.setReferenceunit("");
		m.setPackunit("");
		m.setUnitID("");
		m.setPricegroupID("");
		m.setPricegroupActive("0");
		m.setLaststock("0");
		m.setSuppliernumber(o.getArtikelnummer());
		m.setWeight("5");
		m.setHeight("");
		m.setLength("0");
		m.setEan(o.getEan());
		m.setSimilar("");
		m.setConfiguratorsetID("");
		m.setConfiguratortype("");
		m.setConfiguratorOptions("");
		m.setCategories("");
		m.setPropertyGroupName("Fahrzeug");
		m.setPropertyValueName(generatePropValueName(o));
		m.setAccessory("");
		m.setImageUrl(App._pictureAssignment.get(fileName));
		m.setMain("");
		m.setAttr1("");
		m.setAttr2("");
		m.setAttr3("");
		m.setPurchasePrice("");
		m.setMetatitle(createMetaTitle(o));

		return m;
	}

	/**
	 * Construct of metaTitle metatitle - (Textbaustein)EBC Kurzbeschreibung(bis
	 * <br>
	 * ) (Textbaustein) - Einbauort - Marke Model Ausführung Modell-BJ /// wie
	 * oben bei Name
	 * 
	 * @param o
	 * @return
	 */
	private String createMetaTitle(DataSetOrigin o) {

		String metaTitle = "";
		metaTitle += "EBC " + getKurzbeschreibungFirstPart(o.getKurzbeschreibung()) + " - " + o.getEinbauort() + " - "
				+ o.getMarke() + " " + o.getModell() + " " + o.getPs() + "PS " + o.getAusfuehrung() + " "
				+ o.getModell_BJ();

		return metaTitle;
	}

	/**
	 * creates the long description
	 * 
	 * description_long – Passend für folgendes Fahrzeug: <br> Marke: Marke
	 * <br> Modell: Modell <br> Aufbauart: Aufbauart <br> Modell Baujahr:
	 * Modell BJ <br> Fahrzeug Baujahr: FHZ BJ <br> Leistung: KWKW / PSPS
	 * <br> Hubraum: Hubraum <br> HSN – TSN: HSN_TSN <br> Motorcode:
	 * Motorcode <br> Antrieb: Antrieb <br> Zusatz: Zusatz <br> Zulassung:
	 * Zulassung <br><br> Kurzbeschreibung <br><br> Langbeschreibung
	 * 
	 * 
	 * @param o
	 * @return
	 */
	private String createDescLong(DataSetOrigin o) {

		String descLong = "";
		

		descLong += "Passend für folgendes Fahrzeug: <br> " + "Marke: " + o.getMarke() + " <br> Modell: "
				+ o.getModell() + " <br> Aufbauart: " + o.getAufbauart() + " <br> Modell Baujahr: " + o.getModell_BJ()
				+ " <br> Fahrzeug Baujahr: " + o.getFhz_BJ() + " <br>  Leistung: " + o.getKw() + "KW / " + o.getPs()
				+ "PS <br> Hubraum: " + o.getHubraum() + " <br> HSN - TSN: " + o.getHsn_tsn() + " <br>" + " Motorcode: "
				+ o.getMotorcode() + " <br> Antrieb: " + o.getAntrieb() + " <br> Zusatz: " + o.getZusatz()
				+ " <br> Zulassung: " + o.getZulassung() + "<br<br> Kurzbeschreibung: " + o.getLangbeschreibung();

		return descLong;
	}

	/**
	 * creates the name value Name – (Textbaustein)EBC Kurzbeschreibung(bis <br> ) 
	 * (Textbaustein) - Einbauort - Marke Model Ausführung Modell-BJ ///
	 * ergibt EBC Black Dash-Disc – Hinterachse - Volvo 940 2.0 90-94
	 * 
	 * @param o
	 * @return
	 */
	private String createName(DataSetOrigin o) {

		String name = "";
		name += "EBC " + getKurzbeschreibungFirstPart(o.getKurzbeschreibung()) + " - " + o.getEinbauort() + " - "
				+ o.getMarke() + " " + o.getModell() + " " + o.getPs() + "PS " + o.getAusfuehrung() + " "
				+ o.getModell_BJ();

		return name;
	}

	private String getKurzbeschreibungFirstPart(String kurzbeschreibung) {

		int indexOf = kurzbeschreibung.indexOf("<br>");
		String kurzbeschreibungFirstPart = "";
		if (indexOf != -1)
			kurzbeschreibungFirstPart = kurzbeschreibung.substring(0, indexOf);
		else
			kurzbeschreibungFirstPart = kurzbeschreibung;

		return kurzbeschreibungFirstPart;
	}

	/**
	 * propertyValueName - Marke:Marke|Modell:Modell|Ausfuehrung: Ausfuehrung|Baujahr: FHZ BJ|Einbauort: Einbauort
	 * @param o
	 * @return
	 */
	private String generatePropValueName(DataSetOrigin o) {

		String propNameValue = "";

		 String marke = o.getMarke() != null ? o.getMarke() : "";
		 String modell = o.getModell() != null ? o.getModell() : "";
		 String ausfuehrung = o.getAusfuehrung() != null ? o.getAusfuehrung() : "";
		 String baujahr = o.getFhz_BJ() != null ? o.getFhz_BJ() : "";
		 String einbauort = o.getEinbauort() != null ? o.getEinbauort() : "";
		
		
		 propNameValue += "Marke:"+marke+"|Modell:"+modell+"|Ausfuehrung:"+ausfuehrung+"|Baujahr:"+baujahr+"|Einbauort:"+einbauort;
		 
		 
		return propNameValue;
	}

	/**
	 * gets the current date
	 * 
	 * @return
	 */
	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d = new Date(System.currentTimeMillis());
		String format = sdf.format(d);

		return format;
	}

}
