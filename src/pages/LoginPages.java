package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
    private final WebDriver driver;
    public LoginPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement usernameinput;
    @FindBy(name = "password")
    WebElement passwordinpt;
    @FindBy(name = "form1")
    WebElement loginBtn;
    @FindBy(className = "error")
    WebElement loginErrorMsg;
    public void sendLoginData(String username, String password) {
        usernameinput.sendKeys(username);
        passwordinpt.sendKeys(password);
    }
    public void LoginBtnclick() {
        loginBtn.click();
    }
    public String getErroMsg() {
        return loginErrorMsg.getText().trim();
    }
}