import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    public void insertBus(Bus bus) throws SQLException {
        String query = "INSERT INTO bus (plate_num, driver, status, route, capacity, occupancy) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, bus.getPlate_num());
            pstmt.setString(2, bus.getDriver());
            pstmt.setString(3, bus.getStatus());
            pstmt.setInt(4, bus.getRoute());
            pstmt.setInt(5, bus.getCapacity());
            pstmt.setInt(6, bus.getOccupancy());

            pstmt.executeUpdate();
            System.out.println("Bus added to database successfully.");
        }
    }

    public List<Bus> getAllBuses() throws SQLException {
        List<Bus> buses = new ArrayList<>();
        String query = "SELECT * FROM bus";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Bus bus = new Bus(
                        rs.getString("plate_num"),
                        rs.getString("driver"),
                        rs.getString("status"),
                        rs.getInt("route"),
                        rs.getInt("capacity"),
                        rs.getInt("occupancy")
                );
                buses.add(bus);
            }
        }
        return buses;
    }

    public void updateBus(Bus bus) throws SQLException {
        String query = "UPDATE bus SET driver = ?, status = ?, route = ?, capacity = ?, occupancy = ? WHERE plate_num = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, bus.getDriver());
            pstmt.setString(2, bus.getStatus());
            pstmt.setInt(3, bus.getRoute());
            pstmt.setInt(4, bus.getCapacity());
            pstmt.setInt(5, bus.getOccupancy());
            pstmt.setString(6, bus.getPlate_num());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bus " + bus.getPlate_num() + " updated successfully.");
            }
        }
    }

    public void deleteBus(String plate_num) throws SQLException {
        String query = "DELETE FROM bus WHERE plate_num = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, plate_num);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Bus " + plate_num + " deleted successfully.");
            } else {
                System.out.println("No bus found with that plate number.");
            }
        }
    }

    public Bus searchByPlate(String plate_num) throws SQLException {
        String query = "SELECT * FROM bus WHERE plate_num = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, plate_num);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Bus(
                            rs.getString("plate_num"),
                            rs.getString("driver"),
                            rs.getString("status"),
                            rs.getInt("route"),
                            rs.getInt("capacity"),
                            rs.getInt("occupancy")
                    );
                }
            }
        }
        return null;
    }
}