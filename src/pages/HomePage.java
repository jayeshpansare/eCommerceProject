package pages;

import lib.BrokenLinks;
import lib.WaitAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class=\"page-banner\"]/div/h1")
    WebElement getHomePageBanner;
    public String getLoginTitle() {
        return getHomePageBanner.getText();
    }

    public void registrationLink() {
    }
    @FindBy(xpath = "//img[@alt=\"logo image\"]")
    WebElement getLogoLink;
    public Boolean chkLogo() {
        return BrokenLinks.BrokenLink(driver, getLogoLink.getAttribute("src"));
    }

    public String chkTextPresent(String str) {
        return driver.findElement(By.xpath("//a[text()=\""+str+"\"]")).getText();
    }

    public void linkClk(String arg1) {
        WebElement ele = driver.findElement(By.xpath("//a[text()=\""+arg1+"\"]"));
        WaitAction objwait = new WaitAction();
        objwait.expliciteWaitEleClickable(driver, 10, ele);
        ele.click();
    }
    @FindBy(xpath = "//div[@class=\"tawk-text-truncate\"]")
    WebElement sendMsgTitle;
    @FindBy(xpath = "//div[@class=\"widget-visible\"]/iframe[1]")
    WebElement sendMsgIframe;
    @FindBy(xpath = "//div[@class=\"widget-visible\"]/iframe[2]")
    WebElement sendMsgBodyIframe;
    @FindBy(xpath = "//div[@class=\"tawk-text-center\"]/div/div/div/p/span")
    WebElement sendMsgDesc;
    public String getSendMsgSecTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sendMsgIframe));
        driver.switchTo().frame(sendMsgIframe);
        wait.until(ExpectedConditions.elementToBeClickable(sendMsgTitle));
        return sendMsgTitle.getText();
    }

    public void SendMsgClk() {
        WaitAction objWaitAction = new WaitAction();
        objWaitAction.expliciteWaitEleClickable(driver, 10, sendMsgTitle);
        sendMsgTitle.click();
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[3]/fieldset/div/textarea")
    WebElement sendMsgtxtarea;
    public void sendMsgInpt(String txt) {
        sendMsgtxtarea.clear();
        sendMsgtxtarea.sendKeys(txt);
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[1]/fieldset/div/input")
    WebElement sendMsgName;
    public void sendNameInpt(String txt) {
        sendMsgName.clear();
        sendMsgName.sendKeys(txt);
    }
    @FindBy(xpath = "//div[@class=\"tawk-form-footer\"]/button")
    WebElement sendMsgSubmitBtn;
    public void submitBtnClk() {
        sendMsgSubmitBtn.click();
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[2]/fieldset/div/input")
    WebElement sendMsgEmail;
    public void sendEmailInpt(String txt) {
    //    sendMsgEmail.clear();
        sendMsgEmail.sendKeys(Keys.CONTROL + "a");
        sendMsgEmail.sendKeys(Keys.DELETE);
        sendMsgEmail.sendKeys(txt);
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[3]/fieldset/div/textarea/following-sibling::small")
    WebElement msgError;
    public String getErrorMessag() {
        return msgError.getText();
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[2]/fieldset/div/input/following-sibling::small")
    WebElement emailError;
    public String getErrorEmail() {
        return emailError.getText();
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[1]/fieldset/div/input/following-sibling::small")
    WebElement nameError;
    public String getErrorName() {
        return nameError.getText();
    }

    public String getSendTitleBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(sendMsgSubmitBtn));
        return sendMsgSubmitBtn.getText();
    }

    public String getSendMsgDesc() {
        driver.switchTo().parentFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(sendMsgBodyIframe));
        driver.switchTo().frame(sendMsgBodyIframe);

        wait.until(ExpectedConditions.visibilityOf(sendMsgDesc));
        return sendMsgDesc.getText();
    }
    @FindBy(className = "tawk-text-bold-1")
    WebElement getSendMsgSuccessMsg;
    public String getSuccessMsg() {
        driver.switchTo().parentFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(sendMsgBodyIframe));
        driver.switchTo().frame(sendMsgBodyIframe);
        wait.until(ExpectedConditions.visibilityOf(getSendMsgSuccessMsg));
        return getSendMsgSuccessMsg.getText();
    }
    @FindBy(xpath = "//p[@class=\"tawk-text-bold-1\"]/following-sibling::button")
    WebElement sendAgain;
    @FindBy(name = "search_text")
    WebElement searchInpt;

    public void sendAgainClk() {
        sendAgain.click();
    }
    @FindBy(xpath = "//span[text()=\"No result found\"]")
    WebElement getSearchErrorMsg;
    public String getSearchProdErrorMsg() {
        return getSearchErrorMsg.getText();
    }
    @FindBy(xpath = "//input[@name=\"search_text\"]/parent::div/following-sibling::button")
    WebElement searchBtn;

    public void searchClk() {
        searchBtn.click();
    }

    public void sendSearchinpt(String arg1) {
        searchInpt.sendKeys(arg1);
    }

    public String getSearchPlaceHolder() {
        return searchInpt.getAttribute("placeholder");
    }

    public List<WebElement> getListOfSearchProd() {
        List<WebElement> getListOfprods = driver.findElements(By.xpath("//div[@class=\"page\"]/div/div/div/div/div/div/div/div[2]/h3/a"));
        return getListOfprods;
    }
    @FindBy(xpath = "//h2[text()=\"Featured Products\"]")
    WebElement getFetProdTitle;
    public String getFetProdTitle() {
        return getFetProdTitle.getText();
    }
    @FindBy(xpath = "//h2[text()=\"Featured Products\"]/following-sibling::h3")
    WebElement getfetProdDesc;
    public String getFetProdDesc() {
        return getfetProdDesc.getText();
    }

    public List<WebElement> getListOfFetProd() {
       List<WebElement> getEle = driver.findElements(By.xpath("//h2[text()=\"Featured Products\"]/parent::div/parent::div/parent::div/following-sibling::div/div/div/div/div/div/div/div[2]/h3/a"));
        return getEle;
    }
}
