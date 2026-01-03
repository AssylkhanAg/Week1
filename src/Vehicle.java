import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {
    private String plate_num;
    private String driver;
    private String status;

    public Vehicle(String plate_num, String driver, String status) {
        this.plate_num = plate_num;
        this.driver = driver;
        this.status = status;
    }

    public String getPlate_num() { return plate_num; }
    public void setPlate_num(String plate_num) { this.plate_num = plate_num; }

    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Plate: " + plate_num + ", Driver: " + driver + ", Status: " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(plate_num, vehicle.plate_num) &&
                Objects.equals(driver, vehicle.driver) &&
                Objects.equals(status, vehicle.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate_num, driver, status);
    }

    // Natural Sorting by Plate Number
    @Override
    public int compareTo(Vehicle other) {
        return this.plate_num.compareTo(other.plate_num);
    }
}