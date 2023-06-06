package AppServices;

import Models.Staff;

import java.sql.*;
import java.util.*;

public class StaffService {
    private Connection connection;
    private static StaffService instance;

    private StaffService() {
        // Establish the database connection
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static StaffService getInstance() {
        if (instance == null) {
            instance = new StaffService();
        }
        return instance;
    }

    public void addStaff(Staff staff) {
        String sql = "INSERT INTO staff (ID_STAFF, RESORT_ID, FIRST_NAME, LAST_NAME, ROLE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staff.getId());
            statement.setInt(2, staff.getResort_id());
            statement.setString(3, staff.getFirstname());
            statement.setString(4, staff.getLastname());
            statement.setString(5, staff.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStaff(Staff staff) {
        String sql = "DELETE FROM staff WHERE ID_STAFF = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staff.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Staff> getStaff() {
        SortedSet<Staff> staffMembers = new TreeSet<>(Comparator.comparing(Staff::getId));
        String sql = "SELECT * FROM staff ORDER BY ID_STAFF ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_STAFF");
                int resortId = resultSet.getInt("RESORT_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String role = resultSet.getString("ROLE");
                Staff staff = new Staff(id, resortId, firstName, lastName, role);
                staffMembers.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffMembers;
    }

    public Staff getStaffById(int id) {
        String sql = "SELECT * FROM staff WHERE ID_STAFF = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int resortId = resultSet.getInt("RESORT_ID");
                    String firstName = resultSet.getString("FIRST_NAME");
                    String lastName = resultSet.getString("LAST_NAME");
                    String role = resultSet.getString("ROLE");
                    return new Staff(id, resortId, firstName, lastName, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Staff> getStaffByResortId(int resortId) {
        List<Staff> staffMembers = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE RESORT_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, resortId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_STAFF");
                    String firstName = resultSet.getString("FIRST_NAME");
                    String lastName = resultSet.getString("LAST_NAME");
                    String role = resultSet.getString("ROLE");
                    Staff staff = new Staff(id, resortId, firstName, lastName, role);
                    staffMembers.add(staff);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffMembers;
    }

    public List<Staff> getStaffByName(String firstName, String lastName) {
        List<Staff> staffMembers = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE FIRST_NAME = ? AND LAST_NAME = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_STAFF");
                    int resortId = resultSet.getInt("RESORT_ID");
                    String role = resultSet.getString("ROLE");
                    Staff staff = new Staff(id, resortId, firstName, lastName, role);
                    staffMembers.add(staff);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffMembers;
    }

    public List<Staff> getStaffMembersByRole(String role) {
        List<Staff> staffMembers = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE ROLE = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, role);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_STAFF");
                    int resortId = resultSet.getInt("RESORT_ID");
                    String firstName = resultSet.getString("FIRST_NAME");
                    String lastName = resultSet.getString("LAST_NAME");
                    Staff staff = new Staff(id, resortId, firstName, lastName, role);
                    staffMembers.add(staff);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffMembers;
    }

    public void updateStaff(Staff staff) {
        if (getStaffById(staff.getId()) == null) {
            System.out.println("Client with ID " + staff.getId() + " does not exist.");
            return;
        }

        String sql = "UPDATE staff SET RESORT_ID = ?, FIRST_NAME = ?, LAST_NAME = ?, ROLE = ? WHERE ID_STAFF = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, staff.getResort_id());
            statement.setString(2, staff.getFirstname());
            statement.setString(3, staff.getLastname());
            statement.setString(4, staff.getRole());
            statement.setInt(5, staff.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
