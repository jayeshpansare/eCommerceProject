package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.SearchProduct;

public class SearchProductStepDef extends BaseClass {
    @Given("^open web site \"([^\"]*)\"$")
    public void open_web_site(String URL){
        SearchProduct objSearchProduct = new SearchProduct(getDriver());
        objSearchProduct.openNewTab();
        objSearchProduct.openNewSite(URL);
    }

    @Given("^over on main menu \"([^\"]*)\"$")
    public void over_on_main_menu(String arg1){
        SearchProduct objSearchProduct = new SearchProduct(getDriver());
        objSearchProduct.overMainMenu(arg1);
    }

    @When("^click on sub menu \"([^\"]*)\"$")
    public void click_on_sub_menu(String arg1){
        SearchProduct objSearchProduct = new SearchProduct(getDriver());
        objSearchProduct.clickOnSubMenu(arg1);
    }

    @Then("^validate the product name \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void validate_the_product_name_and_price(String arg1, String arg2){
        SearchProduct objSearchProduct = new SearchProduct(getDriver());
        Assert.assertEquals(objSearchProduct.getProductName(), arg1);
        Assert.assertEquals(objSearchProduct.getProductPrice(), arg2);
    }
}
