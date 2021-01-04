//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader() {
    }

    String path =  getPath();
    public String readApplicationFile(String key){
        String value = "";
        try{
            Properties prop = new Properties();
            File f = new File(path + "//src//test//java//com//config//application.properties");
            if(f.exists()){
                prop.load(new FileInputStream(f));
                value = prop.getProperty(key);

            }
        }
        catch(Exception e){
            System.out.println("Failed to read from application.properties file.");
        }
        return value;
    }

    public String getPath()
    {
        String path ="";
        File file = new File("");
        String absolutePathOfFirstFile = file.getAbsolutePath();
        path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
        return path;
    }




}
