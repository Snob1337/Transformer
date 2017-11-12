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

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * @author Marc
 *
 */
public class WriteCSV {

	private Float _priceOffset;

	public WriteCSV(String json, String target, Float priceOffset)
			throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		List<DataSetModified> modList = new ArrayList<>();
		_priceOffset = priceOffset;

		DataSetOrigin[] fromJson = new Gson().fromJson(json, DataSetOrigin[].class);
		for (DataSetOrigin o : fromJson) {
			DataSetModified generatedModifiedDataSet = generateModifiedDataSet(o);

			modList.add(generatedModifiedDataSet);
		}

		writeCSVFile(target, modList);
	}

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

	private DataSetModified generateModifiedDataSet(DataSetOrigin o) {
		DataSetModified m = new DataSetModified();
		m.setOrdernumber(o.getPart());
		m.setMainnumber(o.getPart());
		m.setAdditionalText(o.getName());
		m.setName(o.getName());
		m.setSupplier("JAPAN RACING");
		m.setTax("19");

		String newPrice = "";
		try {
			Float priceOld = Float.valueOf(o.getSuggested());
			priceOld = priceOld + _priceOffset;
			newPrice = String.valueOf(priceOld);

		} catch (Exception e) {
			newPrice = o.getSuggested();
		}
		m.setPrice_EK(o.getName().toLowerCase().contains("blank") ? newPrice : o.getSuggested());

		m.setPseudoprice_EK("");
		m.setBaseprice_EK("");
		m.setPrice_H(o.getName().toLowerCase().contains("blank") ? newPrice : o.getSuggested());
		m.setPseudoprice_H("");
		m.setBaseprice_H("");
		m.setActive("1");

		if (o.getStock().contains(".")) {
			String[] split = o.getStock().split("\\.");
			m.setInstock(Integer.parseInt(split.length > 0 ? split[0] : "0"));
		} else
			m.setInstock(Integer.parseInt(o.getStock()));

		m.setStockmin("");
		m.setDescription(o.getName());
		String addition = "";
		if (o.getName().toLowerCase().contains("blank")) {
			addition = "Bitte geben Sie im Bestellabschluss die gewünschte Einpresstiefe und den gewünschten Lochkreis an.<br><br>";
		}
		m.setDescription_long(addition + "Hersteller: " + "JAPAN RACING" + "<br>Groesse in Zoll: " + o.getSize()
				+ "<br>Breite in Zoll: " + o.getWidth() + "<br>Lochkreis: " + o.getPcd() + "<br>Einpresstiefe: "
				+ o.getEt() + "<br>Farbe: " + o.getColour() + "<br>3D-Ansicht: <a href=\"" + o.getThreeD() + "\">"
				+ o.getThreeD() + "</a><br>"
				+ "Alle JapanRacing Felgen werden mit einem JWL / VIA Zertifikat ausgeliefert.  Ein TÜV Gutachten gehört nicht zum Lieferumfang.<br>"
				+ "Die Felgen sind erst nach einer TÜV Abnahme nach Paragraph 21/19.2 im Rahmen der StVZO erlaubt.<br>"
				+ "Bitte klären Sie die Eintragung im Vorfeld mit Ihrer ansässigen Prüfstelle ab.");
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
		m.setSuppliernumber(o.getPart());
		m.setWeight("15");
		m.setHeight("");
		m.setLength("0");
		m.setEan(o.getEan());
		m.setSimilar("");
		m.setConfiguratorsetID("");
		m.setConfiguratortype("");
		m.setConfiguratorOptions("");
		m.setCategories("");
		m.setPropertyGroupName("Felgen");
		m.setPropertyValueName(generatePropValueName(o));
		m.setAccessory("");
		m.setImageUrl("");
		m.setMain("");
		m.setAttr1("");
		m.setAttr2("");
		m.setAttr3("");
		m.setPurchasePrice("");
		m.setMetatitle("");

		return m;
	}

	private String generatePropValueName(DataSetOrigin o) {

		String propNameValue = "";

		String pcd = o.getPcd() != null ? o.getPcd() : "";
		String size = o.getSize() != null ? o.getSize() : "";
		String width = o.getWidth() != null ? o.getWidth() : "";

		String[] splittedPCD = pcd.split(" ");

		size = size != null ? size.replace("\"", "") : "";
		width = width != null ? width.replace("\"", "") : "";

		propNameValue += "Zoll:" + size + "|" + "Breite:" + width;
		for (String lochkreis : splittedPCD) {
			propNameValue += "|Lochkreis:" + lochkreis;
		}
		return propNameValue;
	}

	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date d = new Date(System.currentTimeMillis());
		String format = sdf.format(d);

		return format;
	}

}
