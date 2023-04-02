import java.time.LocalDate;

public class ReservedRoom extends Reservation {
    private Room room;
    private LocalDate check_in;
    private LocalDate check_out;

    public ReservedRoom(int reservation_number, int client_id, Room room, LocalDate check_in, LocalDate check_out) {
        super(reservation_number, client_id);
        this.room = room;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalDate check_in) {
        this.check_in = check_in;
    }

    public LocalDate getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalDate check_out) {
        this.check_out = check_out;
    }

}
