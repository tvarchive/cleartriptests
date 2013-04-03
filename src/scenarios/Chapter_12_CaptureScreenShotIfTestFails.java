package scenarios;

import domain.JourneyDetails;
import domain.JourneyDetailsBuilder;
import org.testng.annotations.Test;
import util.DateUtil;


public class Chapter_12_CaptureScreenShotIfTestFails extends BaseScenario {

    @Test
    public void testScreenShotCaptureWorksForAFailingTest(){

        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(false).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(new DateUtil().tomorrow()).withReturnDate(new DateUtil().dayAfterTomorrow()).build();

        given(user).choosesToDoAFlightSearch();
        when(user).searchesForAOneWayJourneyWith(journeyDetails);
        then(user).hasJourneyOptionsAvailableForTheReturnJourney();

    }


}
