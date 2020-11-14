package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static WebDriver driver;
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/usr/local/Tools/chromedriver");
         driver=new ChromeDriver();
    }
}
