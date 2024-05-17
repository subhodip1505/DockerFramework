package test.vendorPortal.utils;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.vendorPortal.VendorPortalTestData;

public class JsonUtils {
	
	private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static <T>T getTestdata(String path, Class<T> type)
	{
		try(InputStream stream = ResourceLoader.getResources(path)){
			return mapper.readValue(stream, type);
		}catch(Exception e)
		{
			log.error("Unable to read test data {}",path,e);
		}
		return null;
	}
		

}
