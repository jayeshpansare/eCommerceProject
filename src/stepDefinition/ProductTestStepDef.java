package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductTestStepDef extends BaseClass {
    @When("^view product is available$")
    public void view_product_is_available() {

    }

    @Then("^validate the product is present on list \"([^\"]*)\"$")
    public void validate_the_product_is_present_on_list(String arg1) {
        boolean eq = false;
        while (!eq) {
            WebElement table = getDriver().findElement(By.tagName("table"));
            List<WebElement> totalRows = table.findElements(By.tagName("tr"));
            for (int i = 1; i < totalRows.size(); i++) {
                System.out.println(totalRows.get(i).findElement(By.tagName("td")).getText());
//                if (!eq) {
//                    List<WebElement> Columns_row = totalRows.get(i).findElements(By.tagName("td"));
//                    if (Columns_row.get(2).getText().equals(arg1)) {
//                        eq = true;
//                        System.out.println(2 + " " + Columns_row.get(2).getText());
//                    } else {
//                        eq = false;
//                    }
//                }
            }

            if (!eq) {
                WebElement ele = getDriver().findElement(By.xpath("//li[@id=\"example1_next\"]/a"));
                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(ele));
                ele.click();
            } else {

            }
        }

    }
}
