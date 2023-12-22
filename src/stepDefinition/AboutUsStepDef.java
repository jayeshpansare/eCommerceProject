package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.Aboutuspage;

public class AboutUsStepDef extends BaseClass {
    Aboutuspage objaboutuspage = new Aboutuspage(getDriver());

    @Given("^About Us menu must be available as \"([^\"]*)\"$")
    public void about_Us_menu_must_be_available_as(String arg1) {
        Assert.assertEquals(objaboutuspage.getAboutUsmenu(), arg1);
    }

    @When("^user click on About Us menu$")
    public void user_click_on_About_Us_menu() {
        objaboutuspage.aboutusClk();
    }

    @Given("^about usp page must be available$")
    public void about_usp_page_must_be_available() {

    }

    @Then("^validate the about us description as \"([^\"]*)\"$")
    public void validate_the_about_us_description_as(String arg1) {
        System.out.println(objaboutuspage.getAboutUsDesc());
    }
}
