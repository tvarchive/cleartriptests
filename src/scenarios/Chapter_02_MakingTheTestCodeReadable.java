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

public class Chapter_02_MakingTheTestCodeReadable {

    WebDriver driver = new FirefoxDriver();
    

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        driver.get("http://www.cleartrip.com/");
        chooseToHaveAOneWayJourney();

        enterOriginAs("Bangalore");
        selectTheFirstAvailableAutoCompleteOptionForOrigin();

        enterDestinationAs("Delhi");
        selectTheFirstAvailableAutoCompleteOptionForDestination();

        enterDepartureDate();

        //all fields filled in. Now click on search
        searchForTheJourney();
        waitForSearchResultsToAppear();

        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
        driver.close();

    }


    private void selectTheFirstAvailableAutoCompleteOptionForOrigin() {
    	//select the first item from the auto complete list
        waitFor(2000);
        List<WebElement> optionsList = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        optionsList.get(0).click();
		
	}


	public String dayAfterTomorrow() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }

    private void searchForTheJourney() {
        driver.findElement(By.id("SearchBtn")).click();


    }

    public void waitForSearchResultsToAppear() {
        waitFor(5000);
    }


    private void enterDepartureDate() {
    	driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

    }


    private void enterDestinationAs(String destination) {
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys(destination);
    }


    private void enterOriginAs(String origin) {
        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys(origin);
    }


    private void chooseToHaveAOneWayJourney() {
        driver.findElement(By.id("OneWay")).click();
    }


    private void selectTheFirstAvailableAutoCompleteOptionForDestination() {
    	
        //select the first item from the auto complete list
        waitFor(2000);
        List<WebElement> optionsList = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        optionsList.get(0).click();
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

    public String tomorrow() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }


}
