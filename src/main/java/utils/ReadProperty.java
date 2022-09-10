package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	public static void main(String[] args) throws IOException {
		Properties property = new Properties();
		FileInputStream file = new FileInputStream("./confirg/AppConfig.properties");
		property.load(file);
		String property2 = property.getProperty("URL");
		System.out.println(property2);
		
		 
		
	}

}
