package com.specify.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	static Properties prop;
	public static Properties loadProperties() throws IOException {
		String projectPath=System.getProperty("user.dir");
		String filePath=projectPath+File.separator+"src\\main\\resources\\Properties.properties";
	
		FileReader file=new FileReader(new File(filePath));
		prop=new Properties();
		prop.load(file);
		return prop;
	}

}
