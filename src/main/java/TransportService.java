import java.sql.SQLException;

public class TransportService {
    private TransportManager manager;
    private BusDAO busDAO;

    public TransportService(TransportManager manager) {
        this.manager = manager;
        this.busDAO = new BusDAO();
    }

    public void boardPassenger(String plate_num, Passenger passenger) {
        Bus bus = manager.searchByPlate(plate_num);

        if (bus == null) {
            System.out.println("Error: Bus with plate " + plate_num + " not found.");
            return;
        }

        if (bus.getOccupancy() < bus.getCapacity()) {
            bus.addPassenger(passenger);

            try {
                busDAO.updateBus(bus);
                System.out.println("Success: Passenger " + passenger.getName() + " boarded.");
            } catch (SQLException e) {
                System.out.println("Database sync failed: " + e.getMessage());
            }
        } else {
            System.out.println("Boarding failed: Bus " + plate_num + " is full.");
        }
    }

    public void changeBusStatus(String plate_num, String newStatus) {
        Bus bus = manager.searchByPlate(plate_num);

        if (bus != null) {
            bus.setStatus(newStatus);
            try {
                busDAO.updateBus(bus);
                System.out.println("Status updated to: " + newStatus);
            } catch (SQLException e) {
                System.out.println("DB Update failed: " + e.getMessage());
            }
        } else {
            System.out.println("Bus not found.");
        }
    }

    public void printBusReport(String plate_num) {
        Bus bus = manager.searchByPlate(plate_num);
        if (bus != null) {
            bus.showInfo();
        } else {
            System.out.println("No record for bus: " + plate_num);
        }
    }
}