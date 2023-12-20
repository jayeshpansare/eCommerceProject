package pages;

import gherkin.lexer.Th;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactusPage {

    private final WebDriver driver;

    public ContactusPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()=\"Contact Us\"]")
    WebElement getcontactUsMenu;
    public String getContactUsMenuName() {
        return getcontactUsMenu.getText();
    }

    public void contactUsClk() {
        getcontactUsMenu.click();
    }
    @FindBys({
            @FindBy(xpath = "//h1[text()=\"Contact Us\"]"),
            @FindBy(xpath = "//div[@class=\"page-banner\"]/div/h1")
    })
    WebElement getContactUsHeader;
    public String getContctUsHeaderTxt() {
        return getContactUsHeader.getText();
    }
    @FindAll({
            @FindBy(xpath= "//h3[text()=\"Contact Form\"]"),
            @FindBy(xpath = "//div[@class=\"page-banner\"]/div/h1")
    })
    WebElement contactForm;
    public String getContactUsFormTxt() {
        return contactForm.getText();
    }
    @FindBy(xpath = "//input[@name=\"visitor_name\"]/preceding-sibling::label")
    WebElement nameLabel;
    public String getNameLabel() {
        return nameLabel.getText();
    }
    @FindBy(xpath = "//input[@name=\"visitor_email\"]/preceding-sibling::label")
    WebElement emailLabel;
    public String getEmailLabel() {
        return emailLabel.getText();
    }
    @FindBy(xpath = "//input[@name=\"visitor_phone\"]/preceding-sibling::label")
    WebElement phoneNum;
    public String getPhoneNumberLabel() {
        return phoneNum.getText();
    }
    @FindBy(xpath = "//textarea[@name=\"visitor_message\"]/preceding-sibling::label")
    WebElement message;
    public String getMegLabel() {
        return message.getText();
    }
    @FindBy(tagName = "//h3[text()=\"Contact Form\"]/parent::div/div[1]/div[2]/address[1]")
    WebElement addressTxt;
    public String getAddressTxt() {
        return addressTxt.getText();
    }
    @FindBy(xpath = "//h3[text()=\"Contact Form\"]/parent::div/div[1]/div[2]/address[2]/span")
    WebElement phoneNumber;
    public String getPhoneNumberTxt() {
        return phoneNumber.getText();
    }
    @FindBy(xpath = "//h3[text()=\"Contact Form\"]/parent::div/div[1]/div[2]/address[3]/a")
    WebElement emailTxt;
    public String getEmailTxt() {
        return emailTxt.getText();
    }
    @FindBy(xpath = "//input[@name=\"form_contact\"]")
    WebElement sendMsgBtn;
    public void sendMessageBtnClk() {
        sendMsgBtn.click();
    }

    public String getMessages() {
        String msg = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alt = driver.switchTo().alert();
            msg = alt.getText();
            Thread.sleep(200);
            alt.accept();
            Thread.sleep(500);
        }catch (UnhandledAlertException | InterruptedException e){
            throw  new RuntimeException(e);
        }
        return msg;
    }
    @FindBy(xpath = "//input[@name=\"visitor_name\"]")
    WebElement nameInpt;
    public void nameSendInput(String arg1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInpt));
        nameInpt.sendKeys(arg1);
    }
    @FindBy(xpath = "//input[@name=\"visitor_email\"]")
    WebElement emailInpt;
    public void emailSendInput(String arg1) {
        emailInpt.sendKeys(arg1);
    }
    @FindBy(xpath = "//input[@name=\"visitor_phone\"]")
    WebElement phoneNumInpt;
    public void phoneNumSendInput(String arg1) {
        phoneNumInpt.sendKeys(arg1);
    }
    @FindBy(xpath = "//textarea[@name=\"visitor_message\"]")
    WebElement txtArea;
    public void msgSendInput(String arg1) {
        txtArea.sendKeys(arg1);
    }
}
