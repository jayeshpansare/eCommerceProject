package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import lib.BrokenLinks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.HomePage;

public class HomePageStepDef extends BaseClass {
    @When("^home page logo is available$")
    public void homePageLogoIsAvailable(){
        HomePage objHomePage = new HomePage(getDriver());
        Assert.assertTrue(objHomePage.chkLogo());
//        BrokenLinks.findBrokenLink(driver);
    }
//    @Then("^validate home page logo$")
//    public void validate_home_page_logo(){
//        HomePage objHomePage = new HomePage(getDriver());
//        objHomePage.getLogoLink();
//    }

    @Then("^login and registration links are available$")
    public void login_and_registration_links_are_available(){


    }
    @Then("^click on login link$")
    public void click_on_login_link(){

    }

    @Then("^validate login page title as \"([^\"]*)\"$")
    public void validate_login_page_title_as(String arg1){
        HomePage objHomePage = new HomePage(getDriver());
        Assert.assertEquals(arg1, objHomePage.getLoginTitle());
    }

    @Then("^validate registartion page title as \"([^\"]*)\"$")
    public void validate_registartion_page_title_as(String arg1){
        HomePage objHomePage = new HomePage(getDriver());
        objHomePage.getLoginTitle();
    }

    @Then("^back to home page$")
    public void back_to_home_page(){
        HomePage objHomePage = new HomePage(getDriver());
        objHomePage.linkClk("Home");
    }

    @And("^click on registration link$")
    public void clickOnRegistrationLink() {
        HomePage objHomePage = new HomePage(getDriver());
        objHomePage.registrationLink();
    }

    @Then("^\"([^\"]*)\" and \"([^\"]*)\" links are available$")
    public void andLinksAreAvailable(String arg0, String arg1) throws Throwable {
        HomePage objHomePage = new HomePage(getDriver());
        Assert.assertEquals(arg0.trim(), objHomePage.chkTextPresent(arg0).trim());
        Assert.assertEquals(arg1.trim(), objHomePage.chkTextPresent(arg1).trim());
    }
    @Then("^click on \"([^\"]*)\" link$")
    public void click_on_link(String arg1){
        HomePage objHomePage = new HomePage(getDriver());
        objHomePage.linkClk(arg1);
    }
//    @Given("^open web site \"([^\"]*)\"$")
//    public void open_web_site(String arg1){
//        HomePage objSearchProduct = new HomePage(getDriver());
//        objSearchProduct.openNewTab();
//        objSearchProduct.openNewSite(arg1);
//    }

    @Given("^Send message section is available and title as \"([^\"]*)\"$")
    public void send_message_section_is_available_and_title_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        Assert.assertEquals(arg1.trim(), objSearchProduct.getSendMsgSecTitle().trim());
    }

    @When("^Click on send message section$")
    public void click_on_send_message_section(){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.SendMsgClk();
    }

    @Then("^validate description on send message section as \"([^\"]*)\"$")
    public void validate_description_on_send_message_section_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.getSendMsgDesc();
    }

    @Then("^validate send message button as \"([^\"]*)\"$")
    public void validate_send_message_button_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.getSendTitleBtn();
    }

    @Given("^send message section is open$")
    public void send_message_section_is_open(){

    }

    @Then("^display an name error message as \"([^\"]*)\"$")
    public void display_an_name_error_message_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.getErrorName();
    }

    @Then("^display email error message as \"([^\"]*)\"$")
    public void display_email_error_message_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.getErrorEmail();
    }

    @Then("^display message error message as \"([^\"]*)\"$")
    public void display_message_error_message_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.getErrorMessag();
    }

    @When("^enter email input as \"([^\"]*)\"$")
    public void enter_email_input_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.sendEmailInpt(arg1);
    }

    @Then("^click on submit button$")
    public void click_on_submit_button(){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.submitBtnClk();
    }

    @When("^enter name input as \"([^\"]*)\"$")
    public void enter_name_input_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.sendNameInpt(arg1);
    }

    @When("^enter message input as \"([^\"]*)\"$")
    public void enter_message_input_as(String arg1){
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.sendMsgInpt(arg1);
    }

    @Then("^display send message success message as \"([^\"]*)\"$")
    public void displaySendMessageSuccessMessageAs(String arg0) throws Throwable {
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.getSuccessMsg();
    }

    @Then("^click on send mesg submit button$")
    public void clickOnSendMesgSubmitButton() {
        HomePage objSearchProduct = new HomePage(getDriver());
        objSearchProduct.sendAgainClk();
    }
}
