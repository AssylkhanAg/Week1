import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TransportManager manager = new TransportManager();
        TransportService service = new TransportService(manager);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Transport Management System ---");
            System.out.println("1. Add New Bus (Create)");
            System.out.println("2. Show All Buses (Read)");
            System.out.println("3. Search Bus by Plate");
            System.out.println("4. Update Bus Status (Update)");
            System.out.println("5. Delete a Bus (Delete)");
            System.out.println("6. Board a Passenger");
            System.out.println("7. Sort Buses by Plate");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Plate Number: "); String plate = scanner.nextLine();
                    System.out.print("Enter Driver Name: "); String driver = scanner.nextLine();
                    System.out.print("Enter Status: "); String status = scanner.nextLine();
                    System.out.print("Enter Route Number: "); int route = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Capacity: "); int cap = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Current Occupancy: "); int occ = Integer.parseInt(scanner.nextLine());
                    Bus newBus = new Bus(plate, driver, status, route, cap, occ);
                    manager.addBus(newBus);
                    break;

                case 2:
                    manager.displayAllBuses();
                    break;

                case 3:
                    System.out.print("Enter Plate Number: "); String searchPlate = scanner.nextLine();
                    Bus foundBus = manager.searchByPlate(searchPlate);
                    if (foundBus != null) {
                        foundBus.showInfo();
                    } else {
                        System.out.println("Bus not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Plate to Update: "); String upPlate = scanner.nextLine();
                    System.out.print("Enter New Status: "); String newStat = scanner.nextLine();
                    System.out.print("Enter New Occupancy: "); int newOcc = Integer.parseInt(scanner.nextLine());
                    manager.updateBusStatus(upPlate, newStat, newOcc);
                    break;

                case 5:
                    System.out.print("Enter Plate to Delete: "); String delPlate = scanner.nextLine();
                    manager.removeBus(delPlate);
                    break;

                case 6:
                    System.out.print("Enter Bus Plate: "); String bPlate = scanner.nextLine();
                    System.out.print("Passenger Name: "); String pName = scanner.nextLine();
                    int autoTicket = (int)(Math.random() * 90000) + 10000;
                    System.out.println("Generated Ticket Number: " + autoTicket);
                    Passenger p = new Passenger(pName, autoTicket);
                    service.boardPassenger(bPlate, new Passenger(pName, autoTicket));
                    break;

                case 7:
                    manager.sortBusesByPlate();
                    manager.displayAllBuses();
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}