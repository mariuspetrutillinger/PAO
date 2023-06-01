import java.time.LocalDate;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;


public class ResortService {
    private Set<Resort> resorts = new HashSet<Resort>();
    private static ResortService instance;
    Connection connection;

    private ResortService() {
        // Establish the database connection
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResortService getInstance() {
        if (instance == null) {
            instance = new ResortService();
        }
        return instance;
    }

    public void addResort(Resort resort) {
        String sql = "INSERT INTO resorts (ID_RESORT, NAME, LOCATION) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, resort.getId());
            statement.setString(2, resort.getName());
            statement.setString(3, resort.getLocation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeResort(Resort resort) {
        String sql = "DELETE FROM resorts WHERE ID_RESORT = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, resort.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Resort> getResorts() {
        Set<Resort> resorts = new HashSet<>();
        String sql = "SELECT * FROM resorts";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_RESORT");
                String name = resultSet.getString("NAME");
                String location = resultSet.getString("LOCATION");
                Resort resort = new Resort(id, name, location);
                resorts.add(resort);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resorts;
    }

    public Resort getResortById(int id) {
        String sql = "SELECT * FROM resorts WHERE ID_RESORT = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String location = resultSet.getString("LOCATION");
                    return new Resort(id, name, location);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Resort> getResortByName(String name) {
        List<Resort> resorts = new ArrayList<>();
        String sql = "SELECT * FROM resorts WHERE NAME = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_RESORT");
                    String location = resultSet.getString("LOCATION");
                    Resort resort = new Resort(id, name, location);
                    resorts.add(resort);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resorts;
    }

//    public List<Resort> getResortByLocation(String location) {
//        List<Resort> resorts = new ArrayList<>();
//        String sql = "SELECT * FROM resorts WHERE LOCATION = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, location);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("ID_RESORT");
//                    String name = resultSet.getString("NAME");
//                    Resort resort = new Resort(id, name, location);
//                    resorts.add(resort);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resorts;
//    }
}
