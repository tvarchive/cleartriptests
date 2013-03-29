package pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsSearchPage {
    WebDriver driver;

    public FlightsSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseToHaveAOneWayJourney() {
        driver.findElement(By.id("one_way")).click();
    }

    public void enterDepartureDateAs(String date) {
        driver.findElement(By.id("dpt_date")).clear();
        driver.findElement(By.id("dpt_date")).sendKeys(date);
    }

    public void enterReturnDateAs(String date) {
        driver.findElement(By.id("rtn_date")).clear();
        driver.findElement(By.id("rtn_date")).sendKeys(date);
    }


    public void enterDestinationAs(String destination) {
        driver.findElement(By.id("destination_autocomplete")).clear();
        driver.findElement(By.id("destination_autocomplete")).sendKeys(destination);
    }


    public void enterOriginAs(String origin) {
        driver.findElement(By.id("origin_autocomplete")).clear();
        driver.findElement(By.id("origin_autocomplete")).sendKeys(origin);
    }




    public void chooseToHaveAReturnJourney() {
        driver.findElement(By.id("rnd_trip")).click();
    }


    public void selectTheFirstAvailableAutoCompleteOption() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("autocompleteOptionsContainer"));
            }
        });

        //select the first item from the auto complete list
        WebElement originOptionsElement = optionListElement;
        List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
        originOptions.get(0).click();
    }

    public SearchResultsPage searchForTheJourney() {
        driver.findElement(By.id("button_flight_search")).click();
        return new SearchResultsPage(driver);
    }

}
