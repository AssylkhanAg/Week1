public class Main
{
    public static void main(String[] args) {
        Bus bus1 = new Bus("777SSS", 84, 100, 55, "Ardaq Bakhyt", "On road");
        Bus bus2 = new Bus("777SSS", 84, 100, 55, "Ardaq Bakhyt", "On road");
        Passenger pass1 = new Passenger("Zarina Daryn", 100011, 1, 84);
        TransportService ts = new TransportService(84, "777SSS", 120);

        System.out.println(bus1);
        System.out.println(pass1);
        System.out.println(ts);

        if (bus1.equals(bus2)) {
            System.out.println("The buses are the same.");
        } else {
            System.out.println("The buses are different.");
        }

    }}
