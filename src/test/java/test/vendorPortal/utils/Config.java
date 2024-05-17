package test.vendorPortal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	
	private static final Logger log = LoggerFactory.getLogger(Config.class);
	private static final String DEFAULT_PROPERTIES=System.getProperty("user.dir")+"/config/default.properties";
	private static Properties properties;
	
	public static void initialize() throws IOException
	{
		properties = loadProperties();
		
		for(String key:properties.stringPropertyNames())
		{
			if(System.getProperties().contains(key))
			{
				properties.setProperty(key, System.getProperty(key));
			}
		}
		log.info("TEST PROPERTIES");
		log.info("-------------------------");
		for(String key:properties.stringPropertyNames())
			log.info("{}={}",key,properties.getProperty(key));
		log.info("-------------------------");
		
	}
	
	public static String get(String key)
	{
		return properties.getProperty(key);
	}
	
	private static Properties loadProperties() throws IOException
	{
		Properties properties = new Properties();
		try(InputStream stream = ResourceLoader.getResources(DEFAULT_PROPERTIES)){
			properties.load(stream);
		}catch(Exception e)
		{
			log.error("Unable to read properties {}", DEFAULT_PROPERTIES, e);
		}
		return properties;
	}

}
