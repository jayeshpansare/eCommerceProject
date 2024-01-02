package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aboutuspage {
    private final WebDriver driver;
    public Aboutuspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=\"About Us\"]")
    WebElement aboutUsMenu;
    @FindBy(xpath = "//div[@class=\"page-banner\"]/following-sibling::div/div/div/div")
    WebElement aboutUsDesc;
    public String getAboutUsDesc() {
        return aboutUsDesc.getAttribute("innerText");
    }
    public String getAboutUsmenu() {
        return aboutUsMenu.getText();
    }
    public void aboutusClk() {
        aboutUsMenu.click();
    }
}
