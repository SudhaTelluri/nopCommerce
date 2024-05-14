package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig { 
	 Properties pro;

	public Readconfig() {
		File src = new File("./src/test/resources/Configuration/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
    //get URL from config                    
	public String getApplicationURL() {
		String url = pro.getProperty("url");
		return url;
	}
	//get LoginUrl from config
	public String getLoginUrl() {
		String url = pro.getProperty("loginUrl");
		return url;
	}
	//get browser from config
	public String getbrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}

	//get XLPath from config
	public String getXlpath() {
		String xlPath = pro.getProperty("Xlpath");
		return xlPath;
	}
}