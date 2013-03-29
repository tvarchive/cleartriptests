package spec;

import domain.JourneyDetails;
import org.testng.Assert;
import pageFactoryWithPageStoreImpl.FlightsSearchPage;
import pageFactoryWithPageStoreImpl.LandingPage;
import pageFactoryWithPageStoreImpl.SearchResultsPage;
import scenarios.PageStore;


public class SpecWithPageStoreImplementation {


    LandingPage onLandingPage;
    FlightsSearchPage onFlightsSearchPage;
    SearchResultsPage onResultsPage;
    PageStore pageStore;


    public SpecWithPageStoreImplementation(PageStore pageStore) {
        this.pageStore = pageStore;
    }


    public SpecWithPageStoreImplementation(LandingPage onLandingPage) {
        this.onLandingPage = onLandingPage;
    }

    public void searchesForAOneWayJourneyWith(JourneyDetails journeyDetails) {
        FlightsSearchPage onFlightsSearchPage = pageStore.get(FlightsSearchPage.class);
        onFlightsSearchPage.searchForAOneWayJourneyWith(journeyDetails);
    }


    public void hasJourneyOptionsAvailableForHisOutboundJourney() {
        Assert.assertTrue(pageStore.get(SearchResultsPage.class).resultsAppearForOutboundJourney());
    }

    public void searchesForAReturnJourneyWith(JourneyDetails journeyDetails) {
        FlightsSearchPage onFlightsSearchPage = pageStore.get(FlightsSearchPage.class);
        onFlightsSearchPage.searchForAReturnJourneyWith(journeyDetails);
    }

    public void hasJourneyOptionsAvailableForTheReturnJourney() {
        SearchResultsPage onResultsPage = pageStore.get(SearchResultsPage.class);
        Assert.assertTrue(onResultsPage.resultsAppearForOutboundJourney());
        Assert.assertTrue(onResultsPage.resultsAppearForInboundJourney());
    }

    public void choosesToDoAFlightSearch() {
        LandingPage onLandingPage = pageStore.get(LandingPage.class);
        onLandingPage.goToFlightsSearchPage();
    }
}
