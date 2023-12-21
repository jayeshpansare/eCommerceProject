package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;

public class category {
    private final WebDriver driver;
    Actions action;
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

    public void catClick(String arg0) {
        WebElement ele = driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]"));
        Actions obj = new Actions(driver);
        obj.moveToElement(ele);
        obj.click(ele);
        obj.build().perform();
    }
    public void catClick(String arg0, String arg1) {
        WebElement ele = driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]"));
        WebElement subele = driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]/parent::li/ul/li/a[text()=\""+arg1+"\"]"));
        action = new Actions(driver);
        action.moveToElement(ele).build().perform();
        action.click(subele).build().perform();
    }
    public void catClick(String arg0, String arg1, String arg2) {
        WebElement ele = driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]"));
        WebElement subele = driver.findElement(By.xpath("//div[@class=\"menu-container\"]/div/ul/li/a[text()=\""+arg0+"\"]/parent::li/ul/li/a[text()=\""+arg1+"\"]/parent::li/ul/li/a[text()=\""+arg2+"\"]"));
        action = new Actions(driver);
        action.moveToElement(ele).build().perform();
        action.click(subele).build().perform();
    }
    @FindBy(xpath = "//div[@class=\"text\"]/h3/a")
    List<WebElement> listOfProd;
    @FindBy(className = "pl_15")
    WebElement getProdErrorMsg;
    public HashSet<String> getListOfProd() {
        HashSet<String> listOfMenu =  new HashSet<>();
        if(listOfProd.size()>0){
            for (WebElement getsubMenuList : listOfProd) {
                listOfMenu.add(getsubMenuList.getText());
            }
        }else {
            listOfMenu.add(getProdErrorMsg.getText());
        }
        return listOfMenu;
    }

}
