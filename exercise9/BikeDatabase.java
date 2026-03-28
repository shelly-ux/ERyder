import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BikeDatabase {
    private List<Bike> bikes;

    public BikeDatabase() {
        bikes = new ArrayList<>();
        bikes.add(new Bike("B001", true, 80, LocalDateTime.now(), "A区"));
        bikes.add(new Bike("B002", true, 90, LocalDateTime.now(), "B区"));
        bikes.add(new Bike("B003", false, 50, LocalDateTime.now(), "C区"));
    }

    public List<Bike> getAllBikes() {
        return bikes;
    }

    public List<Bike> getAvailableBikes() {
        List<Bike> res = new ArrayList<>();
        for (Bike b : bikes) {
            if (b.isAvailable()) res.add(b);
        }
        return res;
    }

    public Bike getBikeById(String id) {
        for (Bike b : bikes) {
            if (b.getBikeId().equals(id)) return b;
        }
        return null;
    }

    public boolean isValidLocation(String location) {
        return location.equals("A区") || location.equals("B区") || location.equals("C区");
    }
}