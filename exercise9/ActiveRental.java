import java.util.List;
import java.util.ArrayList;

public class ActiveRental {
    private List<String> rentals;

    public ActiveRental() {
        rentals = new ArrayList<>();
    }

    public void addRental(String userId, String bikeId) {
        rentals.add(userId + "-" + bikeId);
    }

    public boolean removeRental(String bikeId) {
        for (int i = 0; i < rentals.size(); i++) {
            if (rentals.get(i).split("-")[1].equals(bikeId)) {
                rentals.remove(i);
                return true;
            }
        }
        return false;
    }
}