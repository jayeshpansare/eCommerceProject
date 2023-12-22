package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import lib.BrokenLinks;
import org.testng.Assert;
import pages.LoginPages;

public class LoginStepDef extends BaseClass {
    LoginPages objLogin = new LoginPages(getDriver());

    @Given("^open login page$")
    public void open_login_page() {
        BrokenLinks.findBrokenLink(getDriver());
    }

    @When("^User enter email and password using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_email_and_password_using_and(String username, String password) throws Throwable {
        objLogin.sendLoginData(username, password);
    }

    @Then("^Click on login button$")
    public void click_on_login_button() throws Throwable {
        objLogin.LoginBtnclick();
    }

    @Then("^display an error messages as  \"([^\"]*)\"$")
    public void display_an_error_messages_as(String errorMeg) throws Throwable {
        Assert.assertEquals(objLogin.getErroMsg(), errorMeg);
    }

    @Then("^display dashboard$")
    public void display_dashboard() {
        BrokenLinks.findBrokenLink(getDriver());
    }

    @Given("^login page title as \"([^\"]*)\"$")
    public void login_page_title_as(String arg1) throws Throwable {
        Assert.assertEquals(getDriver().getTitle(), "Login");
    }

    @Then("^validate dashboard page title as \"([^\"]*)\"$")
    public void validate_dashboard_page_title_as(String dashboardTitle) throws Throwable {
        Assert.assertEquals(getDriver().getTitle(), dashboardTitle);
    }
}
