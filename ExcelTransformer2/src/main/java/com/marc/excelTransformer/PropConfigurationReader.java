package com.marc.excelTransformer;

import java.io.File;

/**
 * Base-class for configuration file reading. Designed as singleton, can only
 * once be initialized with a concrete configuration file path.
 * 
 * @author HofmannJ
 * 
 */
public class PropConfigurationReader
{
	private static PropConfigurationReader _instance = null;

	/**
	 * Path to the configuration file.
	 */
	private String _pathConfigFile = null;

	/**
	 * Holds the configuration.
	 */
	private PropConfiguration _configuration = null;

	/**
	 * Private constructor.
	 * 
	 * @param pathConfigFile
	 */
	private PropConfigurationReader(String pathConfigFile) throws IllegalArgumentException
	{
		this._pathConfigFile = pathConfigFile;
	
		_configuration = new PropConfiguration(_pathConfigFile);	
	}

	public static PropConfigurationReader getInstance(String pathConfigFile)
			throws IllegalArgumentException
	{
		if (_instance == null)
		{
			if (pathConfigFile != null)
			{
				File file = new File(pathConfigFile);
				if ((file.exists()) && (file.isFile()))
				{
					synchronized (PropConfigurationReader.class)
					{
						if (_instance == null)
						{
							_instance = new PropConfigurationReader(pathConfigFile);
						}
					}
				} else
				{
					throw new IllegalArgumentException(
							"The file does not exist or is no file. You have to pass a valid configuration file path to this function!");
				}
			} else
			{
				throw new IllegalArgumentException(
						"You have to set a valid configuration file path.");
			}

		}

		return _instance;
	}

	public static PropConfigurationReader getInstance() throws IllegalStateException
	{
		if (_instance == null)
		{
			throw new IllegalStateException(
					"The ConfigurationReader has once to be initialized withe a conrete file path to a configuration. Use the method getInstance(<config file path>)");
		} else
		{
			return _instance;
		}
	}

	public PropConfiguration getConfiguration()
	{
		return _configuration;
	}
}
