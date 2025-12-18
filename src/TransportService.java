public class TransportService {
    private int route_id;
    private String busPlateNumber;
    private int ticket_cost;


    public TransportService(int route_id, String busPlateNumber, int ticket_cost) {
        this.route_id = route_id;
        this.busPlateNumber = busPlateNumber;
        this.ticket_cost = ticket_cost;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public String getBusPlateNumber() {
        return busPlateNumber;
    }

    public void setBusPlateNumber(String busPlateNumber) {
        this.busPlateNumber = busPlateNumber;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    @Override
    public String toString() {
        return "TransportService{" +
                "route_id=" + route_id +
                ", buses='" + busPlateNumber + '\'' +
                ", ticket_cost=" + ticket_cost +
                '}';
    }
}
