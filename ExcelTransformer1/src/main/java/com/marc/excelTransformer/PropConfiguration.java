package com.marc.excelTransformer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class holds and permits access to configuration data in form of
 * key/value-pairs.
 * 
 * @author HofmannJ
 * 
 */
public class PropConfiguration
{
	private ConcurrentHashMap<String, String> _mapParams = new ConcurrentHashMap<String, String>();

	/**
	 * Constructor
	 * 
	 * @param pathConfigFile
	 *          Path to the configuration file.
	 * @throws IllegalArgumentException
	 *           Is thrown when the given configuration file path is not valid.
	 */
	public PropConfiguration(String pathConfigFile) throws IllegalArgumentException
	{
		init(pathConfigFile);
	}

	/**
	 * Empty constructor, no parameter is initialized.
	 */
	public PropConfiguration()
	{
	}

	/**
	 * Reads the configuration from a file.
	 * 
	 * @param pathConfigFile
	 *          Path to the configuration file.
	 * @throws IllegalArgumentException
	 *           Is thrown when the given configuration file path is not valid.
	 */
	private void init(String pathConfigFile) throws IllegalArgumentException
	{
		if (pathConfigFile != null)
		{
			File file = new File(pathConfigFile);

			if ((file.exists()) && (file.isFile()))
			{
				Properties properties = new Properties();
				BufferedInputStream stream = null;
				try
				{
					stream = new BufferedInputStream(new FileInputStream(pathConfigFile));
					try
					{
						properties.load(stream);

						Iterator<Entry<Object, Object>> it = properties.entrySet()
								.iterator();
						while (it.hasNext())
						{
							Entry<Object, Object> entry = it.next();

							/*
							 * The Properties-Class only holds Strings for keys/values in its
							 * HashTable.
							 */
							_mapParams
									.put((String) entry.getKey(), (String) entry.getValue());

						}

					} catch (IOException e)
					{
						e.printStackTrace();
					}
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}

				if (stream != null)
				{
					try
					{
						stream.close();
					} catch (IOException e)
					{
						e.printStackTrace();
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

	/**
	 * Returns the value for a specific key.
	 * 
	 * @param key
	 *          Key
	 * @return Value for the given key or <code>null</code>, if no value is
	 *         available for the given key.
	 */
	public String getParam(String key)
	{
		String val = null;

		if (key != null)
		{
			val = _mapParams.get(key);
		}

		return val;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("Number of parameters: ");
		sb.append(_mapParams.size());
		sb.append("\n");

		if (_mapParams.size() > 0)
		{
			LinkedList<String> lKeys = new LinkedList<String>();

			lKeys.addAll(_mapParams.keySet());
			Collections.sort(lKeys);

			int idx = 0;
			for (String key : lKeys)
			{
				sb.append("  [");
				sb.append(String.format("%04d", idx));				
				sb.append("] Key=");
				sb.append(key);
				sb.append(", Value=");
				sb.append(_mapParams.get(key));
				sb.append("\n");
				idx++;
			}
		}

		return sb.toString();
	}

}
