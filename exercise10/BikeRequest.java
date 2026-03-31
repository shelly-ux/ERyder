import java.time.LocalDateTime;

public class BikeRequest {

    private String userEmail;

    private String location;

    private LocalDateTime requestTime;


    public BikeRequest(String userEmail, String location, LocalDateTime requestTime) {
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }


    @Override
    public String toString() {
        String timeStr = requestTime.toString().replace('T', ' ');
        return String.format("用户%s 在 %s 于 %s 请求租赁车辆",
                userEmail, location, timeStr);
    }
}