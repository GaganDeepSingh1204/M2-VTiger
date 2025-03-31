package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {

	/**
	 * This is a generic method to fetch a data from Properties file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFRomPropertiesFile(String key) throws IOException{
		FileInputStream fis = new FileInputStream(iPathUtility.properitiesPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;


	}
}

