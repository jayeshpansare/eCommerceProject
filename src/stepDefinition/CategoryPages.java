package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryPages extends BaseClass {
    category objCat = new category(getDriver());
    @Given("^home page is available \"([^\"]*)\"$")
    public void homePageIsAvailable(String arg0){
        Assert.assertEquals(arg0, getDriver().getTitle());
    }
    @When("^validate \"([^\"]*)\" menu is present$")
    public void validate_menu_is_present(String arg1){
        Assert.assertEquals(arg1, objCat.getMenu(arg1));
    }
    @And("^hover main menu as \"([^\"]*)\"$")
    public void hoverMainMenuAs(String arg0){
        objCat.hoverMainMenu(arg0);
    }

    @Then("^validate main menu \"([^\"]*)\" and its sub menu \"([^\"]*)\"$")
    public void validateMainMenuAndItsSubMenu(String arg0, String arg1){
        Assert.assertTrue(objCat.getSubMenu(arg0).contains(arg1));
    }

    @Then("^validate main menu \"([^\"]*)\" and its sub menu \"([^\"]*)\" and sub menu as \"([^\"]*)\"$")
    public void validateMainMenuAndItsSubMenuAndSubMenuAs(String arg0, String arg1, String arg2){
        String[] getSubCatArray= arg2.split("#");
        List<String> getCatArray = new ArrayList<>(Arrays.asList(getSubCatArray));
        Assert.assertTrue(objCat.getSubMenus(arg0, arg1).containsAll(getCatArray));
    }
}
