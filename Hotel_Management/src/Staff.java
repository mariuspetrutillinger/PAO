public class Staff {
    private int id;
    private int resort_id;
    private String firstname;
    private String lastname;
    private String role;
    private static int nextId = 1;

    public Staff(int resort_id, String firstname, String lastname, String role) {
        this.id = ++nextId;
        this.resort_id = resort_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }
    public Staff(int id, int resort_id, String firstname, String lastname, String role) {
        this.id = id;
        this.resort_id = resort_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public int getResort_id() {
        return resort_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResort_id(int resort_id) {
        this.resort_id = resort_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", resort_id=" + resort_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
