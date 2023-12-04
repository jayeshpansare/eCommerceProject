package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import lib.Dataprovider;
import lib.MyRetry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import pages.AddProducts;
import cucumber.api.java.en.Then;

import java.util.Arrays;
import java.util.List;

public class AddProductStepDef extends BaseClass {
    @Given("^Open Add product form$")
    public void open_Add_product_form() throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.openAddProductsForm();
    }
    @Given("^Open Add product management menu$")
    public void open_Add_product_management_menu() throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.openaddproductsmenu();
    }

    @When("^User can click on top level category input$")
    public void user_can_click_on_top_level_category_input() throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.clickOnTopLevelCat();
    }

    @Then("^validate list of top level category$")
    public void validate_list_of_top_level_category() throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        List<WebElement> topLevelEle = objAddProducts.getListOfMidLevelCat();
        for (WebElement topLevelLink : topLevelEle) {
            System.out.println(topLevelLink.getText());
        }
    }

    @Given("^add product form is open$")
    public void add_product_form_is_open(){

    }

    @When("^Scroll to Add product button$")
    public void scroll_to_Add_product_button() {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.scrolltoAddProductEle();
    }

    @When("^Click on Add product button$")
    public void click_on_Add_product_button(){
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.addProductEleClick();
    }
    @When("^Click on Add product button only once$")
    public void click_on_Add_product_button_Only(){
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.addProductEleClickOnly();
    }

    @Then("^display an error message as \"([^\"]*)\"$")
    public void display_an_error_message_as(String errorMsg) throws InterruptedException {
        AddProducts objAddProducts = new AddProducts(getDriver());
        Assert.assertTrue(objAddProducts.getErrorMessages().contains(errorMsg));
    }
    /**
     * Add product form
     *
     * **/
    @When("^user select top level cat as \"([^\"]*)\"$")
    public void user_select_top_level_cat_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectTopLevel(arg1);
    }

    @When("^user select mid level cat as \"([^\"]*)\"$")
    public void user_select_mid_level_cat_as(String arg1){
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectMidLevel(arg1);
    }

    @When("^user select end level cat as \"([^\"]*)\"$")
    public void user_select_end_level_cat_as(String arg1){
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectEndLevel(arg1);
    }

    @When("^user enter product name as \"([^\"]*)\"$")
    public void user_enter_product_name_as(String arg1) throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterProductName(arg1);
    }

    @When("^user enter old price as \"([^\"]*)\"$")
    public void user_enter_old_price_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterOldprice(arg1);
    }

    @When("^user enter new price as \"([^\"]*)\"$")
    public void user_enter_new_price_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterNewPrice(arg1);
    }

    @When("^user enter quantity as \"([^\"]*)\"$")
    public void user_enter_quantity_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterQuantity(arg1);
    }

    @When("^user select size as \"([^\"]*)\"$")
    public void user_select_size_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectProductSize(arg1);
    }

    @When("^user select colour as \"([^\"]*)\"$")
    public void user_select_colour_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectColour(arg1);
    }

    @When("^user select feature photo as \"([^\"]*)\"$")
    public void user_select_feature_photo_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectFeaturePhoto(arg1);
    }

    @When("^user select other photo as \"([^\"]*)\"$")
    public void user_select_other_photo_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectOthetPhoto(arg1);
    }

    @When("^user enter description as \"([^\"]*)\"$")
    public void user_enter_description_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterDesc(arg1);
    }

    @When("^user enter short description as \"([^\"]*)\"$")
    public void user_enter_short_description_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterShortDesc(arg1);
    }

    @When("^user enter feature as \"([^\"]*)\"$")
    public void user_enter_feature_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterfeatureDesc(arg1);
    }

    @When("^user enter condition as \"([^\"]*)\"$")
    public void user_enter_condition_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterConditionDesc(arg1);
    }

    @When("^user enter return polity as \"([^\"]*)\"$")
    public void user_enter_return_polity_as(String arg1) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.enterPolicyDesc(arg1);
    }

    @When("^user select feature as \"([^\"]*)\"$")
    public void user_select_feature_as(String arg1) throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectfeature(arg1);
    }

    @When("^user select active as \"([^\"]*)\"$")
    public void user_select_active_as(String arg1) throws Throwable {
        AddProducts objAddProducts = new AddProducts(getDriver());
        objAddProducts.selectActive(arg1);
    }

    @Then("^display success message as \"([^\"]*)\"$")
    public void displaySuccessMessageAs(String arg0) {
        AddProducts objAddProducts = new AddProducts(getDriver());
        Assert.assertEquals(objAddProducts.getSuccessMsg(), arg0);
    }
}
