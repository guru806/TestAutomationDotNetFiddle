package com.test.hooks;

import com.test.pages.BasePage;
import cucumber.api.java.Before;


public class Hooks extends BasePage {
@Before
    public void beforeScenario(){
    setup();
}
}
