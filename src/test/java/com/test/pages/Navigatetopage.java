package com.test.pages;

import org.junit.Assert;

public class Navigatetopage extends BasePage{

    public static void navigateToApplication(){
        driver.get("https://dotnetfiddle.net/");
        System.out.println("Application successfully loaded");
        String actualPageTitle=driver.getTitle();
        System.out.println("The page title is "+actualPageTitle);
        String expectedTitle="C# Online Compiler | .NET Fiddle";
        Assert.assertEquals(actualPageTitle,expectedTitle);

    }
}
