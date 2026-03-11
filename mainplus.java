public class mainplus {
    public static void main(String[] args) {
       
        ERyderplus bike1 = new ERyderplus("B001", 80, true, 10.5, "user1", "13800138000");
        
        bike1.printRideDetails(30);

        
        ERyderplus bike2 = new ERyderplus("user2", "13900139000");
        
        bike2.setBikeID("B002");
        bike2.setBatteryLevel(90);
        bike2.setAvailable(true);
        bike2.setKmDriven(15.2);
       
        bike2.printRideDetails(45);

       
    }
}