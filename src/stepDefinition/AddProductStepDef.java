package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import lib.BaseClass;
import lib.Dataprovider;
import lib.MyRetry;
import lib.TableEntry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import pages.AddProducts;
import cucumber.api.java.en.Then;

import java.util.Arrays;
import java.util.List;

public class AddProductStepDef extends BaseClass {
    AddProducts objAddProducts = new AddProducts(getDriver());
    @Given("^Open Add product form$")
    public void open_Add_product_form() throws Throwable {
        objAddProducts.openAddProductsForm();
    }
    @Given("^Open Add product management menu$")
    public void open_Add_product_management_menu() throws Throwable {
        objAddProducts.openaddproductsmenu();
    }

    @When("^User can click on top level category input$")
    public void user_can_click_on_top_level_category_input() throws Throwable {
        objAddProducts.clickOnTopLevelCat();
    }

    @Then("^validate list of top level category$")
    public void validate_list_of_top_level_category() throws Throwable {

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

        objAddProducts.scrolltoAddProductEle();
    }

    @When("^Click on Add product button$")
    public void click_on_Add_product_button(){

        objAddProducts.addProductEleClick();
    }
    @When("^Click on Add product button only once$")
    public void click_on_Add_product_button_Only(){

        objAddProducts.addProductEleClickOnly();
    }

    @Then("^display an error message as \"([^\"]*)\"$")
    public void display_an_error_message_as(String errorMsg) throws InterruptedException {

        Assert.assertTrue(objAddProducts.getErrorMessages().contains(errorMsg));
    }
    /**
     * Add product form
     *
     * **/
    @When("^user select top level cat as \"([^\"]*)\"$")
    public void user_select_top_level_cat_as(String arg1) {
        objAddProducts.selectTopLevel(arg1);
    }

    @When("^user select mid level cat as \"([^\"]*)\"$")
    public void user_select_mid_level_cat_as(String arg1){
        objAddProducts.selectMidLevel(arg1);
    }

    @When("^user select end level cat as \"([^\"]*)\"$")
    public void user_select_end_level_cat_as(String arg1){
        objAddProducts.selectEndLevel(arg1);
    }

    @When("^user enter product name as \"([^\"]*)\"$")
    public void user_enter_product_name_as(String arg1) throws Throwable {
        objAddProducts.enterProductName(arg1);
    }

    @When("^user enter old price as \"([^\"]*)\"$")
    public void user_enter_old_price_as(String arg1) {
        objAddProducts.enterOldprice(arg1);
    }

    @When("^user enter new price as \"([^\"]*)\"$")
    public void user_enter_new_price_as(String arg1) {
        objAddProducts.enterNewPrice(arg1);
    }

    @When("^user enter quantity as \"([^\"]*)\"$")
    public void user_enter_quantity_as(String arg1) {
        objAddProducts.enterQuantity(arg1);
    }

    @When("^user select size as \"([^\"]*)\"$")
    public void user_select_size_as(String arg1) {
        objAddProducts.selectProductSize(arg1);
    }

    @When("^user select colour as \"([^\"]*)\"$")
    public void user_select_colour_as(String arg1) {
        objAddProducts.selectColour(arg1);
    }

    @When("^user select feature photo as \"([^\"]*)\"$")
    public void user_select_feature_photo_as(String arg1) {
        objAddProducts.selectFeaturePhoto(arg1);
    }

    @When("^user select other photo as \"([^\"]*)\"$")
    public void user_select_other_photo_as(String arg1) {
        objAddProducts.selectOthetPhoto(arg1);
    }

    @When("^user enter description as \"([^\"]*)\"$")
    public void user_enter_description_as(String arg1) {
        objAddProducts.enterDesc(arg1);
    }

    @When("^user enter short description as \"([^\"]*)\"$")
    public void user_enter_short_description_as(String arg1) {
        objAddProducts.enterShortDesc(arg1);
    }

    @When("^user enter feature as \"([^\"]*)\"$")
    public void user_enter_feature_as(String arg1) {
        objAddProducts.enterfeatureDesc(arg1);
    }

