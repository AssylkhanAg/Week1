import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransportManager {
    private List<Bus> buses;
    private BusDAO busDAO;

    public TransportManager() {
        this.buses = new ArrayList<>();
        this.busDAO = new BusDAO();
        loadBusesFromDatabase();
    }

    private void loadBusesFromDatabase() {
        try {
            this.buses = busDAO.getAllBuses();
        } catch (SQLException e) {
            System.out.println("Error loading buses: " + e.getMessage());
        }
    }

    public void addBus(Bus bus) {
        try {
            busDAO.insertBus(bus);
            buses.add(bus);
            System.out.println("Bus added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding bus to DB: " + e.getMessage());
        }
    }

    public void removeBus(String plate_num) {
        try {
            busDAO.deleteBus(plate_num); // Remove from DB
            buses.removeIf(b -> b.getPlate_num().equals(plate_num)); // Remove from local list
            System.out.println("Bus removed successfully.");
        } catch (SQLException e) {
            System.out.println("Error removing bus: " + e.getMessage());
        }
    }

    public void updateBusStatus(String plate_num, String newStatus, int newOccupancy) {
        try {
            Bus bus = searchByPlate(plate_num);
            if (bus != null) {
                bus.setStatus(newStatus);
                bus.setOccupancy(newOccupancy);
                busDAO.updateBus(bus);
                System.out.println("Bus updated successfully.");
            } else {
                System.out.println("Bus not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating bus: " + e.getMessage());
        }
    }


    public Bus searchByPlate(String plate_num) {
        for (Bus b : buses) {
            if (b.getPlate_num().equalsIgnoreCase(plate_num)) {
                return b;
            }
        }
        return null;
    }

    public void sortBusesByPlate() {
        Collections.sort(buses);
        System.out.println("Buses sorted by plate number.");
    }

    public void displayAllBuses() {
        if (buses.isEmpty()) {
            System.out.println("No buses in the system.");
        } else {
            System.out.println("\n--- Current Bus List ---");
            for (Bus b : buses) {
                System.out.println(b);
            }
        }
    }
}