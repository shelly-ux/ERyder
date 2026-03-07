             public class Main {
    public static void main(String[] args) {

        ERyder bike1 = new ERyder();
        System.out.println("Bike 1 (no-arg constructor):");
        bike1.printBikeDetails();

        ERyder bike2 = new ERyder("B001", 80, true, 150.5);
        System.out.println("\nBike 2 (parameterized constructor):");
        bike2.ride();
        bike2.printBikeDetails();
    }
}