package com.test.StepDefinitions;

import com.test.pages.BasePage;
import com.google.inject.Inject;
import com.test.pages.HomePage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import com.test.pages.Navigatetopage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyStepdefs extends BasePage {
    @Inject
    Navigatetopage navigation;
    HomePage homePage = new HomePage(driver);

    @Given("^I navigate to the application URL$")
    public void iNavigateToTheApplicationURL() throws IOException {
        navigation.navigateToApplication();
    }

    @Given("^I click on Run button$")
    public void iClickOnRunButton() throws InterruptedException {
        homePage.clickRunButton();
    }

    @Then("^I should see \"([^\"]*)\" text on the output window$")
    public void iShouldSeeTextOnTheOutputWindow(String expected) throws Throwable {
        homePage.verifyOutputWindow(expected);
    }

    @Given("^I input firstName, I should see the actions accordingly$")
    public void iInputFirstNameIShouldSeeTheActionsAccordingly(DataTable dataTable) throws InterruptedException, UnsupportedFlavorException, IOException {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            String firstname = list.get(i).get("firstName");
            System.out.println(firstname);
            homePage.performAcion(firstname);
        }
    }
}
