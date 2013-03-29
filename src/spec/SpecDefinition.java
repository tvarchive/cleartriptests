package spec;

import domain.JourneyDetails;
import org.testng.Assert;
import pageFactoryImpl.FlightsSearchPage;
import pageFactoryImpl.LandingPage;
import pageFactoryImpl.SearchResultsPage;


public class SpecDefinition {


    LandingPage onLandingPage;
    FlightsSearchPage onFlightsSearchPage;
    SearchResultsPage onResultsPage;

    public SpecDefinition(LandingPage onLandingPage) {
        this.onLandingPage = onLandingPage;
    }

    public SpecDefinition searchesForAOneWayJourneyWith(JourneyDetails journeyDetails) {
        onResultsPage = onFlightsSearchPage.searchForAOneWayJourneyWith(journeyDetails);
        return this;
    }


    public SpecDefinition hasJourneyOptionsAvailableForHisOutboundJourney() {
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());
        return this;
    }

    public SpecDefinition searchesForAReturnJourneyWith(JourneyDetails journeyDetails) {
        onResultsPage = onFlightsSearchPage.searchForAReturnJourneyWith(journeyDetails);
        return this;
    }

    public SpecDefinition hasJourneyOptionsAvailableForTheReturnJourney() {
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());
        Assert.assertTrue(onResultsPage.resultsAppearForInboundJourney());
        return this;
    }

    public SpecDefinition choosesToDoAFlightSearch() {
        onFlightsSearchPage = onLandingPage.goToFlightsSearchPage();
        return this;

    }
}
