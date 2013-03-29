package pageFactoryImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

    WebDriver driver;

    @FindBy(linkText = "Flights")
    private WebElement flightsPageLink;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }



    public FlightsSearchPage goToFlightsSearchPage() {
        flightsPageLink.click();
        FlightsSearchPage flightsSearchPage = PageFactory.initElements(driver, FlightsSearchPage.class);
        return flightsSearchPage;
    }
}
