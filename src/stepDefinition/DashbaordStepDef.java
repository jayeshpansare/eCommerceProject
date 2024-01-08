package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.*;
import lib.BaseClass;
import org.testng.Assert;
import pages.DashboardPage;

public class DashbaordStepDef extends BaseClass {
    DashboardPage objDashboardPage = new DashboardPage(getDriver());
    @Given("^Open dashboard sections$")
    public void open_dashboard_sections(){
        objDashboardPage.openDashboard();
    }

    @When("^validate the dashboard title as \"([^\"]*)\"$")
    public void validate_the_dashboard_title_as(String arg1){
        Assert.assertEquals(objDashboardPage.getDashboardTitle(), arg1);
    }

    @Then("^validate dashboard section title as \"([^\"]*)\" and its count as \"([^\"]*)\"$")
    public void validate_dashboard_section_title_as_and_its_count_as(String arg1, String arg2){
        Assert.assertEquals(objDashboardPage.getDashboardSectionsTitle(arg1), arg1);
        Assert.assertEquals(objDashboardPage.getDashbaordSectionsCount(arg1), arg2);
    }
}
