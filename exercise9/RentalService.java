import java.util.List;

public class RentalService {
    private ActiveRental activeRental;
    private BikeService bikeService;

    public RentalService(ActiveRental ar, BikeService bs) {
        this.activeRental = ar;
        this.bikeService = bs;
    }

    public boolean startRental(String userId, String bikeId) {
        if (bikeService.reserveBike(bikeId)) {
            activeRental.addRental(userId, bikeId);
            return true;
        }
        return false;
    }

    public boolean endRental(String bikeId) {
        if (activeRental.removeRental(bikeId)) {
            return bikeService.releaseBike(bikeId);
        }
        return false;
    }
}