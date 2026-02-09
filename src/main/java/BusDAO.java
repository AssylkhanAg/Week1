import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    public boolean insertBus(Bus bus) throws SQLException {
        Connection conn = DatabaseConnection.connect();
        String sql = "INSERT INTO bus (route, capacity, occupancy, plate_num, driver, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bus.getRoute());
            stmt.setInt(2, bus.getCapacity());
            stmt.setInt(3, bus.getOccupancy());
            stmt.setString(4, bus.getPlate_num());
            stmt.setString(5, bus.getDriver());
            stmt.setString(6, bus.getStatus());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to be caught in the controller
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

    public boolean updateBus(Bus bus) throws SQLException {
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
            return rowsAffected > 0; // Return true if at least one row was updated
        }
    }

    public boolean deleteBus(String plate_num) throws SQLException {
        String query = "DELETE FROM bus WHERE plate_num = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, plate_num);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0; // Return true if the bus was deleted
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