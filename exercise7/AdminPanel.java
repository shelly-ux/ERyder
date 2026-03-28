import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AdminPanel {

    private ArrayList<RegisteredUsers> registeredUsersList = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);


    public void userManagementOptions() {
        while (true) {
            System.out.println("\n=====================================");
            System.out.println("    Welcome to E-Ryder Admin Panel");
            System.out.println("=====================================");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Please enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewUsers();
                    break;
                case 2:
                    viewRegisteredUsers();
                    break;
                case 3:
                    removeRegisteredUsers();
                    break;
                case 4:
                    updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("\nProgram exited. Goodbye!");
                    return;
                default:
                    System.out.println("\nInvalid choice! Please try again (1-5).");
            }
        }
    }


    private void addNewUsers() {
        System.out.println("\n--- Add New User ---");
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        System.out.print("Enter Card Number: ");
        String cardNum = scanner.nextLine();

        System.out.print("Enter Card Expiry Date (MM/YY): ");
        String cardExp = scanner.nextLine();

        System.out.print("Enter Card Provider (e.g., Visa): ");
        String cardProvider = scanner.nextLine();

        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();

        System.out.print("Enter User Type (Rider/Driver): ");
        String userType = scanner.nextLine();


        String[] trips = new String[3];
        System.out.println("\nEnter last three trips (enter 'none' if no trips):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Trip " + (i+1) + ": ");
            trips[i] = scanner.nextLine();
        }


        RegisteredUsers newUser = new RegisteredUsers(fullName, email, dob, cardNum, cardExp,
                cardProvider, cvv, userType, trips);
        registeredUsersList.add(newUser);
        System.out.println("\n✅ User added successfully!");
    }


    private void viewRegisteredUsers() {
        System.out.println("\n--- All Registered Users ---");
        if (registeredUsersList.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }

        int count = 1;
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println("\nUser " + count + ":");
            System.out.println("Name: " + user.getFullName());
            System.out.println("Email: " + user.getEmailAddress());
            System.out.println("User Type: " + user.getUserType());
            System.out.println("Last Three Trips:");
            for (String trip : user.getLastThreeTrips()) {
                System.out.println("  - " + trip);
            }
            count++;
        }
    }


    private void removeRegisteredUsers() {
        System.out.println("\n--- Remove User ---");
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove.");
            return;
        }

        System.out.print("Enter email of user to remove: ");
        String email = scanner.nextLine();

        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                found = true;
                System.out.println("\n✅ User removed successfully!");
            }
        }

        if (!found) {
            System.out.println("\n❌ No user found with this email address.");
        }
    }


    private void updateRegisteredUsers() {
        System.out.println("\n--- Update User ---");
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to update.");
            return;
        }

        System.out.print("Enter email of user to update: ");
        String email = scanner.nextLine();
        boolean found = false;

        for (RegisteredUsers user : registeredUsersList) {
            if (user.getEmailAddress().equals(email)) {
                found = true;
                System.out.println("\nEnter new details for the user:");

                System.out.print("New Full Name: ");
                user.setFullName(scanner.nextLine());

                System.out.print("New Date of Birth (YYYY-MM-DD): ");
                user.setDateOfBirth(scanner.nextLine());

                System.out.print("New Card Number: ");
                user.setCardNumber(scanner.nextLine());

                System.out.print("New Card Expiry Date (MM/YY): ");
                user.setCardExpiryDate(scanner.nextLine());

                System.out.print("New Card Provider: ");
                user.setCardProvider(scanner.nextLine());

                System.out.print("New CVV: ");
                user.setCvv(scanner.nextLine());

                System.out.print("New User Type: ");
                user.setUserType(scanner.nextLine());


                String[] newTrips = new String[3];
                System.out.println("\nEnter new last three trips:");
                for (int i = 0; i < 3; i++) {
                    System.out.print("Trip " + (i+1) + ": ");
                    newTrips[i] = scanner.nextLine();
                }
                user.setLastThreeTrips(newTrips);

                System.out.println("\n✅ User updated successfully!");
            }
        }

        if (!found) {
            System.out.println("\n❌ No user found with this email address.");
        }
    }
}