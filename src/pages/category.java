package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;

public class category {
    private final WebDriver driver;

    public category(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMenu(String arg1) {
        return driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg1+"\"]")).getText();
    }

    public void hoverMainMenu(String arg0) {
        WebElement ele = driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]"));
        Actions obj = new Actions(driver);
        obj.moveToElement(ele).build().perform();
    }

    public HashSet<String> getSubMenu(String arg0) {
        List<WebElement> getSubMenu = driver.findElements(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]/parent::li/ul/li/a"));
        HashSet<String> listOfMenu =  new HashSet<>();
        for (WebElement getsubMenuList : getSubMenu) {
            listOfMenu.add(getsubMenuList.getText());
        }
        return listOfMenu;
    }

    public HashSet<String> getSubMenus(String arg0, String arg1) {
        List<WebElement> getSubMenu = driver.findElements(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]/parent::li/ul/li/a[text()=\""+arg1+"\"]/parent::li/ul/li/a"));
        HashSet<String> listOfMenu =  new HashSet<>();
        for (WebElement getsubMenuList : getSubMenu) {
            listOfMenu.add(getsubMenuList.getText());
        }
        return listOfMenu;
    }
}
