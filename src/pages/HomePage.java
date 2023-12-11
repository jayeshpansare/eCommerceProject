package pages;

import lib.BrokenLinks;
import lib.WaitAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WindowType;
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
    public void openNewTab(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
    public void openNewSite(String str){
        driver.navigate().to(str);
    }
    @FindBy(xpath = "//div[@class=\"tawk-text-truncate\"]")
    WebElement sendMsgTitle;
    public String getSendMsgSecTitle(){
        try {
            Thread.sleep(30);
        }catch (Exception e){
            e.printStackTrace();
        }

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
        sendMsgtxtarea.sendKeys(txt);
    }
    @FindBy(xpath = "//form[@id=\"tawk-prechat-form\"]/div[1]/fieldset/div/input")
    WebElement sendMsgName;
    public void sendNameInpt(String txt) {
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
        return sendMsgSubmitBtn.getText();
    }
    @FindBy(xpath = "//div[@class=\"tawk-text-center\"]/div/div/div/p/span")
    WebElement sendMsgDesc;
    public String getSendMsgDesc() {
        return sendMsgDesc.getText();
    }
}
