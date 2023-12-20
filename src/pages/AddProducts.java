package pages;

import cucumber.api.java.eo.Se;
import lib.ScreenShorts;
import lib.WaitAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class AddProducts {
    private final WebDriver driver;

    public AddProducts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Add Product")
    WebElement addProductBtn;
    @FindBy(xpath = "//span[text()=\"Product Management\"]")
    WebElement ProductMngMenu;
    @FindBy(xpath="//select[@name=\"tcat_id\"]/following-sibling::span")
    WebElement topLevelinpt;

    @FindBy(xpath="//select[@name=\"tcat_id\"]/following-sibling::span/span/span")
    WebElement topLevelddlres;

    @FindBy(xpath="//select[@name=\"mcat_id\"]/following-sibling::span")
    WebElement midLevelinpt;

    @FindBy(xpath="//select[@name=\"mcat_id\"]/following-sibling::span/span/span")
    WebElement midLevelddlres;
    @FindBy(xpath="//select[@name=\"ecat_id\"]/following-sibling::span")
    WebElement ecatLevelinpt;
    @FindBy(xpath="//select[@name=\"ecat_id\"]/following-sibling::span/span/span")
    WebElement ecatLevelddlres;

    @FindBy(xpath="//label[text()=\"Select Size\"]/following-sibling::div/select/following-sibling::span")
    WebElement sizeinpt;
    @FindBy(xpath="//label[text()=\"Select Size\"]/following-sibling::div/select/following-sibling::span/span/span")
    WebElement sizeddlres;

    @FindBy(xpath="//label[text()=\"Select Color\"]/following-sibling::div/select/following-sibling::span")
    WebElement colourinpt;
    @FindBy(xpath="//label[text()=\"Select Color\"]/following-sibling::div/select/following-sibling::span/span/span")
    WebElement colourddlres;

    @FindBy(xpath = "//ul[@id=\"select2-tcat_id-oh-results\"]")
    List<WebElement> MidLevelCatddl;
    @FindBy(xpath = "//button[@name=\"form1\" and text()=\"Add Product\"]")
    WebElement addProductFormBtn;
    @FindBy(xpath = "//section[@class=\"content\"]/div/div/div/p")
    WebElement getAddProductErrorMsg;
    public void openAddProductsForm() {
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, addProductBtn);
        addProductBtn.click();
    }

    public void openaddproductsmenu() {
        ProductMngMenu.click();
    }

    public void clickOnTopLevelCat() {
        topLevelinpt.click();
        ScreenShorts.takeScreenShorts();
    }

    public List<WebElement> getListOfMidLevelCat() {
        String gettopLvlRes = topLevelddlres.getAttribute("aria-owns");
        List<WebElement> MidLevelCatddl = driver.findElements(By.id(gettopLvlRes));
        return MidLevelCatddl;
    }

    public void scrolltoAddProductEle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", addProductFormBtn);
    }

    public void addProductEleClick() {
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, addProductFormBtn);
        addProductFormBtn.click();
        addProductFormBtn.click();
    }
    public void addProductEleClickOnly() {
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, addProductFormBtn);
        addProductFormBtn.click();
    }
    public String getErrorMessages() throws InterruptedException {
        String  geterrorMsg = null;
        Thread.sleep(50);
        try {
            geterrorMsg = getAddProductErrorMsg.getText();
        }catch (NoSuchElementException e){
            addProductEleClick();
        }
        return geterrorMsg;
    }
     /***
      * Add product form
      * 
      * ***/   
    public void selectTopLevel(String arg1) {
        topLevelddlres.click();
        String gettopLvlRes = topLevelddlres.getAttribute("aria-owns");
        WebElement lowLevelCatddl = driver.findElement(By.xpath("//ul[@id="+'"'+gettopLvlRes+'"'+"]/li[text()="+'"'+arg1+'"'+"]"));
        lowLevelCatddl.click();
    }

    public void selectMidLevel(String arg1) {
        midLevelinpt.click();
        String gettopLvlRes = midLevelddlres.getAttribute("aria-owns");
        WebElement MidLevelCatddl = driver.findElement(By.xpath("//ul[@id="+'"'+gettopLvlRes+'"'+"]/li[text()="+'"'+arg1+'"'+"]"));
        MidLevelCatddl.click();
    }

    public void selectEndLevel(String arg1) {
        ecatLevelinpt.click();
        String gettopLvlRes = ecatLevelddlres.getAttribute("aria-owns");
        WebElement EcatLevelCatddl = driver.findElement(By.xpath("//ul[@id="+'"'+gettopLvlRes+'"'+"]/li[text()="+'"'+arg1+'"'+"]"));
        EcatLevelCatddl.click();
    }
    @FindBy(name = "p_name")
    WebElement productName;
    public void enterProductName(String arg1) {
        productName.clear();
        productName.sendKeys(arg1);
    }
    @FindBy(name = "p_old_price")
    WebElement oldPrice;
    public void enterOldprice(String arg1) {
        oldPrice.clear();
        oldPrice.sendKeys(arg1);
    }
    @FindBy(name = "p_current_price")
    WebElement currentPrice;
    public void enterNewPrice(String arg1) {
        currentPrice.clear();
        currentPrice.sendKeys(arg1);
    }
    @FindBy(name = "p_qty")
    WebElement quantity;
    public void enterQuantity(String arg1) {
        quantity.clear();
        quantity.sendKeys(arg1);

    }

    public void selectProductSize(String arg1) {
        sizeinpt.click();
        String getAriaOwnsRes = sizeddlres.getAttribute("aria-owns");
        WebElement sizeddl = driver.findElement(By.xpath("//ul[@id="+'"'+getAriaOwnsRes+'"'+"]/li[text()="+'"'+arg1+'"'+"]"));
        sizeddl.click();
    }

    public void selectColour(String arg1) {
        colourinpt.click();
        String getAriaOwnsRes = colourddlres.getAttribute("aria-owns");
        WebElement sizeddl = driver.findElement(By.xpath("//ul[@id="+'"'+getAriaOwnsRes+'"'+"]/li[text()="+'"'+arg1+'"'+"]"));
        sizeddl.click();
    }
    @FindBy(name = "p_featured_photo")
    WebElement featurePhoto;
    public void selectFeaturePhoto(String arg1) {
        featurePhoto.sendKeys("C:\\Users\\Dell\\Downloads\\images.jpg");
    }
    @FindBy(xpath = "//div[@class=\"upload-btn\"]/input")
    WebElement otherPhoto;
    public void selectOthetPhoto(String arg1) {
        otherPhoto.sendKeys("C:\\Users\\Dell\\Downloads\\images.jpg");
    }
    @FindBy(xpath = "//textarea[@id=\"editor1\"]/following-sibling::div/div[3]/div[2]")
    WebElement enterDesc;
    public void enterDesc(String arg1) {
        enterDesc.clear();
        enterDesc.sendKeys(arg1);
    }
    @FindBy(xpath = "//textarea[@id=\"editor2\"]/following-sibling::div/div[3]/div[2]")
    WebElement shortDesc;
    public void enterShortDesc(String arg1) {
        shortDesc.clear();
        shortDesc.sendKeys(arg1);
    }
    @FindBy(xpath = "//textarea[@id=\"editor3\"]/following-sibling::div/div[3]/div[2]")
    WebElement featureDesc;
    public void enterfeatureDesc(String arg1) {
        featureDesc.clear();
        featureDesc.sendKeys(arg1);
    }
    @FindBy(xpath = "//textarea[@id=\"editor4\"]/following-sibling::div/div[3]/div[2]")
    WebElement conditionDesc;

    public void enterConditionDesc(String arg1) {
        conditionDesc.clear();
        conditionDesc.sendKeys(arg1);
    }
    @FindBy(xpath = "//textarea[@id=\"editor5\"]/following-sibling::div/div[3]/div[2]")
    WebElement PolicyDesc;

    public void enterPolicyDesc(String arg1) {
        PolicyDesc.clear();
        PolicyDesc.sendKeys(arg1);
    }
    @FindBy(name = "p_is_featured")
    WebElement featureIs;
    public void selectfeature(String arg1) {
        Select obj = new Select(featureIs);
        obj.selectByVisibleText(arg1);
    }
    @FindBy(name = "p_is_active")
    WebElement activeIs;

    public void selectActive(String arg1) {
        Select obj = new Select(activeIs);
        obj.selectByVisibleText(arg1);
    }
    @FindBy(xpath = "//*[@class=\"content\"]/div[1]/div[1]/div[1]/p")
    WebElement getAddSucessMsg;
    public String getSuccessMsg() {
        return getAddSucessMsg.getText();
    }

    @FindBy(linkText = "View All")
    WebElement viewAllBtn;
    public void clickOnViewAllBtn() {
        viewAllBtn.click();
    }
    @FindBy(xpath = "//table[@id=\"example1\"]/tbody/tr[1]/td[10]/a[1]")
    WebElement editBtn;

    public void clickOnEditBtn() {
        editBtn.click();
    }
    @FindBy(xpath = "//button[@name=\"form1\" and text()=\"Update\"]")
    WebElement addProductUpdateBtn;
    public void clickOnUpdateBtn() {
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, addProductUpdateBtn);
        addProductUpdateBtn.click();
    }
    public void scrolltoupdateProductEle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", addProductUpdateBtn);
    }
    @FindBy(xpath = "//table[@id=\"example1\"]/tbody/tr[1]/td[10]/a[1]")
    WebElement deleteBtn;
    public void clickOnDeletebtn() {
        deleteBtn.click();
    }
    @FindBy(id = "myModalLabel")
    WebElement headerTitle;
    public void getDeleteConPopupTitle() {
        headerTitle.getText();
    }
    @FindBy(xpath = "//div[@class=\"modal-body\"]/p[1]")
    WebElement deleteModelTitle;
    public void getDeleteConPopupModelTitle() {
        deleteModelTitle.getText();
    }
    @FindBy(xpath = "//div[@class=\"modal-body\"]/p[2]")
    WebElement getDeleteModelDesc;
    public void getDeleteConPopDesc() {
        getDeleteModelDesc.getText();
    }
    @FindBy(xpath = "//div[@class=\"modal-footer\"]/button")
    WebElement popupDeleteBtn;
    public void clickOnDeletePopupBtn() {
        popupDeleteBtn.click();
    }
}