    @When("^user enter condition as \"([^\"]*)\"$")
    public void user_enter_condition_as(String arg1) {
        objAddProducts.enterConditionDesc(arg1);
    }

    @When("^user enter return polity as \"([^\"]*)\"$")
    public void user_enter_return_polity_as(String arg1) {
        objAddProducts.enterPolicyDesc(arg1);
    }

    @When("^user select feature as \"([^\"]*)\"$")
    public void user_select_feature_as(String arg1) throws Throwable {
        objAddProducts.selectfeature(arg1);
    }

    @When("^user select active as \"([^\"]*)\"$")
    public void user_select_active_as(String arg1) throws Throwable {
        objAddProducts.selectActive(arg1);
    }

    @Then("^display success message as \"([^\"]*)\"$")
    public void displaySuccessMessageAs(String arg0) {
        Assert.assertEquals(objAddProducts.getSuccessMsg(), arg0);
    }
    /**
     *
     * validate data with tabel
     * */
    @Given("^click on view all button$")
    public void click_on_view_all_button() {
        objAddProducts.clickOnViewAllBtn();
    }

    @When("^open add product table$")
    public void open_add_product_table(){
         Assert.assertEquals(driver.getTitle(),"Admin Panel");
    }

    @Then("^validate product name as \"([^\"]*)\"$")
    public void validate_product_name_as_test_Product(String productName) {
        Assert.assertEquals(productName, TableEntry.getTableData(driver).get(2).get(2));
    }

    @Then("^validate old proce as \"([^\"]*)\"$")
    public void validate_old_proce_as(String arg1){
        Assert.assertEquals(arg1, TableEntry.getTableData(driver).get(2).get(3).toString().replace("$", ""));
    }

    @Then("^validate price as \"([^\"]*)\"$")
    public void validate_price_as(String arg1){
        Assert.assertEquals(arg1, TableEntry.getTableData(driver).get(2).get(4).toString().replace("$", ""));
    }

    @Then("^validate quantity as \"([^\"]*)\"$")
    public void validate_quantity_as(String arg1) {
        Assert.assertEquals(arg1, TableEntry.getTableData(driver).get(2).get(5));
    }

    @Then("^validate category as \"([^\"]*)\" as \"([^\"]*)\" as \"([^\"]*)\"$")
    public void validate_category_as_as_as(String arg1, String arg2, String arg3){
        Assert.assertTrue(TableEntry.getTableData(driver).get(2).get(8).toString().contains(arg1));
        Assert.assertTrue(TableEntry.getTableData(driver).get(2).get(8).toString().contains(arg2));
        Assert.assertTrue(TableEntry.getTableData(driver).get(2).get(8).toString().contains(arg3));
    }

    /**
     * update the product
     *
     * */
    @Given("^update product form should be open$")
    public void update_product_form_should_be_open(){
        objAddProducts.clickOnEditBtn();
    }
    @When("^Scroll to update product button$")
    public void scroll_to_update_product_button() {
        objAddProducts.scrolltoupdateProductEle();
    }
    @And("^Click on update product button only once$")
    public void clickOnUpdateProductButtonOnlyOnce() {
        objAddProducts.clickOnUpdateBtn();
    }

    /**
     * Delete add product
     * **/
    @Then("^click on delete button$")
    public void click_on_delete_button() throws Throwable {
        objAddProducts.clickOnDeletebtn();
    }

    @Then("^display delete confirmation form$")
    public void display_delete_confirmation_form() throws Throwable {
        objAddProducts.getDeleteConPopupModelTitle();
    }

    @Then("^validate delete confirmation title as \"([^\"]*)\"$")
    public void validate_delete_confirmation_title_as(String arg1) throws Throwable {
        objAddProducts.getDeleteConPopupTitle();
    }

    @Then("^validate delete confirmation description as \"([^\"]*)\"$")
    public void validate_delete_confirmation_description_as(String arg1) throws Throwable {
        objAddProducts.getDeleteConPopDesc();
    }

    @Then("^Click on delete button for confirmation form$")
    public void click_on_delete_button_for_confirmation_form() throws Throwable {
        objAddProducts.clickOnDeletePopupBtn();
    }
}
