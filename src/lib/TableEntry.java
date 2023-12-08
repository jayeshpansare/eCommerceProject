package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableEntry {
    public static Map<Integer, List> getTableData(WebDriver driver) {
        WebElement table = driver.findElement(By.id("example1"));
        List<WebElement> getTr = table.findElements(By.tagName("tr"));
        Map<Integer, List> mainData = new HashMap<>();
        int i = 1;
        List<String> rowData = null;
        for (WebElement getTrRes : getTr) {
            List<WebElement> getTd = getTrRes.findElements(By.tagName("td"));
            rowData = new ArrayList<>();
            for (WebElement getTdRes : getTd) {
                rowData.add(getTdRes.getText());
            }
            if (rowData.isEmpty()) {
            } else {
                mainData.put(i, rowData);
            }
            i++;
        }
        return mainData;
    }
}
