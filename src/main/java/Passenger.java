public class Passenger {
    private int id;
    private String name;
    private int ticket_num;
    private int bus_id;

    public Passenger(String name, int ticket_num) {
        this.name = name;
        this.ticket_num = ticket_num;
    }

    public Passenger(int id, String name, int ticket_num, int bus_id) {
        this.id = id;
        this.name = name;
        this.ticket_num = ticket_num;
        this.bus_id = bus_id;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getTicket_num() { return ticket_num; }
    public int getBus_id() { return bus_id; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setTicket_num(int ticket_num) { this.ticket_num = ticket_num; }
    public void setBus_id(int bus_id) { this.bus_id = bus_id; }

    @Override
    public String toString() {
        return "Passenger: " + name + " | Ticket #: " + ticket_num;
    }
}