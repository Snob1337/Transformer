package com.marc.excelTransformer;

import java.io.File;
import java.io.IOException;

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
		// Picture-URL
		String pictureURL = configuration.getParam("PICTURE_URL");

		final File folder = new File(sourcePath);
		readCSVForAllFilesInFolder(folder, sourcePath, targetFolder, pictureURL);

		System.out.println("Das umwandeln der Dateien wurde erfolgreich beendet. Die Dateien liegen im Verzeichnis "
				+ targetFolder + ".");
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
	public static void readCSVForAllFilesInFolder(final File folder, String sourcePath, String targetFolder, String pictureURL)
			throws IOException {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				readCSVForAllFilesInFolder(fileEntry, sourcePath, targetFolder, pictureURL);
			} else {
				new ReadCSV(sourcePath, fileEntry.getName(), targetFolder, pictureURL);
				System.out.println(fileEntry.getName());
			}
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
