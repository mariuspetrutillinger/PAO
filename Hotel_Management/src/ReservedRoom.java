public class ReservedRoom extends Reservation {
    private int id;
    private Room room;
    private Date check_in;
    private Date check_out;

    public ReservedRoom(int reservation_number, int client_id, int id, Room room, Date check_in, Date check_out) {
        super(reservation_number, client_id);
        this.id = id;
        this.room = room;
        this.check_in = check_in;
        this.check_out = check_out;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

}
