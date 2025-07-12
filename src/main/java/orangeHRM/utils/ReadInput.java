package orangeHRM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadInput {
	
    Properties pro;
	
	public ReadInput() {
		
		File src = new File("./inputData.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}

	public String getAppURL() {
		 String appURL = pro.getProperty("URL");
		 return appURL;
	}
}
