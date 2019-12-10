package com.stpl.pms.utility;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author Pawan
 * 11/01/2010
 *
 */
public class ConfigurationPathReader {
	
	private static final Logger log=Logger.getLogger(ConfigurationPathReader.class);
	
	private static Properties prop ;
	static{
		prop = new Properties();
		try{
			prop.load(ConfigurationPathReader.class.getResourceAsStream("/common.properties"));
		
		}catch(IOException ioExcp){
			log.error("IO Exception in reading property file.");
			ioExcp.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param strAttribute
	 * @return
	 */
	public static String getPathIgsInstall(String strAttribute){
	 
			return prop.getProperty(strAttribute);
	
	}
	public static void main(String ... str){		
		//ConfigurationPathReader.getPathIgsInstall(strAttribute)
		String strVal = ConfigurationPathReader.getPathIgsInstall("MAIL_FILE_PATH");
		log.info("str is : "+strVal);
	}
}
