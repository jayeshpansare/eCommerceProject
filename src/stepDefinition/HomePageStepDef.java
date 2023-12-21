package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;

import java.util.ArrayList;
import java.util.HashSet;

public class HomePageStepDef extends BaseClass {
    HomePage objHomePage = new HomePage(getDriver());
    HomePage objSearchProduct = new HomePage(getDriver());
    @When("^home page logo is available$")
    public void homePageLogoIsAvailable() {
        Assert.assertTrue(objHomePage.chkLogo());
//        BrokenLinks.findBrokenLink(driver);
    }
//    @Then("^validate home page logo$")
//    public void validate_home_page_logo(){
//        HomePage objHomePage = new HomePage(getDriver());
//        objHomePage.getLogoLink();
//    }

    @Then("^login and registration links are available$")
    public void login_and_registration_links_are_available() {


    }

    @Then("^click on login link$")
    public void click_on_login_link() {

    }

    @Then("^validate login page title as \"([^\"]*)\"$")
    public void validate_login_page_title_as(String arg1) {
        HomePage objHomePage = new HomePage(getDriver());
        Assert.assertEquals(arg1, objHomePage.getLoginTitle());
    }

    @Then("^validate registartion page title as \"([^\"]*)\"$")
    public void validate_registartion_page_title_as(String arg1) {
        objHomePage.getLoginTitle();
    }

    @Then("^back to home page$")
    public void back_to_home_page() {
        objHomePage.linkClk("Home");
    }

    @And("^click on registration link$")
    public void clickOnRegistrationLink() {
        objHomePage.registrationLink();
    }

    @Then("^\"([^\"]*)\" and \"([^\"]*)\" links are available$")
    public void andLinksAreAvailable(String arg0, String arg1) throws Throwable {
        Assert.assertEquals(arg0.trim(), objHomePage.chkTextPresent(arg0).trim());
        Assert.assertEquals(arg1.trim(), objHomePage.chkTextPresent(arg1).trim());
    }

    @Then("^click on \"([^\"]*)\" link$")
    public void click_on_link(String arg1) {
        objHomePage.linkClk(arg1);
    }
//    @Given("^open web site \"([^\"]*)\"$")
//    public void open_web_site(String arg1){
//        objSearchProduct.openNewTab();
//        objSearchProduct.openNewSite(arg1);
//    }

    @Given("^Send message section is available and title as \"([^\"]*)\"$")
    public void send_message_section_is_available_and_title_as(String arg1) {
        Assert.assertEquals(arg1.trim(), objSearchProduct.getSendMsgSecTitle().trim());
    }

    @When("^Click on send message section$")
    public void click_on_send_message_section() {
        objSearchProduct.SendMsgClk();
    }

    @Then("^validate description on send message section as \"([^\"]*)\"$")
    public void validate_description_on_send_message_section_as(String arg1) {
        objSearchProduct.getSendMsgDesc();
    }

    @Then("^validate send message button as \"([^\"]*)\"$")
    public void validate_send_message_button_as(String arg1) {
        objSearchProduct.getSendTitleBtn();
    }

    @Given("^send message section is open$")
    public void send_message_section_is_open() {

    }

    @Then("^display an name error message as \"([^\"]*)\"$")
    public void display_an_name_error_message_as(String arg1) {
        objSearchProduct.getErrorName();
    }

    @Then("^display email error message as \"([^\"]*)\"$")
    public void display_email_error_message_as(String arg1) {
        objSearchProduct.getErrorEmail();
    }

    @Then("^display message error message as \"([^\"]*)\"$")
    public void display_message_error_message_as(String arg1) {
        objSearchProduct.getErrorMessag();
    }

    @When("^enter email input as \"([^\"]*)\"$")
    public void enter_email_input_as(String arg1) {
        objSearchProduct.sendEmailInpt(arg1);
    }

    @Then("^click on submit button$")
    public void click_on_submit_button() {
        objSearchProduct.submitBtnClk();
    }

    @When("^enter name input as \"([^\"]*)\"$")
    public void enter_name_input_as(String arg1) {
        objSearchProduct.sendNameInpt(arg1);
    }

    @When("^enter message input as \"([^\"]*)\"$")
    public void enter_message_input_as(String arg1) {
        objSearchProduct.sendMsgInpt(arg1);
    }

    @Then("^display send message success message as \"([^\"]*)\"$")
    public void displaySendMessageSuccessMessageAs(String arg0) throws Throwable {
        objSearchProduct.getSuccessMsg();
    }

    @Then("^click on send mesg submit button$")
    public void clickOnSendMesgSubmitButton() {
        objSearchProduct.sendAgainClk();
    }

    @Given("^search input must be available$")
    public void search_input_must_be_available(){
        Assert.assertEquals("Search Product", objHomePage.getSearchPlaceHolder());
    }

    @When("^user enter invalid input as \"([^\"]*)\"$")
    public void user_enter_invalid_input_as(String arg1){
        objHomePage.sendSearchinpt(arg1);
    }

    @When("^click on search submit button$")
    public void click_on_search_submit_button(){
        objHomePage.searchClk();
    }

    @Then("^display an search error message as \"([^\"]*)\"$")
    public void display_an_search_error_message_as(String arg1){
        Assert.assertEquals(arg1, objHomePage.getSearchProdErrorMsg());
    }

    @When("^user enter valid input as \"([^\"]*)\"$")
    public void userEnterValidInputAs(String arg0){
        objHomePage.sendSearchinpt(arg0);
    }

    @Then("^display product as \"([^\"]*)\"$")
    public void displayProductAs(String arg0){
        HashSet set = new HashSet<>();
        if(!objHomePage.getListOfSearchProd().isEmpty()){
            for (WebElement getEle : objHomePage.getListOfSearchProd()){
                set.add(getEle.getText());
            }
        }
        Assert.assertTrue(set.contains(arg0));
    }

    @Given("^feature products section must be available \"([^\"]*)\"$")
    public void featureProductsSectionMustBeAvailable(String arg0){
        objHomePage.getFetProdTitle();
    }

    @When("^fetaure products desc must be available \"([^\"]*)\"$")
    public void fetaureProductsDescMustBeAvailable(String arg0){
        objHomePage.getFetProdDesc();
    }

    @Then("^display list of products \"([^\"]*)\"$")
    public void displayListOfProducts(String arg0){
        String[] getprods = arg0.split("#");
        ArrayList<String> set= new ArrayList<>();
        for (String getprod:getprods){
             Assert.assertTrue(objHomePage.getListOfFetProd().contains(getprod));
        }
    }

    @Given("^latest products section must be available \"([^\"]*)\"$")
    public void latestProductsSectionMustBeAvailable(String arg0){
        Assert.assertEquals(arg0, objHomePage.getLetProdTitle());
    }

    @When("^latest products desc must be available \"([^\"]*)\"$")
    public void latestProductsDescMustBeAvailable(String arg0){
        objHomePage.getLatProdDesc();
    }

    @Then("^display list of latest products as \"([^\"]*)\"$")
    public void displayListOfLatestProductsAs(String arg0){
        String[] getprods = arg0.split("#");
        for (String getprod:getprods){
            Assert.assertTrue(objHomePage.getListOfLatProd().contains(getprod));
        }
    }
}
