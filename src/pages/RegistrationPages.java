package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPages {
    private final WebDriver driver;

    public RegistrationPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class=\"error\"]")
    WebElement getErrorMsg;
    @FindBy(name = "cust_phone")
    WebElement phonenumberinpt;
    @FindBy(name = "form1")
    WebElement registerBtn;
    @FindBy(name = "cust_re_password")
    WebElement repassword;
    @FindBy(name = "cust_password")
    WebElement passwordInpt;
    @FindBy(name = "cust_zip")
    WebElement zipcodeinpt;
    @FindBy(name = "cust_state")
    WebElement stateInpt;
    @FindBy(xpath = "//select[@name=\"cust_country\"]/following-sibling::span/span/span")
    WebElement countryddl;
    @FindBy(name = "cust_address")
    WebElement addressTxtArea;
    @FindBy(name = "cust_email")
    WebElement emailInpt;
    @FindBy(name = "cust_city")
    WebElement cityInpt;
    @FindBy(name = "cust_name")
    WebElement custNameInpt;
    @FindBy(name = "cust_cname")
    WebElement companyNameInpt;
    public String getErrormeg() {
        return getErrorMsg.getText();
    }
    public void RegisterClick() {
        registerBtn.click();
    }
    public void sendRetryPassword(String arg0) {
        repassword.sendKeys(arg0);
    }
    public void sendPassword(String arg0) {
        passwordInpt.sendKeys(arg0);
    }
    public void sendZipCode(String arg0) {
        zipcodeinpt.sendKeys(arg0);
    }
    public void sendState(String arg0) {
        stateInpt.sendKeys(arg0);
    }
    public void selectCountry(String arg0) {
        countryddl.click();
        String getAriaOwnsRes = countryddl.getAttribute("aria-owns");
        WebElement sizeddl = driver.findElement(By.xpath("//ul[@id=" + '"' + getAriaOwnsRes + '"' + "]/li[text()=" + '"' + arg0 + '"' + "]"));
        sizeddl.click();
    }
    public void sendAddress(String arg0) {
        addressTxtArea.sendKeys(arg0);
    }
    public void sendEmail(String arg0) {
        emailInpt.sendKeys(arg0);
    }
    public void sendCity(String arg0) {
        cityInpt.sendKeys(arg0);
    }
    public void sendFullName(String arg0) {
        custNameInpt.sendKeys(arg0);
    }
    public void sendCompanyName(String arg0) {
        companyNameInpt.sendKeys(arg0);
    }
    public void sendPhoneNumber(String arg0) {
        phonenumberinpt.sendKeys(arg0);
    }
}
