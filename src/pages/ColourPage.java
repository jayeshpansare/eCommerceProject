package pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lib.TableEntry;
import lib.WaitAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import static lib.DBConnect.DBConnect;

public class ColourPage {
    private final WebDriver driver;

    public ColourPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()=\"Shop Settings\"]/parent::a")
    WebElement shopSettingMenu;
    @FindBy(xpath = "//span[text()=\"Shop Settings\"]/parent::a/following-sibling::ul/li[2]/a")
    WebElement colourMenu;
    @FindBy(xpath = "//div[@class=\"content-header-left\"]/h1")
    WebElement tableTitle;
    public void openColourPage() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(shopSettingMenu));
        shopSettingMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(colourMenu));
        colourMenu.click();
    }

    public String getColourPageTitle(){
        return tableTitle.getText();
    }
    @FindBy(xpath = "//div[@class=\"content-header-right\"]/a[contains(text(), \"Add\")]")
    WebElement addnewBtn;
    public void AddNewBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addnewBtn));
        addnewBtn.click();
    }

    public String getFormTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(tableTitle));
        return tableTitle.getText();
    }
    @FindBy(xpath = "//div[@class=\"box-body\"]/div[@class=\"form-group\"][1]/label")
    WebElement getColourLabel;
    public String getColourLabel() {
        return getColourLabel.getText();
    }
    @FindBy(name = "color_name")
    WebElement colourInpt;
    public void ColoursendInpt(String arg1) {
        colourInpt.clear();
        colourInpt.sendKeys(arg1);
    }
    @FindBy(xpath = "//button[@name=\"form1\" and text()=\"Submit\"]")
    WebElement submitBtn;
    public void submitBtnClick() {
        submitBtn.click();
    }
    @FindBy(xpath = "//section[@class=\"content\"]/div/div/div/p")
    WebElement getErrorMessage;
    public String getErrorMsg() {
        return getErrorMessage.getText();
    }
    @FindBy(xpath = "//li[@id=\"example1_next\"]/a")
    WebElement getNextBtn;
    public void getColourNameFromTable(String arg0){
        String getColourName = TableEntry.getSingleCols(driver, arg0, 1, getNextBtn).get(1).getText();
        try {
            Statement st = DBConnect();
            ResultSet rs = st.executeQuery("select * from colors where srno=30");
            while (rs.next()){
//                Assert.assertEquals(getColourName, rs.getString("colors_name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void colourEditBtnClick(String arg0) {
        List<WebElement> getTagName = TableEntry.getSingleCols(driver, arg0, 1, getNextBtn).get(2).findElements(By.tagName("a"));
        getTagName.get(0).click();
    }
    @FindBy(xpath = "//button[@name=\"form1\" and text()=\"Update\"]")
    WebElement updateColourSettingBtn;
    public void updateColourSettingBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(updateColourSettingBtn));
        updateColourSettingBtn.click();
    }
    @FindBy(className = "modal-title")
    WebElement deletePopupTitle;
    public String getDeletePopupTitle() {
        return deletePopupTitle.getText();
    }
    @FindBy(className = "modal-body")
    WebElement deletePopupDesc;
    public void getDeletePopupDesc() {
        deletePopupDesc.getText();
    }
    @FindBy(xpath = "//div[@class=\"modal-footer\"]/a")
    WebElement deleteBtn;
    public void deleteBtnClk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        deleteBtn.click();
    }

    public void colourDeleteBtnClk(String arg0) {
        List<WebElement> getTagName = TableEntry.getSingleCols(driver, arg0, 1, getNextBtn).get(2).findElements(By.tagName("a"));
        getTagName.get(1).click();
    }
}
