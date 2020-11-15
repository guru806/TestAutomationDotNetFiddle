package com.test.pages;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Navigatetopage extends BasePage{

    public static void navigateToApplication() throws IOException {
        Properties prop=new Properties();
        FileInputStream fi=new FileInputStream("/Users/tintu/TestAutomation/TestAutomationDotNetFiddle/config.properties");
        prop.load(fi);
       System.out.println(prop.getProperty("url")) ;
        driver.get(prop.getProperty("url"));
        System.out.println("Application successfully loaded");
        String actualPageTitle=driver.getTitle();
        System.out.println("The page title is "+actualPageTitle);
        String expectedTitle="C# Online Compiler | .NET Fiddle";
        Assert.assertEquals(actualPageTitle,expectedTitle);

    }
}
