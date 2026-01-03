import java.util.Objects;

public class Bus extends Vehicle {
    private int route;
    private int capacity;
    private int occupancy;

    public Bus(String plate_num, int route, int capacity, int occupancy, String driver, String status) {
        super(plate_num, driver, status);
        this.route = route;
        this.capacity = capacity;
        this.occupancy = occupancy;
    }

    public int getRoute() { return route; }
    public void setRoute(int route) { this.route = route; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getOccupancy() { return occupancy; }
    public void setOccupancy(int occupancy) { this.occupancy = occupancy; }

    @Override
    public String toString() {
        return "Bus [" + super.toString() + ", Route: " + route +
                ", Capacity: " + capacity + ", Occupancy: " + occupancy + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return route == bus.route && capacity == bus.capacity && occupancy == bus.occupancy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), route, capacity, occupancy);
    }
}