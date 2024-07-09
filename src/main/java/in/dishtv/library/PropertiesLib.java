package in.dishtv.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class PropertiesLib {
	private static final String FILEPATH = "./testdata/dishtv.properties";
	static FileInputStream fis;
	public static String getPropertyValue(String Key) {
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(FILEPATH);
			prop.load(fis);
		} catch (IOException e) {
			Reporter.log(e.getLocalizedMessage(), true);
		}
		return prop.getProperty(Key);
	}
}
