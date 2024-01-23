package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    public static List<WebElement> getSingleCols(WebDriver driver, String arg0, int rowcount, WebElement getNextBtn) {
        boolean eq = false;
        List<WebElement> Columns_rows = null;
        while (!eq) {
            WebElement table = driver.findElement(By.id("example1"));
            List<WebElement> getRow = table.findElements(By.tagName("tr"));
            for (int i = 1; i < getRow.size(); i++) {
                if (!eq) {
                    List<WebElement> Columns_row = getRow.get(i).findElements(By.tagName("td"));
                    if (Columns_row.get(rowcount).getText().equals(arg0)) {
                        Columns_rows = Columns_row;
                        eq = true;
                    }
                } else {
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
        return Columns_rows;
    }
}
