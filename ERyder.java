public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder() {
        bikeID = "Unknown";
        batteryLevel = 0;
        isAvailable = false;
        kmDriven = 0.0;
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
    }

    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("自行车可用");
        } else {
            System.out.println("自行车不可用");
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

}