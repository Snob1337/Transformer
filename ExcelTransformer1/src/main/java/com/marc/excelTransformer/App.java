package com.marc.excelTransformer;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * Hello world!
 *
 */
public class App 
{
	
	 private static void initialize( String pathConfig )
	  {

	    PropConfiguration configuration;

	    /*
	     * Configuration einlesen
	     */
	    PropConfigurationReader configReaderinstance = PropConfigurationReader.getInstance( pathConfig );
	    configuration = configReaderinstance.getConfiguration();

	    /*
	     * Configuration für die Datenbank setzen
	     */
	    String source = configuration.getParam( "PFAD_QUELLDATEI" );
	    String target = configuration.getParam( "PFAD_ZIELDATEI" );
	    String offset = configuration.getParam( "PREIS_OFFSET" );
	    Float priceOffset = Float.valueOf(offset);

	  
	    try {
			new ReadCSV(source, target, priceOffset);
		} catch (IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
	    
	  }
	
	public static void main(String[] args) {
		
		/*
	     * Commandline args
	     */
	    Options options = new Options();

	    Option optionPathConfig = new Option( "pathConfig", true, "Path to configuration file" );
	    optionPathConfig.setRequired( true );
	    options.addOption( optionPathConfig );

	    CommandLine cmd = null;

	    CommandLineParser parser = new GnuParser();

	    try
	    {
	      cmd = parser.parse( options, args );
	    }
	    catch (org.apache.commons.cli.ParseException e)
	    {
	      e.printStackTrace();
	    }

	    if ( cmd != null )
	    {
	      String pathConfig = cmd.getOptionValue( "pathConfig" );
	      initialize( pathConfig );
	    }
		
		
//		new ReadCSV("C:/Users/Marc/Downloads/csvTest.csv");
		
	}
}
