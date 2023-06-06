package AppServices;

import Models.Resort;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResortService {
    private SortedSet<Resort> resorts = new TreeSet<>(Comparator.comparing(Resort::getId));
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
        SortedSet<Resort> resorts = new TreeSet<>(Comparator.comparing(Resort::getId));
        String sql = "SELECT * FROM resorts ORDER BY ID_RESORT";
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

    public void updateResort(Resort resort) {
        // Check if the resort exists
        if (getResortById(resort.getId()) == null) {
            System.out.println("Resort with ID " + resort.getId() + " does not exist.");
            return;
        }

        String sql = "UPDATE resorts SET NAME = ?, LOCATION = ? WHERE ID_RESORT = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, resort.getName());
            statement.setString(2, resort.getLocation());
            statement.setInt(3, resort.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Models.Resort> getResortByLocation(String location) {
//        List<Models.Resort> resorts = new ArrayList<>();
//        String sql = "SELECT * FROM resorts WHERE LOCATION = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setString(1, location);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("ID_RESORT");
//                    String name = resultSet.getString("NAME");
//                    Models.Resort resort = new Models.Resort(id, name, location);
//                    resorts.add(resort);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resorts;
//    }
}
