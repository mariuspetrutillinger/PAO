package Models;

public class Room extends RoomType {
    private int id;
    private int resort_id;

    public Room(int id, int resort_id, String description, int price) {
        super(description, price);
        this.id = id;
        this.resort_id = resort_id;
    }

    public int getId() {
        return id;
    }

    public int getResort_id() {
        return resort_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResort_id(int resort_id) {
        this.resort_id = resort_id;
    }

}
