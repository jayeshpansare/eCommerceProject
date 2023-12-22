package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.FAQPages;

import java.util.Arrays;
import java.util.List;

public class FaqStepDef extends BaseClass {
    FAQPages objfaq = new FAQPages(getDriver());
    @Given("^FAQ menu must be available as \"([^\"]*)\"$")
    public void faq_menu_must_be_available_as(String arg1){
        objfaq.getFAQMenu();
    }

    @When("^user click on FAQ menu$")
    public void user_click_on_FAQ_menu(){
        objfaq.FAQMenuClk();
    }

    @Then("^open FAQ page having page title as \"([^\"]*)\"$")
    public void open_FAQ_page_having_page_title_as(String arg1){
        objfaq.getFAQHeader();
    }

    @Given("^if faq title is available as \"([^\"]*)\" for index \"([^\"]*)\"$")
    public void ifFaqTitleIsAvailableAsForIndex(String arg0, String arg1){
        Assert.assertEquals(objfaq.getFAQAccdTitle(arg1).replaceAll("\\s", " "), arg0);
    }

    @When("^user click on title for index \"([^\"]*)\"$")
    public void userClickOnTitleForIndex(String arg0){
        objfaq.FAQAccodTitleClik(arg0);
    }

    @Then("^display its description as \"([^\"]*)\" for index \"([^\"]*)\"$")
    public void displayItsDescriptionAsForIndex(String arg0, String arg1){
        List<String> getArray = Arrays.asList(arg0.split("#"));
        if(!getArray.isEmpty()){
            for (String arrayRes:getArray){
                objfaq.getFAQAccdDesc(arg1).replaceAll("\\s", " ").contains(arrayRes);
            }
        }
    }
}
