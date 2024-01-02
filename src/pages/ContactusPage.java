package pages;

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
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//h3[text()=\"Contact Form\"]/parent::div/div[1]/div[2]/address[3]/a")
    WebElement emailTxt;
    @FindBy(xpath = "//input[@name=\"form_contact\"]")
    WebElement sendMsgBtn;
    @FindBy(xpath = "//input[@name=\"visitor_name\"]")
    WebElement nameInpt;
    @FindBy(xpath = "//input[@name=\"visitor_email\"]")
    WebElement emailInpt;
    @FindBy(xpath = "//input[@name=\"visitor_phone\"]")
    WebElement phoneNumInpt;
    @FindBy(xpath = "//textarea[@name=\"visitor_message\"]")
    WebElement txtArea;
    @FindBy(xpath = "//a[text()=\"Contact Us\"]")
    WebElement getcontactUsMenu;
    @FindBys({
            @FindBy(xpath = "//h1[text()=\"Contact Us\"]"),
            @FindBy(xpath = "//div[@class=\"page-banner\"]/div/h1")
    })
    WebElement getContactUsHeader;
    @FindAll({
            @FindBy(xpath = "//h3[text()=\"Contact Form\"]"),
            @FindBy(xpath = "//div[@class=\"page-banner\"]/div/h1")
    })
    WebElement contactForm;
    @FindBy(xpath = "//input[@name=\"visitor_name\"]/preceding-sibling::label")
    WebElement nameLabel;
    @FindBy(xpath = "//input[@name=\"visitor_email\"]/preceding-sibling::label")
    WebElement emailLabel;
    @FindBy(xpath = "//input[@name=\"visitor_phone\"]/preceding-sibling::label")
    WebElement phoneNum;

    public String getContactUsMenuName() {
        return getcontactUsMenu.getText();
    }

    public void contactUsClk() {
        getcontactUsMenu.click();
    }

    public String getContctUsHeaderTxt() {
        return getContactUsHeader.getText();
    }

    public String getContactUsFormTxt() {
        return contactForm.getText();
    }

    public String getNameLabel() {
        return nameLabel.getText();
    }

    public String getEmailLabel() {
        return emailLabel.getText();
    }

    public String getPhoneNumberLabel() {
        return phoneNum.getText();
    }

    public String getPhoneNumberTxt() {
        return phoneNumber.getText();
    }

    public String getEmailTxt() {
        return emailTxt.getText();
    }

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
        } catch (UnhandledAlertException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return msg;
    }

    public void nameSendInput(String arg1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInpt));
        nameInpt.sendKeys(arg1);
    }

    public void emailSendInput(String arg1) {
        emailInpt.sendKeys(arg1);
    }

    public void phoneNumSendInput(String arg1) {
        phoneNumInpt.sendKeys(arg1);
    }

    public void msgSendInput(String arg1) {
        txtArea.sendKeys(arg1);
    }
}
