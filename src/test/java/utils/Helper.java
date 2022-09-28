package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {
	
	public static String getData(String propertyName) {
		
		Properties Property = new Properties();
		String filePath = "src\\test\\resources\\config\\config.properties";
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(filePath);
			Property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Property.getProperty(propertyName);
	}

}
