import java.util.Objects;

public class Passenger {
    private int id;
    private String name;
    private int ticket_num;
    private int bus;

    public Passenger(String name, int id, int ticket_num, int bus) {
        this.name = name;
        this.id = id;
        this.ticket_num = ticket_num;
        this.bus = bus;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getTicket_num() { return ticket_num; }
    public void setTicket_num(int ticket_num) { this.ticket_num = ticket_num; }
    public int getBus() { return bus; }
    public void setBus(int bus) { this.bus = bus; }

    @Override
    public String toString() {
        return "Passenger{id=" + id + ", name='" + name + "', ticket_num=" + ticket_num + ", bus=" + bus + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id && ticket_num == passenger.ticket_num &&
                bus == passenger.bus && Objects.equals(name, passenger.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ticket_num, bus);
    }
}