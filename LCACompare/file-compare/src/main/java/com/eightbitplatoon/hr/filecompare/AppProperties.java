package com.eightbitplatoon.hr.filecompare;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class AppProperties 
{
	
	InputStream input = null;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Reading some properties to make sure the properties file is ready ");

        AppProperties app = new AppProperties();
        String propertyName = "Property1";
        String value = app.readProperty(propertyName);
		System.out.println("Property::"+propertyName+"="+value);
    }
    
    public String readProperty(String propertyName)
    {
    	String value = "";
    	try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            input = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (input != null) {
                prop.load(input);
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }   		
	
    		// Read the property value
    		value = prop.getProperty(propertyName);
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return value;
    }
}
