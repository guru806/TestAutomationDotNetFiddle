package com.test.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePage{
    WebDriver driver;

    @FindBy(css="#run-button")
      WebElement runButton;

    @FindBy(css="#CodeForm > div.main.docked > div.content > div > div.output-container > div.output-pane.pane")
    WebElement outputWindow;

    @FindBy(xpath="//*[@id='Share']")
    WebElement shareButton;

    @FindBy(id="share-dialog")
    WebElement shareDialogueBox;

    @FindBy(xpath="/html/body/div[1]/div[3]/div/form/div[1]/input")
    WebElement shareLink;

    @FindBy(xpath="//*[@id=\"CodeForm\"]/div[2]/div[2]/div[1]/button[1]")
    WebElement options;

    @FindBy(id="save-button")
    WebElement saveButton;

    @FindBy(css="#login-modal")
    WebElement loginPopUp;

    @FindBy(xpath="//*[@id=\"top-navbar\"]/div[2]/div[2]/div[5]/a")
    WebElement gettingStartedButton;

    @FindBy(css="#top-navbar > div.navbar-center-container > div:nth-child(1) > a")
    WebElement backToEditor;

    @FindBy(css="#CodeForm > div.main.docked > div.sidebar.unselectable > div:nth-child(5) > div > div > input")
    WebElement nugetPackage;

    @FindBy(xpath="//*[@id=\"menu\"]/li[1]")
    WebElement nugetPackageMenu;

    @FindBy(xpath=" //*[@id=\"menu\"]/li[1]/ul/li[1]/a")
    WebElement version;

    @FindBy(xpath="//*[@id=\"CodeForm\"]/div[2]/div[2]/div[5]/div/div/ul/li/div/div")
    WebElement nunitIcon;

    @FindBy(xpath=" //*[@id=\"login-modal\"]/div/div/div[1]/button")
    WebElement closeButton;


    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public  void clickRunButton() throws InterruptedException {
        System.out.println("Clicking on run button");
        runButton.click();
    }
    public void verifyOutputWindow(String expectedText){
        System.out.println("Checking output window");
        String actual=outputWindow.getText();
        System.out.println(actual);
        Assert.assertEquals(expectedText,actual);
    }

     public void clickShareButton() throws InterruptedException, IOException, UnsupportedFlavorException {
         shareButton.click();
         Thread.sleep(3000);
         shareDialogueBox.click();
         String myText=driver.findElement(By.xpath("//*[@id=\"ShareLink\"]")).getAttribute("value");
         System.out.println("The share link Text is  " + myText);
         Assert.assertTrue((myText.startsWith("https://dotnetfiddle.net/")));
     }

     public void clickOptionsButton() throws InterruptedException {
         options.click();
         Thread.sleep(1000);
         Assert.assertFalse("options is not expected to be present on screen",options.isDisplayed());
     }

     public void clickSaveButton() throws InterruptedException {
      saveButton.click();
      Thread.sleep(2000);
      Assert.assertTrue(loginPopUp.isDisplayed());
      closeButton.click();
     }

     public void clickGettingStarted() throws InterruptedException {
        gettingStartedButton.click();
         Thread.sleep(2000);
         Assert.assertTrue(backToEditor.isDisplayed());
     }

     public void  selectNugetPackages() throws InterruptedException {
      nugetPackage.isDisplayed();
      nugetPackage.sendKeys("nUnit");
      Thread.sleep(3000);
      nugetPackageMenu.isDisplayed();
      Thread.sleep(3000);
       nugetPackageMenu.click();
         Thread.sleep(5000);
         version.isDisplayed();
         if(version.getText().equals("3.12.0")) {
             version.click();
         }
         Thread.sleep(5000);
         Assert.assertTrue(nunitIcon.isDisplayed());
     }

    public void performAcion(String firstName) throws InterruptedException, IOException, UnsupportedFlavorException {
        String s=firstName.substring(0,1);
        System.out.println("The first name starts with "+s);
        if(s.equalsIgnoreCase("F")||s.equalsIgnoreCase("G")||s.equalsIgnoreCase("H")||s.equalsIgnoreCase("I")||s.equalsIgnoreCase("J")||s.equalsIgnoreCase("K")){
            System.out.println("Clicking on share button");
            clickShareButton();
        }
        if(s.equalsIgnoreCase("L")||s.equalsIgnoreCase("M")||s.equalsIgnoreCase("N")||s.equalsIgnoreCase("O")||s.equalsIgnoreCase("P")){
            System.out.println("Clicking on < button");
            clickOptionsButton();
        }
        if(s.equalsIgnoreCase("Q")||s.equalsIgnoreCase("R")||s.equalsIgnoreCase("S")||s.equalsIgnoreCase("T")||s.equalsIgnoreCase("U")){
            System.out.println("Clicking on save button");
            clickSaveButton();
        }
        if(s.equalsIgnoreCase("V")||s.equalsIgnoreCase("W")||s.equalsIgnoreCase("X")||s.equalsIgnoreCase("Y")||s.equalsIgnoreCase("Z")){
            System.out.println("Clicking on Getting started button");
         clickGettingStarted();
        }
        if(s.equalsIgnoreCase("A")||s.equalsIgnoreCase("B")||s.equalsIgnoreCase("C")||s.equalsIgnoreCase("D")||s.equalsIgnoreCase("E")){
            System.out.println("Clicking on select Nuget packages");
            selectNugetPackages();
        }
    }
}
