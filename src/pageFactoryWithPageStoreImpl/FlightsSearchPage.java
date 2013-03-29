package pageFactoryWithPageStoreImpl;

import com.google.common.base.Function;
import domain.JourneyDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsSearchPage {
    WebDriver driver;

    @FindBy(id = "one_way")
    private WebElement oneWayJourneySelection;

    @FindBy(id = "rnd_trip")
    private WebElement returnTripJourneySelection;

    @FindBy(id = "dpt_date")
    private WebElement departureDateField;

    @FindBy(id = "rtn_date")
    private WebElement returnDateField;

    @FindBy(id = "origin_autocomplete")
    private WebElement originField;

    @FindBy(id = "destination_autocomplete")
    private WebElement destinationField;

    @FindBy(id = "button_flight_search")
    private WebElement searchButton;


    public FlightsSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseToHaveAOneWayJourney() {
        oneWayJourneySelection.click();
    }


    public void enterDepartureDateAs(String date) {
        departureDateField.clear();
        departureDateField.sendKeys(date);
    }

    public void enterReturnDateAs(String date) {
        returnDateField.clear();
        returnDateField.sendKeys(date);
    }


    public void enterDestinationAs(String destination) {
        destinationField.clear();
        destinationField.sendKeys(destination);
    }


    public void enterOriginAs(String origin) {
        originField.clear();
        originField.sendKeys(origin);
    }


    public void chooseToHaveAReturnJourney() {
        returnTripJourneySelection.click();
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

    public void searchForAOneWayJourneyWith(JourneyDetails journeyDetails) {
        this.chooseToHaveAOneWayJourney();

        this.enterOriginAs("Bangalore");
        this.selectTheFirstAvailableAutoCompleteOption();

        this.enterDestinationAs("Delhi");
        this.selectTheFirstAvailableAutoCompleteOption();

        this.enterDepartureDateAs(journeyDetails.getDepartureDate());
        searchButton.click();
    }

    public void searchForAReturnJourneyWith(JourneyDetails journeyDetails) {
        this.chooseToHaveAReturnJourney();

        this.enterOriginAs("Bangalore");
        this.selectTheFirstAvailableAutoCompleteOption();

        this.enterDestinationAs("Delhi");
        this.selectTheFirstAvailableAutoCompleteOption();

        this.enterDepartureDateAs(journeyDetails.getDepartureDate());
        this.enterReturnDateAs(journeyDetails.getReturnDate());
        searchButton.click();
    }


}
