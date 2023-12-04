package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitAction {
    public void presenceOfElementLocatedEle(WebDriver driver, int duruation, By eleLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(duruation));
        wait.until(ExpectedConditions.presenceOfElementLocated(eleLocator));
    }
    public void expliciteWaitVisibilityEle(WebDriver driver, int duruation, By eleLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(duruation));
        wait.until(ExpectedConditions.visibilityOfElementLocated(eleLocator));
    }

    public void expliciteWaitEleClickable(WebDriver driver, int duruation, WebElement eleLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(duruation));
        wait.until(ExpectedConditions.elementToBeClickable(eleLocator));
    }

    public void expliciteWaitEleSelected(WebDriver driver, int duruation, WebElement eleLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(duruation));
        wait.until(ExpectedConditions.elementToBeSelected(eleLocator));
    }
    public void textToBePresentInElement(WebDriver driver, WebElement eleLocator, String txt, int duruation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(duruation));
        wait.until(ExpectedConditions.textToBePresentInElement(eleLocator, txt));
    }
}
