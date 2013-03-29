package scenarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;


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
		
		driver.findElement(By.id("destination_autocomplete")).clear();
		driver.findElement(By.id("destination_autocomplete")).sendKeys("Delhi");
		
		//wait for the auto complete options to appear for the destination
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(1, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		
		 WebElement optionListElement1 = wait1.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("autocompleteOptionsContainer"));
		     }
		   });
		
		//select the first item from the destination auto complete list
		WebElement destinationOptionsList = optionListElement1;
		List<WebElement> destinationOptions = destinationOptionsList.findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		
		driver.findElement(By.id("dpt_date")).clear();
		driver.findElement(By.id("dpt_date")).sendKeys(tomorrow());
		
		//all fields filled in. Now click on search
		driver.findElement(By.id("button_flight_search")).click();

        waitForSearchResultsToAppear();
		//verify that result appears for the provided journey search
	    Assert.assertTrue(isElementPresent(By.id("outbound")));
		
		//close the browser
		driver.close();
		
	}


    public void waitForSearchResultsToAppear() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.id("mod_link")));
    }

    public ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement toReturn = driver.findElement(locator);
                if (toReturn.isDisplayed()) {
                    return toReturn;
                }
                return null;
            }
        };
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
