import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle> {
    protected String plate_num;
    protected String driver;
    protected String status;

        public Vehicle(String plate_num, String driver, String status) {
        this.plate_num = plate_num;
        this.driver = driver;
        this.status = status;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public String getDriver() {
        return driver;
    }

    public String getStatus() {
        return status;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Vehicle other) {
        return this.plate_num.compareTo(other.plate_num);
    }

    @Override
    public String toString() {
        return "Plate Number: " + plate_num +
                " | Driver: " + (driver != null ? driver : "N/A") +
                " | Status: " + (status != null ? status : "Unknown");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(plate_num, vehicle.plate_num);
    }


    @Override
    public int hashCode() {
        return Objects.hash(plate_num);
    }
}