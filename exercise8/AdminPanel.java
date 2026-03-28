public class AdminPanel {
    public static void main(String[] args) { // 或其他方法

        System.out.println("X. Demo the Bike Rental System");

        char choice = 'X';
        switch (choice) {
            case 'X':
                BikeRental bikeRental = new BikeRental();
                bikeRental.simulateApplicationInput();
                break;

        }
    }
}