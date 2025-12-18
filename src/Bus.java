import java.util.Objects;

public class Bus {
    private String plate_num;
    private int route;
    private int capacity;
    private int occupancy;
    private String driver;
    private String status;

    public Bus(String plate_num, int route, int capacity, int occupancy, String driver, String status) {
        this.plate_num = plate_num;
        this.route = route;
        this.capacity = capacity;
        this.occupancy = occupancy;
        this.driver = driver;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "plate_num='" + plate_num + '\'' +
                ", route=" + route +
                ", capacity=" + capacity +
                ", occupancy=" + occupancy +
                ", driver='" + driver + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return route == bus.route && capacity == bus.capacity && occupancy == bus.occupancy && Objects.equals(plate_num, bus.plate_num) && Objects.equals(driver, bus.driver) && Objects.equals(status, bus.status);
    }
}
