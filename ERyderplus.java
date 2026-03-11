public class ERyderplus{
    // constant variables
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;
    //final variables
    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;
    //oringal
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    //add
    private int totalUsageInMinutes;
    private double totalFare;
    //DEfault Constructor
    public ERyderplus(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven,
                  String linkedAccount, String linkedPhoneNumber) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;

        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    
     }
    //Parameterized construction
    public ERyderplus(String linkedAccount, String linkedPhoneNumber) {
        
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
        
        this.bikeID = "Unknown";
        this.batteryLevel = 0;
        this.isAvailable = false;
        this.kmDriven = 0.0;
    }

    // ---------------- oringal ----------------
    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("bilkes are not available");
        } else {
            System.out.println("blikes are available");
        }
    }

    public void printBikeDetails() {
        System.out.println("=== Bike Details ===");
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Available: " + isAvailable);
        System.out.println("Total KM Driven: " + kmDriven);
        System.out.println("====================");
    }

    // Setters
    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Battery must be between 0-100. Set to 0.");
            this.batteryLevel = 0;
        }
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

    // Getters
    public String getBikeID() {
        return bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    // ---------------- new add  ----------------
    // pravite method:calculate the cost
    private double calculateFare(int usageInMinutes) {
        this.totalUsageInMinutes = usageInMinutes;
        this.totalFare = BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return totalFare;
    }

    // public method：print cycling details
    public void printRideDetails(int usageInMinutes) {
        // calculate the cost
        calculateFare(usageInMinutes);
        // print the required content
        System.out.println("=== Ride Details ===");
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Usage in Minutes: " + totalUsageInMinutes);
        System.out.println("Total Fare: $" + totalFare);
        System.out.println("====================");
    }
}