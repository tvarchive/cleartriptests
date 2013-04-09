package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsSearchPage;
import pages.LandingPage;
import pages.SearchResultsPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Chapter_05_IntroducingPageObjectModel {

    // Use the application driver
    WebDriver driver;
    LandingPage onLandingPage;
    FlightsSearchPage onFlightsSearchPage;
    SearchResultsPage onResultsPage;



    @BeforeMethod
      public void setup(){
        //launch the application under test
        driver = new AppDriver().getDriver();
        driver.get("http://www.cleartrip.com/");
        onLandingPage = new LandingPage(driver);
        onFlightsSearchPage = onLandingPage.goToFlightsSearchPage();

    }

    @Test
    public void testThatResultsAppearForAOneWayJourney(){

        onFlightsSearchPage.chooseToHaveAOneWayJourney();

        onFlightsSearchPage.enterOriginAs("Bangalore");
        onFlightsSearchPage.selectTheFirstAvailableAutoCompleteOption();

        onFlightsSearchPage.enterDestinationAs("Delhi");
        onFlightsSearchPage.selectTheFirstAvailableAutoCompleteOption();

        onFlightsSearchPage.enterDepartureDateAs(tomorrow());

        //all fields filled in. Now click on search
        onResultsPage = onFlightsSearchPage.searchForTheJourney();

        //verify that result appears for the provided journey search
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());

    }


    @Test
    public void testThatResultsAppearForAReturnJourney(){

        onFlightsSearchPage.chooseToHaveAReturnJourney();

        onFlightsSearchPage.enterOriginAs("Bangalore");
        onFlightsSearchPage.selectTheFirstAvailableAutoCompleteOption();

        onFlightsSearchPage.enterDestinationAs("Delhi");
        onFlightsSearchPage.selectTheFirstAvailableAutoCompleteOption();

        onFlightsSearchPage.enterDepartureDateAs(tomorrow());
        onFlightsSearchPage.enterReturnDateAs(dayAfterTomorrow());

        //all fields filled in. Now click on search

        onResultsPage = onFlightsSearchPage.searchForTheJourney();

        //verify that result appears for the provided journey search
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());
        Assert.assertTrue(onResultsPage.resultsAppearForInboundJourney());

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
