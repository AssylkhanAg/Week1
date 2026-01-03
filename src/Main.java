import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransportManager manager = new TransportManager();

        manager.addVehicle(new Bus("777SSS", 84, 100, 55, "Test One", "On road"));
        manager.addVehicle(new Bus("999AAA", 12, 60, 10, "Test Two", "Garage"));

        System.out.println("Welcome to Transport Management System");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a Bus");
            System.out.println("2. Show all Vehicles");
            System.out.println("3. Sort by Plate Number");
            System.out.println("4. Sort by Capacity");
            System.out.println("5. Search by Plate");
            System.out.println("6. Filter by Status");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Plate Number: ");
                String plate = scanner.nextLine();
                System.out.print("Enter Route ID: ");
                int route = scanner.nextInt();
                System.out.print("Enter Capacity: ");
                int cap = scanner.nextInt();
                System.out.print("Enter Occupancy: ");
                int occ = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Driver Name: ");
                String driver = scanner.nextLine();
                System.out.print("Enter Status: ");
                String status = scanner.nextLine();

                Vehicle newBus = new Bus(plate, route, cap, occ, driver, status);
                manager.addVehicle(newBus);
                System.out.println("Bus added successfully.");

            } else if (choice == 2) {
                manager.printFleet();

            } else if (choice == 3) {
                manager.sortVehiclesByPlate();
                System.out.println("Sorted by Plate Number:");
                manager.printFleet();

            } else if (choice == 4) {
                manager.sortVehiclesByCapacity();
                System.out.println("Sorted by Capacity:");
                manager.printFleet();

            } else if (choice == 5) {
                System.out.print("Enter Plate to search: ");
                String searchPlate = scanner.nextLine();
                Vehicle found = manager.searchByPlate(searchPlate);
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("Vehicle not found.");
                }

            } else if (choice == 6) {
                System.out.print("Enter Status to filter (e.g., 'On road'): ");
                String filterStatus = scanner.nextLine();
                List<Vehicle> filtered = manager.filterByStatus(filterStatus);
                System.out.println("--- Filtered Results ---");
                for(Vehicle v : filtered) {
                    System.out.println(v);
                }

            } else if (choice == 7) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}