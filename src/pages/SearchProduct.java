package pages;

import lib.WaitAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchProduct {
    private final WebDriver driver;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()=\"test product\"]")
    WebElement productName;
    @FindBy(xpath = "//*[text()=\"test product\"]/parent::h3/following-sibling::h4")
    WebElement price;

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void openNewSite(String url) {
        driver.navigate().to(url);
    }

    public void overMainMenu(String arg1) {
        WebElement ele = driver.findElement(By.xpath("//a[text()=\"" + arg1 + "\"]"));
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, ele);
        Actions obj = new Actions(driver);
        obj.moveToElement(ele).build().perform();
    }

    public void clickOnSubMenu(String arg1) {
        WebElement ele = driver.findElement(By.xpath("//a[text()=\"" + arg1 + "\"]"));
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, ele);
        Actions obj = new Actions(driver);
        obj.moveToElement(ele).build().perform();
        obj.click(ele).build().perform();
    }

    public String getProductName() {
        return productName.getText().trim();
    }

    public String getProductPrice() {
        String getPrice = price.getText().trim();
        String getNum = getPrice.replace("$", "");
        return getNum.substring(0, 2);
    }

    @FindBy(xpath = "//div[@class=\"p-title\"]/h2")
    WebElement getProductName;

    public String getproductName() {
        return getProductName.getText();
    }

    @FindBy(xpath = "//div[@class=\"p-short-des\"]/p[2]/span")
    WebElement getDesc;

    public String getDesc() {
        return getDesc.getText();
    }

    @FindBy(xpath = "//ul[@role=\"tablist\"]/li[1]/a")
    WebElement productDescTitle;
    @FindBy(xpath = "//div[@id=\"description\"]/p[2]")
    WebElement productDesc;

    public String getProdDesc() {
        Actions action = new Actions(driver);
        action.moveToElement(productDescTitle).build().perform();
        productDescTitle.click();
        return productDesc.getText();
    }

    @FindBy(xpath = "//ul[@role=\"tablist\"]/li[2]/a")
    WebElement featureDescTitle;
    @FindBy(xpath = "//div[@id=\"feature\"]/ul/li")
    WebElement featureDesc;

    public String getFeatureDesc() {
        featureDescTitle.click();
        return featureDesc.getText();
    }

    @FindBy(xpath = "//ul[@role=\"tablist\"]/li[3]/a")
    WebElement conditionDescTitle;
    @FindBy(xpath = "//div[@id=\"condition\"]/p[2]")
    WebElement conditionDesc;

    public String getCondition() {
        conditionDescTitle.click();
        return conditionDesc.getText();
    }

    @FindBy(xpath = "//ul[@role=\"tablist\"]/li[4]/a")
    WebElement rePolicyTitle;
    @FindBy(xpath = "//div[@id=\"return_policy\"]/p[2]")
    WebElement rePolicy;

    public String getReturnPolicy() {
        rePolicyTitle.click();
        return rePolicy.getText();
    }

    public void prodClk(String arg0) {
        WebElement ele = driver.findElement(By.xpath("//a[text()=\"" + arg0 + "\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();
    }

    @FindBy(xpath = "//div[@class=\"product\"]/div/div[2]/form/div/div/div[1]/select/following-sibling::span/span/span")
    WebElement prodSize;

    public void selectProdSize(String arg0) {
        prodSize.click();
        String getAriaOwnsRes = prodSize.getAttribute("aria-owns");
        WebElement sizeddl = driver.findElement(By.xpath("//ul[@id=" + '"' + getAriaOwnsRes + '"' + "]/li[text()=" + '"' + arg0 + '"' + "]"));
        sizeddl.click();
    }

    @FindBy(xpath = "//div[@class=\"product\"]/div/div[2]/form/div/div/div[2]/select/following-sibling::span/span/span")
    WebElement prodColor;

    public void selectProdColor(String arg0) {
        prodColor.click();
        String getAriaOwnsRes = prodColor.getAttribute("aria-owns");
        WebElement sizeddl = driver.findElement(By.xpath("//ul[@id=" + '"' + getAriaOwnsRes + '"' + "]/li[text()=" + '"' + arg0 + '"' + "]"));
        sizeddl.click();
    }

    @FindBy(xpath = "//input[@name=\"p_qty\"]")
    WebElement prodQuatntity;

    public void prodQuantity(String arg0) {
        prodQuatntity.sendKeys(arg0);
    }

    @FindBy(xpath = "//input[@name=\"form_add_to_cart\"]")
    WebElement addToCartBtn;

    public void addToCartBtnClk() {
        addToCartBtn.click();
    }

    public String getAlertMessage() {
        String getAlertMsg = "";
        getAlertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        return getAlertMsg;
    }
}
