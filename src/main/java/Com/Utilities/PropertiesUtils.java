package Com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtils {

	public static Properties prop = null;
	public static FileInputStream fis = null;

	public static String readProperty(String key) throws Exception {

		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.Properties");
		prop.load(fis);

		return prop.getProperty(key);

	}
	public static void main(String[] args) throws Exception {
		
		System.out.println(readProperty("browser"));
	}

}
