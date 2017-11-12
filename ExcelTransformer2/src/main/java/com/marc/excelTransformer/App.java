package com.marc.excelTransformer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Starter Class
 * 
 * @author Marc Beckord
 */
public class App {

	public static Map<String, String> _pictureAssignment = new HashMap<>();
	public static int counter = 0;

	private static void initialize(String pathConfig) throws IOException {

		/*
		 * Currently no gui
		 */

		PropConfiguration configuration;

		/*
		 * Configuration einlesen
		 */
		PropConfigurationReader configReaderinstance = PropConfigurationReader.getInstance(pathConfig);
		configuration = configReaderinstance.getConfiguration();

		// Source folder path
		String sourcePath = configuration.getParam("PFAD_QUELLORDNER");
		// Target folder path
		String targetFolder = configuration.getParam("PFAD_ZIELORDNER");

		final File folder = new File(sourcePath);
		
		// createPictureAssignment(folder); //Just once 
		assignPictureToCsvFile();
		readCSVForAllFilesInFolder(folder, sourcePath, targetFolder);

		System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++\n\nDas umwandeln der Dateien wurde erfolgreich beendet. \nDie Dateien liegen im Verzeichnis "
				+ targetFolder + ".\n\n++++++++++++++++++++++++++++++++++++++++++++\n\n count:" + counter);
		
	}

	/**
	 * Reads the assignment textfile and puts the keys and values in a hashmap
	 */
	private static void assignPictureToCsvFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("./res/pictureAssignment.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				String[] split = line.split("=");
				if(split.length > 1)
					_pictureAssignment.put(split[0], (split[1] != null ? split[1] : "") );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recursive function to get all files in a parent folder
	 * 
	 * @param folder
	 * @param sourcePath
	 * @param targetFolder
	 * @param pictureURL
	 * @throws IOException
	 */
	public static void readCSVForAllFilesInFolder(final File folder, String sourcePath, String targetFolder)
			throws IOException {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				readCSVForAllFilesInFolder(fileEntry, sourcePath, targetFolder);
			} else {
				new ReadCSV(sourcePath, fileEntry.getName(), targetFolder);
				System.out.println(fileEntry.getName());
			}
		}
	}

	/**
	 * 
	 * @param folder
	 */
	private static void createPictureAssignmentFile(File folder) {
		List<String> fileList = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				createPictureAssignmentFile(fileEntry);
			} else {
				fileList.add(fileEntry.getName());
			}
		}
		writePictureAssignment(fileList);
	}

	/**
	 * 
	 * @param fileList
	 */
	private static void writePictureAssignment(List<String> fileList) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("./res/pictureAssignment.txt", "UTF-8");
			for (String string : fileList) {
				writer.println(string + "=");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Commandline args
		 */
		Options options = new Options();

		Option optionPathConfig = new Option("pathConfig", true, "Path to configuration file");
		optionPathConfig.setRequired(true);
		options.addOption(optionPathConfig);

		CommandLine cmd = null;

		CommandLineParser parser = new GnuParser();

		try {
			cmd = parser.parse(options, args);
		} catch (org.apache.commons.cli.ParseException e) {
			e.printStackTrace();
		}

		if (cmd != null) {
			String pathConfig = cmd.getOptionValue("pathConfig");
			try {
				initialize(pathConfig);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
