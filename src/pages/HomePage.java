package pages;

import lib.BrokenLinks;
import lib.WaitAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
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
    @FindBy(xpath = "//img[@alt=\"logo image\"]")
    WebElement getLogoLink;
    @FindBy(xpath = "//div[@class=\"tawk-text-truncate\"]")
    WebElement sendMsgTitle;
    @FindBy(xpath = "//div[@class=\"widget-visible\"]/iframe[1]")
    WebElement sendMsgIframe;
    @FindBy(xpath = "//div[@class=\"widget-visible\"]/iframe[2]")
    WebElement sendMsgBodyIframe;
    @FindBy(xpath = "//div[@class=\"tawk-text-center\"]/div/div/div/p/span")
    WebElement sendMsgDesc;
    @FindBy(xpath = "//p[@class=\"tawk-text-bold-1\"]/following-sibling::button")
    WebElement sendAgain;
    @FindBy(name = "search_text")
    WebElement searchInpt;
    @FindBy(xpath = "//span[text()=\"No result found\"]")
    WebElement getSearchErrorMsg;
    public String getSearchProdErrorMsg() {
        return getSearchErrorMsg.getText();
    }
    @FindBy(xpath = "//input[@name=\"search_text\"]/parent::div/following-sibling::button")
    WebElement searchBtn;
    @FindBy(xpath = "//h2[text()=\"Featured Products\"]")
    WebElement getFetProdTitle;
    @FindBy(xpath = "//h2[text()=\"Featured Products\"]/following-sibling::h3")
    WebElement getfetProdDesc;
    @FindBy(xpath = "//h2[text()=\"Latest Products\"]")
    WebElement getLetProdTitle;
    @FindBy(xpath = "//h2[text()=\"Latest Products\"]/following-sibling::h3")
    WebElement getLetProdDesc;
    @FindBy(xpath = "//div[@class=\"tawk-form-footer\"]/button")
    WebElement sendMsgSubmitBtn;
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[2]/fieldset/div/input")
    WebElement sendMsgEmail;
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[3]/fieldset/div/textarea/following-sibling::small")
    WebElement msgError;
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[2]/fieldset/div/input/following-sibling::small")
    WebElement emailError;
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[1]/fieldset/div/input/following-sibling::small")
    WebElement nameError;
    @FindBy(className = "tawk-text-bold-1")
    WebElement getSendMsgSuccessMsg;
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[3]/fieldset/div/textarea")
    WebElement sendMsgtxtarea;
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[1]/fieldset/div/input")
    WebElement sendMsgName;
    public String getLoginTitle() {
        return getHomePageBanner.getText();
    }

    public void registrationLink() {
    }

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

    public void sendMsgInpt(String txt) {
        sendMsgtxtarea.clear();
        sendMsgtxtarea.sendKeys(txt);
    }

    public void sendNameInpt(String txt) {
        sendMsgName.clear();
        sendMsgName.sendKeys(txt);
    }

    public void submitBtnClk() {
        sendMsgSubmitBtn.click();
    }

    public void sendEmailInpt(String txt) {
    //    sendMsgEmail.clear();
        sendMsgEmail.sendKeys(Keys.CONTROL + "a");
        sendMsgEmail.sendKeys(Keys.DELETE);
        sendMsgEmail.sendKeys(txt);
    }

    public String getErrorMessag() {
        return msgError.getText();
    }

    public String getErrorEmail() {
        return emailError.getText();
    }

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

    public String getSuccessMsg() {
        driver.switchTo().parentFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(sendMsgBodyIframe));
        driver.switchTo().frame(sendMsgBodyIframe);
        wait.until(ExpectedConditions.visibilityOf(getSendMsgSuccessMsg));
        return getSendMsgSuccessMsg.getText();
    }

    public void sendAgainClk() {
        sendAgain.click();
    }

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

    public String getFetProdTitle() {
        return getFetProdTitle.getText();
    }

    public String getFetProdDesc() {
        return getfetProdDesc.getText();
    }

    public List<String> getListOfFetProd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getFetProdTitle));
        Actions obj = new Actions(driver);
        obj.moveToElement(getFetProdTitle).build().perform();
        ArrayList<String> fetaureData = new ArrayList<>();
       List<WebElement> getEle = driver.findElements(By.xpath("//h2[text()=\"Featured Products\"]/parent::div/parent::div/parent::div/following-sibling::div/div/div/div/div/div/div/div[2]/h3/a"));
        for (WebElement getEles : getEle){
            fetaureData.add(getEles.getAttribute("innerText"));
        }
       return fetaureData;
    }

    public String getLetProdTitle() {
        return getLetProdTitle.getText();
    }

    public String getLatProdDesc() {
        return getLetProdDesc.getText();
    }

    public List<String> getListOfLatProd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getLetProdTitle));
        Actions obj = new Actions(driver);
        obj.moveToElement(getLetProdTitle).build().perform();
        ArrayList<String> latestData = new ArrayList<>();
            List<WebElement> getEle= driver.findElements(By.xpath("//h2[text()=\"Latest Products\"]/parent::div/parent::div/parent::div/following-sibling::div/div/div/div/div/div/div/div[2]/h3/a"));
            for (WebElement getEles : getEle){
                latestData.add(getEles.getAttribute("innerText"));
            }
            return latestData;
    }
}
