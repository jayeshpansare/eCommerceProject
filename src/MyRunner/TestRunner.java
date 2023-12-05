package MyRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import lib.BaseClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

@CucumberOptions(
        features = "src/features",
        glue = {"stepDefinition"},
        tags = {"@aboutUs"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        })
public class TestRunner extends AbstractTestNGCucumberTests{
        BaseClass objBaseClass = new BaseClass();
        @BeforeSuite
        public void openWebsite() throws IOException {
                objBaseClass.initBrowser();
        }
        @AfterSuite
        public void closeSite(){
                objBaseClass.tearDown();
        }
}
