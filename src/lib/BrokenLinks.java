package lib;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void findBrokenLink(WebDriver driver) {
        try {
            List<WebElement> getAlllinks =driver.findElements(By.tagName("a"));
            if(!getAlllinks.isEmpty()){
                for (WebElement getAlllink : getAlllinks) {
                    String getURL = getAlllink.getAttribute("href");
                    URL url = new URL(getURL);
                    HttpURLConnection ht = (HttpURLConnection) url.openConnection();
                    ht.connect();
                    int getResponseCode = ht.getResponseCode();
                    if(getResponseCode>=400){
                        System.out.println(getURL + " Is a broken link");
                    }else {
//                        System.out.println(getURL + " Is not broken link");
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
