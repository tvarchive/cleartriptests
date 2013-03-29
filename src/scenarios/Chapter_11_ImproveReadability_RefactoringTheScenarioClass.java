package scenarios;

import domain.JourneyDetails;
import domain.JourneyDetailsBuilder;
import org.testng.annotations.Test;
import util.DateUtil;


public class Chapter_11_ImproveReadability_RefactoringTheScenarioClass extends BaseScenario {


    @Test
    public void testThatResultsAppearForAOneWayJourney(){

        //create your test data - the journey detail domain object
        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(true).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(new DateUtil().tomorrow()).build();

        given(user).choosesToDoAFlightSearch();
        when(user).searchesForAOneWayJourneyWith(journeyDetails);
        then(user).hasJourneyOptionsAvailableForHisOutboundJourney();
    }


    @Test
    public void testThatResultsAppearForAReturnJourney(){

        //create your test data - the journey detail domain object
        JourneyDetails journeyDetails = new JourneyDetailsBuilder().isOneWay(false).
                withOrigin("Bangalore").withDestination("Delhi").
                withDepartureDate(new DateUtil().tomorrow()).withReturnDate(new DateUtil().dayAfterTomorrow()).build();

        given(user).choosesToDoAFlightSearch();
        when(user).searchesForAReturnJourneyWith(journeyDetails);
        then(user).hasJourneyOptionsAvailableForTheReturnJourney();
    }


}
