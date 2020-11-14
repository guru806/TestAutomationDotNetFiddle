package com.test.StepDefinitions;

import com.test.pages.BasePage;
import com.google.inject.Inject;
import com.test.pages.HomePage;
import cucumber.api.java.en.Given;
import com.test.pages.Navigatetopage;
import org.openqa.selenium.WebDriver;

public class MyStepdefs extends BasePage {
    @Inject
    Navigatetopage navigation;
     HomePage homePage;

    @Given("^I navigate to google application$")
    public void i_navigate_to_google_application() throws Throwable {
        navigation.navigateToApplication();
        homePage=new HomePage(driver);
        homePage.clickRunButton();
        homePage.verifyOutputWindow();
        homePage.performAcion();
        driver.close();
    }
}
