

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features="classpath:features",
            glue={"classpath:com/test/StepDefinitions","classpath:com/test/hooks"},
            plugin = { "pretty", "html:target/cucumber-reports" }
       )
    public class TestRunner
    {

    }

