package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class Chapter_01_TheFirstSeleniumTest {



    // Change the driver as per your preferred browser
    WebDriver driver = new FirefoxDriver();

    @Test
    public void testThatResultsAppearForAOneWayJourney(){

        driver.get("http://www.cleartrip.com/");
        driver.findElement(By.id("one_way")).click();

        driver.findElement(By.id("origin_autocomplete")).clear();
        driver.findElement(By.id("origin_autocomplete")).sendKeys("Bangalore");

        //wait for the auto complete options to appear for the origin

        waitFor(2000);
        List<WebElement> originOptions = driver.findElement(By.id("autocompleteOptionsContainer")).findElements(By.tagName("li"));
        originOptions.get(0).click();

        driver.findElement(By.id("destination_autocomplete")).clear();
        driver.findElement(By.id("destination_autocomplete")).sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        waitFor(2000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("autocompleteOptionsContainer")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        driver.findElement(By.id("dpt_date")).clear();
        driver.findElement(By.id("dpt_date")).sendKeys(tomorrow());

        //all fields filled in. Now click on search
        driver.findElement(By.id("button_flight_search")).click();

        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.id("outbound")));

        //close the browser
        driver.close();

    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String tomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }
}
