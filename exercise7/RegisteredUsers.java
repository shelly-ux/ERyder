public class RegisteredUsers extends UserRegistration {

    private String[] lastThreeTrips;


    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                           String cardNumber, String cardExpiryDate, String cardProvider,
                           String cvv, String userType, String[] lastThreeTrips) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardExpiryDate, cardProvider, cvv, userType);
        this.lastThreeTrips = lastThreeTrips;
    }


    public String[] getLastThreeTrips() { return lastThreeTrips; }
    public void setLastThreeTrips(String[] lastThreeTrips) { this.lastThreeTrips = lastThreeTrips; }
}