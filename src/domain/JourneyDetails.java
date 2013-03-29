package domain;

/**
 * Created with IntelliJ IDEA.
 * User: Sukeshk
 * Date: 09/03/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class JourneyDetails {

    private Boolean isOneWayJourney;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfAdultsTravelling;
    private int numberOfChildrenTravelling;
    private int numberOfInfantsTravelling;

    public JourneyDetails(Boolean oneWayJourney, String origin, String destination, String departureDate, String returnDate, int numberOfAdultsTravelling, int numberOfChildrenTravelling, int numberOfInfantsTravelling) {
        isOneWayJourney = oneWayJourney;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfAdultsTravelling = numberOfAdultsTravelling;
        this.numberOfChildrenTravelling = numberOfChildrenTravelling;
        this.numberOfInfantsTravelling = numberOfInfantsTravelling;
    }

    public Boolean isOneWayJourney() {
        return isOneWayJourney;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getNumberOfAdultsTravelling() {
        return numberOfAdultsTravelling;
    }

    public int getNumberOfChildrenTravelling() {
        return numberOfChildrenTravelling;
    }

    public int getNumberOfInfantsTravelling() {
        return numberOfInfantsTravelling;
    }
}
