package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FAQPages {
    private final WebDriver driver;
    @FindBy(xpath = "//a[text()=\"FAQ\"]")
    WebElement FAQmenu;

    public FAQPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFAQMenu() {
        return FAQmenu.getText();
    }

    public void FAQMenuClk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(FAQmenu));
        FAQmenu.click();
    }

    @FindBy(xpath = "//*[@class=\"page-banner\"]/div/h1")
    WebElement headerTitle;

    public void getFAQHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(headerTitle));
        headerTitle.getText();
    }

    public String getFAQAccdTitle(String arg1) {
        WebElement getEle = driver.findElement(By.xpath("//div[@id=\"faqAccordion\"]/div[" + arg1 + "]/div/h4[1]"));
        return getEle.getText();
    }

    public void FAQAccodTitleClik(String arg0) {
        WebElement getEle = driver.findElement(By.xpath("//div[@id=\"faqAccordion\"]/div[" + arg0 + "]/div/h4[1]"));
        getEle.click();
    }

    public String getFAQAccdDesc(String arg1) {
        return driver.findElement(By.xpath("//div[@id=\"faqAccordion\"]/div[" + arg1 + "]/div[2]/div")).getAttribute("innerText");
    }
}
