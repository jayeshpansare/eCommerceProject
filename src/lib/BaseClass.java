package lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    static String projectPath = System.getProperty("user.dir");
    public static WebDriver driver;
    @BeforeSuite
    public void initBrowser() throws IOException {
        String webURL = readProperty().getProperty("URL");
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.getBrowserName();
        options.getBrowserVersion();
//        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.get(webURL);
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){
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
    public void tearDown(){
//        driver.quit();
    }
}
