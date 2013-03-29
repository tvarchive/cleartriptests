package scenarios;

import domain.JourneyDetails;
import domain.JourneyDetailsBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spec.SpecWithPageStoreImplementation;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Chapter_09_AbstractingPageNavigationFromUserSpecifications {

    // Use the application driver
    WebDriver driver;

    SpecWithPageStoreImplementation user ;
    PageStore pageStore;


    @BeforeMethod
      public void setup(){

        // initialize driver
        pageStore = new PageStore();
        user = new SpecWithPageStoreImplementation(pageStore);

        //launch the application under test
        driver = pageStore.getDriver();
        driver.get("http://www.cleartrip.com/");

        user.choosesToDoAFlightSearch();
    }

    @Test
    public void testThatResultsAppearForAOneWayJourney(){

        //create your test data - the journey detail domain object
        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(true).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(tomorrow()).build();


        user.searchesForAOneWayJourneyWith(journeyDetails);
        user.hasJourneyOptionsAvailableForHisOutboundJourney();


    }


    @Test
    public void testThatResultsAppearForAReturnJourney(){

        //create your test data - the journey detail domain object
        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(false).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(tomorrow()).withReturnDate(dayAfterTomorrow()).build();

        user.searchesForAReturnJourneyWith(journeyDetails);
        user.hasJourneyOptionsAvailableForTheReturnJourney();


    }


    @AfterMethod
    public void teardown(){
        //close the browser
        pageStore.destroy();

    }


    public String tomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }

    public String dayAfterTomorrow(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
    }



}
