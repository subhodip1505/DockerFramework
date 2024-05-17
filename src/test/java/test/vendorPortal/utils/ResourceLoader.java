package test.vendorPortal.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceLoader {
	
	private static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);
	
	public static InputStream getResources(String path) throws IOException
	{
		log.info("reading resources from location: {}", path);
		InputStream stream = ResourceLoader.class.getResourceAsStream(path);
		if(Objects.nonNull(stream)) {
			return stream;
		}
		return Files.newInputStream(Path.of(path));
	}

}
