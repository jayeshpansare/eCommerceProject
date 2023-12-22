package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.joda.time.base.BaseLocal;
import org.testng.Assert;
import pages.WebloginPage;

public class WebLoginStepDef extends BaseClass{
    WebloginPage objwebloginpage = new WebloginPage(getDriver());
    @Given("^login page must be available \"([^\"]*)\"$")
    public void login_page_must_be_available(String arg1){
        objwebloginpage.getLoginPageTitle();
    }

    @When("^user enter email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_email_as_and_password_as(String arg1, String arg2){
        objwebloginpage.enterEmail(arg1);
        objwebloginpage.enterPassword(arg2);
    }

    @Then("^display an login error message as \"([^\"]*)\"$")
    public void display_an_login_error_message_as(String arg1){
        Assert.assertEquals(arg1, objwebloginpage.getLoginErrorMessage());
    }
    @Then("^click on login submit button$")
    public void clickOnLoginSubmitButton() {
        objwebloginpage.loginSubmitBtnClk();
    }
}
