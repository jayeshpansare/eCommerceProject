package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import lib.BaseClass;
import org.testng.Assert;
import pages.ColourPage;

public class ColourStepDef extends BaseClass {
    ColourPage objColourPage = new ColourPage(getDriver());
    @Given("^open view colour page$")
    public void open_view_colour_page(){
        objColourPage.openColourPage();
    }

    @Given("^validate title will be \"([^\"]*)\"$")
    public void validate_title_will_be(String arg1){
        Assert.assertEquals(objColourPage.getColourPageTitle(), arg1);
    }

    @When("^user click on Add new button$")
    public void user_click_on_Add_new_button(){
        objColourPage.AddNewBtn();
    }

    @Then("^validate form title as \"([^\"]*)\"$")
    public void validate_form_title_as(String arg1){
        objColourPage.getFormTitle();
    }

    @And("^validate colour form label as \"([^\"]*)\"$")
    public void validateColourFormLabelAs(String arg0){
        Assert.assertEquals(objColourPage.getColourLabel(), arg0);
    }
    @Given("^settion sub menu form must be open and title as \"([^\"]*)\"$")
    public void settion_sub_menu_form_must_be_open_and_title_as(String arg1){
        Assert.assertEquals(objColourPage.getFormTitle(), arg1);
    }

    @When("^user enter colour name as \"([^\"]*)\"$")
    public void user_enter_colour_name_as(String arg1){
        objColourPage.ColoursendInpt(arg1);
    }

    @When("^click on submit button for setting form$")
    public void click_on_submit_button_for_setting_form(){
        objColourPage.submitBtnClick();
    }

    @Then("^display and error message as \"([^\"]*)\"$")
    public void display_and_error_message_as(String arg1){
        Assert.assertEquals(objColourPage.getErrorMsg(), arg1);
    }

    @When("^validate the colour present into table \"([^\"]*)\"$")
    public void validateTheColourPresentIntoTable(String arg0){
        objColourPage.getColourNameFromTable(arg0);
    }

    @Then("^click on edit button$")
    public void clickOnEditButton() {

    }
}
