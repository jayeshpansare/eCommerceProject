package lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    static String projectPath = System.getProperty("user.dir");
    public static WebDriver driver;

    public void initBrowser(String env, String browser) throws IOException {
        String adminURL = readProperty().getProperty("adminURL");
        String webURL = readProperty().getProperty("webURL");

        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.getBrowserName();
                options.getBrowserVersion();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.addArguments("--incognito");
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }

        switch(env){
            case "admin":
                driver.get(adminURL);
                driver.manage().window().maximize();
                break;
            case "site":
                driver.get(webURL);
                driver.manage().window().maximize();
                break;
            default:
                driver.get(webURL);
                driver.manage().window().maximize();
                break;
        }



    }

    public WebDriver getDriver() {
        return driver;
    }

    public static Properties readProperty() throws IOException {
        File file = new File(projectPath + "/src/config/config.properties");
        FileInputStream fin = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fin);
        return prop;
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
