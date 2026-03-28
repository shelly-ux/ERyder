import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class BikeRental {

    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;


    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private UserRegistration userReg = new UserRegistration();
    private ActiveRental activeRental;


    private String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equals(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;
    }


    private String analyseRequest(boolean isRegisteredUser, String emailAddress, String location) {
        if (isRegisteredUser) {
            System.out.println("Welcome back, " + emailAddress + "!");
        } else {
            System.out.println("You're not our registered user. Please consider registering.");
            userReg.registration();  // 调用注册方法
        }
        return validateLocation(location); // 调用地点验证
    }


    private void reserveBike(String bikeID) {
        if (bikeID != null) {
            for (Bike bike : BikeDatabase.bikes) {
                if (bike.getBikeID().equals(bikeID)) {
                    tripStartTime = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the " + bikeID + ". Please following the on-screen instructions to locate the bike and start your pleasant journey.");


                    activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        } else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
        }
    }


    public void viewActiveRentals() {
        System.out.println("Displaying the active rentals...");
        for (ActiveRental rental : activeRentalsList) {
            System.out.println(rental);
        }
    }


    private void removeTrip(String bikeID) {
        activeRentalsList.removeIf(rental -> rental.getBikeID().equals(bikeID));
    }


    public void simulateApplicationInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the simulation of the e-bike rental process.");


        System.out.print("Is registered user? (true/false): ");
        isRegisteredUser = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Email address: ");
        emailAddress = sc.nextLine();
        System.out.print("Location: ");
        location = sc.nextLine();


        System.out.println("Simulating the analysis of the rental request.");
        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if (!locationValid) return;


        System.out.println("Simulating e-bike reservation...");
        reserveBike(bikeID);


        viewActiveRentals();


        System.out.println("Simulating the end of the trip...");
        removeTrip(bikeID);


        System.out.println("Displaying the active rentals after trip end...");
        viewActiveRentals();
    }
}