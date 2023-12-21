package pages;

import lib.WaitAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        WebElement ele = driver.findElement(By.xpath("//a[text()=\""+arg1+"\"]"));
        WaitAction objWait = new WaitAction();
        objWait.expliciteWaitEleClickable(driver, 10, ele);
        Actions obj = new Actions(driver);
        obj.moveToElement(ele).build().perform();
    }

    public void clickOnSubMenu(String arg1) {
        WebElement ele = driver.findElement(By.xpath("//a[text()=\""+arg1+"\"]"));
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
        return getNum.substring(0,2);
    }
}
