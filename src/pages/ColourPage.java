package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
    public void getColourNameFromTable(String arg0) {
        boolean eq = false;
        while (!eq){
            WebElement table = driver.findElement(By.id("example1"));
            List<WebElement> getRow = table.findElements(By.tagName("tr"));
            for (int i = 1; i < getRow.size(); i++) {
                if (!eq) {
                    List<WebElement> Columns_row = getRow.get(i).findElements(By.tagName("td"));
                    if (Columns_row.get(1).getText().equals(arg0)) {
//                        return Columns_row;
                        eq = true;
                    }
                }else {
                    eq = true;
                }
            }
            if (!eq) {
                WebElement nextBtn = getNextBtn;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
                nextBtn.click();
            } else {
                eq = true;
            }
        }
    }
}
