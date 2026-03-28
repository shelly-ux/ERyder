import java.util.List;

public class BikeService {
    private BikeDatabase bikeDatabase;

    public BikeService(BikeDatabase db) {
        this.bikeDatabase = db;
    }

    public List<Bike> findAvailableBikes() {
        return bikeDatabase.getAvailableBikes();
    }

    public boolean validateLocation(String location) {
        return bikeDatabase.isValidLocation(location);
    }

    public boolean reserveBike(String bikeId) {
        Bike b = bikeDatabase.getBikeById(bikeId);
        if (b != null && b.isAvailable()) {
            b.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean releaseBike(String bikeId) {
        Bike b = bikeDatabase.getBikeById(bikeId);
        if (b != null && !b.isAvailable()) {
            b.setAvailable(true);
            return true;
        }
        return false;
    }
}