package com.qascript.utils.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {

    public static Properties loadApplicationProperties(){
        Properties props = loadProperties("src/test/resources/config/application.properties");
        return props;

    }
    public static Properties loadFrameworkProperties(){
        Properties props = loadProperties("src/test/resources/config/framework.properties");
        return props;
    }
    public static Properties loadUserProperties(){
        Properties props = loadProperties("user.properties");
        return props;
    }


    public static Properties loadProperties(String filePath){

        Properties properties = new Properties();
        try {
            FileInputStream fs = new FileInputStream(filePath);
            properties.load(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return properties;

    }
}
