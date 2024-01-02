package MyRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import lib.BaseClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;

@CucumberOptions(
        features = {"src/features"},
        glue = {"stepDefinition"},
        tags = {"@login"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber",
                "json:target/cucumber-reports/cucumber.json"
        })
public class webRunner extends AbstractTestNGCucumberTests {
    BaseClass objBaseClass = new BaseClass();
    @Parameters({"env", "browser"})
    @BeforeSuite
    public void openWebsite(String env, String browser) throws IOException {
        objBaseClass.initBrowser(env, browser);
    }

    @AfterSuite
    public void closeSite() {
        objBaseClass.tearDown();
    }
}
