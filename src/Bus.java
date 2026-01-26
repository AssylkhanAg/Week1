import java.util.ArrayList;
import java.util.List;

public class Bus extends Vehicle {
    private int route;
    private int capacity;
    private int occupancy;
    private List<Passenger> passengers; // Kept from your original logic

    public Bus(String plate_num, String driver, String status, int route, int capacity, int occupancy) {
        super(plate_num, driver, status); // Passes info to Vehicle.java
        this.route = route;
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.passengers = new ArrayList<>();
    }

    public int getRoute() { return route; }
    public int getCapacity() { return capacity; }
    public int getOccupancy() { return occupancy; }
    public List<Passenger> getPassengers() { return passengers; }

    public void setRoute(int route) { this.route = route; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setOccupancy(int occupancy) { this.occupancy = occupancy; }

    public void addPassenger(Passenger passenger) {
        if (occupancy < capacity) {
            passengers.add(passenger);
            occupancy++;
            System.out.println("Passenger " + passenger.getName() + " added to bus " + getPlate_num());
        } else {
            System.out.println("Bus is at full capacity!");
        }
    }

    public void removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            occupancy--;
            System.out.println("Passenger " + passenger.getName() + " removed.");
        } else {
            System.out.println("Passenger not found on this bus.");
        }
    }

    @Override
    public String toString() {
        return "Bus Details: [" + super.toString() +
                " | Route: " + route +
                " | Load: " + occupancy + "/" + capacity + "]";
    }

    public void showInfo() {
        System.out.println(this.toString());
        if (!passengers.isEmpty()) {
            System.out.println("Current Passengers:");
            for (Passenger p : passengers) {
                System.out.println(" - " + p.getName());
            }
        }
    }
}