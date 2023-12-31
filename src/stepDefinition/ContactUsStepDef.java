package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.ContactusPage;

public class ContactUsStepDef extends BaseClass {
    ContactusPage objContactUs = new ContactusPage(getDriver());

    @Given("^validate contact us menu must be available as \"([^\"]*)\"$")
    public void validateContactUsMenuMustBeAvailableAs(String arg0) {
        Assert.assertEquals(objContactUs.getContactUsMenuName(), arg0);
    }

    @Given("^click on contact us menu$")
    public void click_on_contact_us_menu() {
        objContactUs.contactUsClk();
    }

    @When("^validate contact us header as \"([^\"]*)\"$")
    public void validate_contact_us_header_as(String arg1) {
        Assert.assertEquals(objContactUs.getContctUsHeaderTxt(), arg1);
    }

    @Then("^validate contact form header as \"([^\"]*)\"$")
    public void validate_contact_form_header_as(String arg1) {
        Assert.assertEquals(objContactUs.getContactUsFormTxt(), arg1);
    }

    @Then("^validate form label as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void validate_form_label_as_and_and_and(String arg1, String arg2, String arg3, String arg4) {
        Assert.assertEquals(objContactUs.getNameLabel(), arg1);
        Assert.assertEquals(objContactUs.getEmailLabel(), arg2);
        Assert.assertEquals(objContactUs.getPhoneNumberLabel(), arg3);
        Assert.assertEquals(objContactUs.getMegLabel(), arg4);
    }

    @Then("^validate address as \"([^\"]*)\"$")
    public void validate_address_as(String arg1) throws Throwable {
        objContactUs.getAddressTxt();
    }

    @Then("^validate phone number as \"([^\"]*)\"$")
    public void validate_phone_number_as(String arg1) {
        Assert.assertEquals(objContactUs.getPhoneNumberTxt(), arg1);
    }

    @Then("^validate email as \"([^\"]*)\"$")
    public void validate_email_as(String arg1) {
        Assert.assertEquals(objContactUs.getEmailTxt(), arg1);
    }

    @Given("^contact us form must be available$")
    public void contact_us_form_must_be_available() {
//        objContactUs.get
    }

    @When("^click on send message button$")
    public void click_on_send_message_button() {
        objContactUs.sendMessageBtnClk();
    }

    @When("^user enter Name as \"([^\"]*)\"$")
    public void user_enter_Name_as(String arg1) throws InterruptedException {
        Thread.sleep(200);
        objContactUs.nameSendInput(arg1);
    }

    @When("^user enter email addrress as \"([^\"]*)\"$")
    public void user_enter_email_addrress_as(String arg1) {
        objContactUs.emailSendInput(arg1);
    }

    @When("^user enter phone number as \"([^\"]*)\"$")
    public void user_enter_phone_number_as(String arg1) {
        objContactUs.phoneNumSendInput(arg1);
    }

    @When("^user enter message as \"([^\"]*)\"$")
    public void user_enter_message_as(String arg1) {
        objContactUs.msgSendInput(arg1);
    }

    @Then("^display message as \"([^\"]*)\"$")
    public void display_message_as(String arg1) {
        objContactUs.getMessages();
//        Assert.assertEquals(objContactUs.getMessages(), arg1);
    }
}
