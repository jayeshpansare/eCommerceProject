package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.SearchProduct;

public class SearchProductStepDef extends BaseClass {
    SearchProduct objSearchProduct = new SearchProduct(getDriver());

    @Given("^open web site \"([^\"]*)\"$")
    public void open_web_site(String URL) {
//        objSearchProduct.openNewTab();
//        objSearchProduct.openNewSite(URL);
    }

    @Given("^over on main menu \"([^\"]*)\"$")
    public void over_on_main_menu(String arg1) {
        objSearchProduct.overMainMenu(arg1);
    }

    @When("^click on sub menu \"([^\"]*)\"$")
    public void click_on_sub_menu(String arg1) {
        objSearchProduct.clickOnSubMenu(arg1);
    }

    @Then("^validate the product name \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void validate_the_product_name_and_price(String arg1, String arg2) {
        Assert.assertEquals(objSearchProduct.getProductName(), arg1);
        Assert.assertEquals(objSearchProduct.getProductPrice(), arg2);
    }

    @Then("^validate the product information as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void validateTheProductInformationAsAndAndAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        objSearchProduct.getproductName();
        objSearchProduct.getDesc();
        objSearchProduct.getProdDesc();
        objSearchProduct.getFeatureDesc();
        objSearchProduct.getCondition();
        System.out.println(objSearchProduct.getReturnPolicy());
    }

    @And("^Click on product name as \"([^\"]*)\"$")
    public void clickOnProductNameAs(String arg0) {
        objSearchProduct.prodClk(arg0);
    }

    @When("^user select product size as \"([^\"]*)\"$")
    public void userSelectProductSizeAs(String arg0) throws InterruptedException {
        objSearchProduct.selectProdSize(arg0);
    }

    @And("^user select product color as \"([^\"]*)\"$")
    public void userSelectProductColorAs(String arg0) {
        objSearchProduct.selectProdColor(arg0);
    }

    @And("^user enter product quantity as \"([^\"]*)\"$")
    public void userEnterProductQuantityAs(String arg0) {
        objSearchProduct.prodQuantity(arg0);
    }

    @Then("^click on Add to cart button$")
    public void clickOnAddToCartButton() {
        objSearchProduct.addToCartBtnClk();
    }

    @Then("^display and success message as \"([^\"]*)\"$")
    public void displayAndSuccessMessageAs(String arg0) {
        Assert.assertEquals(arg0, objSearchProduct.getAlertMessage());
    }
}
