import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TransportManager {

    private List<Vehicle> fleet;

    public TransportManager() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    public void printFleet() {
        if (fleet.isEmpty()) {
            System.out.println("No vehicles in the pool.");
        } else {
            for (Vehicle v : fleet) {
                System.out.println(v);
            }
        }
    }

    public void sortVehiclesByPlate() {
        Collections.sort(fleet);
    }

    public void sortVehiclesByCapacity() {
        Collections.sort(fleet, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                int cap1 = (v1 instanceof Bus) ? ((Bus) v1).getCapacity() : 0;
                int cap2 = (v2 instanceof Bus) ? ((Bus) v2).getCapacity() : 0;
                return Integer.compare(cap1, cap2);
            }
        });
    }

    public Vehicle searchByPlate(String plate) {
        for (Vehicle v : fleet) {
            if (v.getPlate_num().equalsIgnoreCase(plate)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehicle> filterByStatus(String status) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (v.getStatus().equalsIgnoreCase(status)) {
                filteredList.add(v);
            }
        }
        return filteredList;
    }
}