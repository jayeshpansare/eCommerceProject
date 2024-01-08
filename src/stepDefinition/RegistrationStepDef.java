package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.testng.Assert;
import pages.RegistrationPages;

public class RegistrationStepDef extends BaseClass {
    RegistrationPages objRegistration = new RegistrationPages(getDriver());
    @And("^user enter company name as \"([^\"]*)\"$")
    public void userEnterCompanyNameAs(String arg0){
        objRegistration.sendCompanyName(arg0);
    }

    @When("^user enter fullname as \"([^\"]*)\"$")
    public void userEnterFullnameAs(String arg0){
        objRegistration.sendFullName(arg0);
    }

    @And("^user enter city as \"([^\"]*)\"$")
    public void userEnterCityAs(String arg0){
        objRegistration.sendCity(arg0);
    }

    @And("^user enter email address as \"([^\"]*)\"$")
    public void userEnterEmailAddressAs(String arg0){
        objRegistration.sendEmail(arg0);
    }

    @And("^user enter address as \"([^\"]*)\"$")
    public void userEnterAddressAs(String arg0){
        objRegistration.sendAddress(arg0);
    }

    @And("^user select country as \"([^\"]*)\"$")
    public void userSelectCountryAs(String arg0){
        objRegistration.selectCountry(arg0);
    }

    @And("^user enter State as \"([^\"]*)\"$")
    public void userEnterStateAs(String arg0){
        objRegistration.sendState(arg0);
    }

    @And("^user enter zip code as \"([^\"]*)\"$")
    public void userEnterZipCodeAs(String arg0){
        objRegistration.sendZipCode(arg0);
    }

    @And("^user enter password as \"([^\"]*)\"$")
    public void userEnterPasswordAs(String arg0){
        objRegistration.sendPassword(arg0);
    }

    @And("^user enter retry password as \"([^\"]*)\"$")
    public void userEnterRetryPasswordAs(String arg0){
        objRegistration.sendRetryPassword(arg0);
    }

    @Then("^click on register submit button$")
    public void clickOnRegisterSubmitButton() {
        objRegistration.RegisterClick();
    }

    @Then("^display an register error message as \"([^\"]*)\"$")
    public void displayAnRegisterErrorMessageAs(String arg0){
        Assert.assertTrue(objRegistration.getErrormeg().contains(arg0), "Error Message is "+arg0);
    }

    @And("^user enter phone number as \"([^\"]*)\" on registration form$")
    public void userEnterPhoneNumberAsOnRegistrationForm(String arg0){
        objRegistration.sendPhoneNumber(arg0);
    }
}
