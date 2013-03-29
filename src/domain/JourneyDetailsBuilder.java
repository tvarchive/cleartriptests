package domain;

public class JourneyDetailsBuilder {
    private Boolean oneWayJourney = true;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfAdultsTravelling = 1;
    private int numberOfChildrenTravelling = 0;
    private int numberOfInfantsTravelling = 0;

    public JourneyDetailsBuilder isOneWay(Boolean oneWayJourney) {
        this.oneWayJourney = oneWayJourney;
        return this;
    }

    public JourneyDetailsBuilder withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public JourneyDetailsBuilder withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public JourneyDetailsBuilder withDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public JourneyDetailsBuilder withReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public JourneyDetailsBuilder withNumberOfAdultsTravelling(int numberOfAdultsTravelling) {
        this.numberOfAdultsTravelling = numberOfAdultsTravelling;
        return this;
    }

    public JourneyDetailsBuilder withNumberOfChildrenTravelling(int numberOfChildrenTravelling) {
        this.numberOfChildrenTravelling = numberOfChildrenTravelling;
        return this;
    }

    public JourneyDetailsBuilder withNumberOfInfantsTravelling(int numberOfInfantsTravelling) {
        this.numberOfInfantsTravelling = numberOfInfantsTravelling;
        return this;
    }

    public JourneyDetails build() {
        return new JourneyDetails(oneWayJourney, origin, destination, departureDate, returnDate, numberOfAdultsTravelling, numberOfChildrenTravelling, numberOfInfantsTravelling);
    }
}