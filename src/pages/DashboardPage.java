package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()=\"Dashboard\"]")
    WebElement dashboardMenu;
    @FindBy(xpath = "//section[@class=\"content-header\"]/h1")
    WebElement getDashboardHeaderName;
    public void openDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardMenu));
        dashboardMenu.click();
    }

    public String getDashboardTitle() {
        return getDashboardHeaderName.getText();
    }

    public String getDashboardSectionsTitle(String arg1) {
        return driver.findElement(By.xpath("//p[text()=\""+ arg1 +"\"]")).getText();
    }

    public String getDashbaordSectionsCount(String arg1) {
        return driver.findElement(By.xpath("//p[text()=\""+ arg1 +"\"]/parent::div/h3")).getText();
    }
}
