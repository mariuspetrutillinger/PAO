public class Reservation {
    protected int reservation_number;
    protected int client_id;

    public Reservation() {}
    public Reservation(int reservation_number, int client_id) {
        this.reservation_number = reservation_number;
        this.client_id = client_id;
    }

    public int getReservation_number() {
        return reservation_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setId(int id) {
        this.reservation_number = id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
