/**
 * 
 */
package com.marc.excelTransformer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * @author Marc Beckord
 *
 */
public class ReadCSV {

	public ReadCSV(String sourceFolderPath, String sourceFileName, String targetFolder) throws IOException {

		List<DataSetOrigin> dsList = new ArrayList<>();

		System.out.println("ReadCSV2.ReadCSV2()");

		String file = sourceFolderPath + "\\" + sourceFileName;

		CsvToBean<?> beans = new CsvToBeanBuilder<DataSetOrigin>(new FileReader(file)).withType(DataSetOrigin.class)
				.withSeparator(';').withQuoteChar('\"').withFieldAsNull(CSVReaderNullFieldIndicator.BOTH).build();

		List<?> parse = beans.parse();

		if (parse.size() == 0)
			System.out.println("0");
		else
			System.out.println("1");

		for (Object dataSet : parse) {
			if (dataSet instanceof DataSetOrigin) {
				DataSetOrigin ds = (DataSetOrigin) dataSet;
				App.counter++;
				System.out.println(ds.toString());
				dsList.add(ds);

			}
		}

		String json = new Gson().toJson(dsList);
		try {
			new WriteCSV(json, sourceFileName, targetFolder);
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
	}
}
