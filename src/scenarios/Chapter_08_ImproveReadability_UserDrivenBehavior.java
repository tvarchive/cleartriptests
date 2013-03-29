package scenarios;

import domain.JourneyDetails;
import domain.JourneyDetailsBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactoryImpl.LandingPage;
import spec.SpecDefinition;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Chapter_08_ImproveReadability_UserDrivenBehavior {

    // Use the application driver
    WebDriver driver;
    LandingPage onLandingPage;

    SpecDefinition user ;



    @BeforeMethod
      public void setup(){
        //launch the application under test
        driver = new AppDriver().getDriver();
        driver.get("http://www.cleartrip.com/");
        onLandingPage = PageFactory.initElements(driver, LandingPage.class);

        user = new SpecDefinition(onLandingPage);

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
        driver.close();

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
