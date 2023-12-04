package stepDefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver dri = new FirefoxDriver();
        dri.manage().window().maximize();
        dri.get("https://getbootstrap.com/docs/4.1/content/tables/");
        System.out.println(getTableData(dri).get(2));
        System.out.println(getTableData(dri).get(2).get(0));
        System.out.println(getTableData(dri).get(2).get(1));
        System.out.println(getTableData(dri).get(2).get(2));

    }

    private static Map<Integer, List> getTableData(WebDriver dri) {
        WebElement table = dri.findElement(By.xpath("//h2[@id=\"examples\"]/following-sibling::div[1]/table"));
        List<WebElement> getTr = table.findElements(By.tagName("tr"));
        Map<Integer, List> mainData = new HashMap<>();
        int i=1;
        for(WebElement getTrRes :getTr){
            List<WebElement> getTd = getTrRes.findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();
            for (WebElement getTdRes :getTd){
                System.out.printf(getTdRes.getText());
                rowData.add(getTdRes.getText());
            }
            if(rowData.isEmpty()){}else {
                mainData.put(i, rowData);
            }
            i++;
        }
        return mainData;
    }
}
