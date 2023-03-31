public class Bill {
    private int id;
    private Reservation reservation;

    public Bill(int id, Reservation reservation) {
        this.id = id;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
