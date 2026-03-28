import java.time.LocalDateTime;

public class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;

    // 全参构造器
    public ActiveRental(String bikeID, String userEmail, LocalDateTime tripStartTime) {
        this.bikeID = bikeID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }

    // Getter + toString()
    public String getBikeID() { return bikeID; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getTripStartTime() { return tripStartTime; }

    @Override
    public String toString() {
        return "ActiveRental{" + "bikeID='" + bikeID + '\'' + ", userEmail='" + userEmail + '\'' + ", tripStartTime=" + tripStartTime + '}';
    }
}