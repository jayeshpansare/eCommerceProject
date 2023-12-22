package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebloginPage {
    private final WebDriver driver;

    public WebloginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class=\"page-banner\"]/div/h1")
    WebElement pageTitle;
    public String getLoginPageTitle() {
        return pageTitle.getText();
    }
    @FindBy(name = "cust_email")
    WebElement emailinpt;
    public void enterEmail(String arg1) {
        emailinpt.sendKeys(arg1);
    }
    @FindBy(name = "cust_password")
    WebElement passwordinpt;
    public void enterPassword(String arg2) {
        passwordinpt.sendKeys(arg2);
    }
    @FindBy(xpath = "//*[@class=\"error\"]")
    WebElement loginError;
    public String getLoginErrorMessage() {
        return loginError.getText();
    }
    @FindBy(name = "form1")
    WebElement loginsubmitBtn;
    public void loginSubmitBtnClk() {
        loginsubmitBtn.click();
    }
}
