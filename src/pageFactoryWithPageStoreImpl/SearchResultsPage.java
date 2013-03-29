package pageFactoryWithPageStoreImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean resultsAppearForInboundJourney() {
        waitForSearchResultsToAppear();
        return isElementPresent(By.id("return"));
    }

    public boolean resultsAppearForOutboundJourney() {
        waitForSearchResultsToAppear();
        return isElementPresent(By.id("outbound"));
    }



    private void waitForSearchResultsToAppear() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.id("mod_link")));
    }

    private ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
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

}
