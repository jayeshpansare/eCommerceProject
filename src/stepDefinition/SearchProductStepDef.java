package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.SearchProduct;

public class SearchProductStepDef extends BaseClass {
    SearchProduct objSearchProduct = new SearchProduct(getDriver());
    @Given("^open web site \"([^\"]*)\"$")
    public void open_web_site(String URL){
        objSearchProduct.openNewTab();
        objSearchProduct.openNewSite(URL);
    }

    @Given("^over on main menu \"([^\"]*)\"$")
    public void over_on_main_menu(String arg1){
        objSearchProduct.overMainMenu(arg1);
    }

    @When("^click on sub menu \"([^\"]*)\"$")
    public void click_on_sub_menu(String arg1){
        objSearchProduct.clickOnSubMenu(arg1);
    }

    @Then("^validate the product name \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void validate_the_product_name_and_price(String arg1, String arg2){
        Assert.assertEquals(objSearchProduct.getProductName(), arg1);
        Assert.assertEquals(objSearchProduct.getProductPrice(), arg2);
    }
}
