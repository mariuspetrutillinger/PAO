package AppServices;

import Models.Client;

import java.time.LocalDate;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientService {
    private static ClientService instance;
    private SortedSet<Client> clients = new TreeSet<>(Comparator.comparing(Client::getId));

    private Connection connection;
    private ClientService() {
        // Establish the database connection
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    public void addClient(Client client) {
        String sql = "INSERT INTO clients (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, client.getFirstname());
            statement.setString(2, client.getLastname());
            statement.setDate(3, java.sql.Date.valueOf(client.getBirthdate()));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeClient(Client client) {
        String sql = "DELETE FROM clients WHERE ID_CLIENT = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, client.getId());
            statement.executeUpdate();
            statement.close();

            clients.remove(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<Client> getClients() {
        SortedSet<Client> clients = new TreeSet<>(Comparator.comparing(Client::getId));
        String sql = "SELECT * FROM clients ORDER BY ID_CLIENT ASC";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_CLIENT");
                String firstname = resultSet.getString("FIRST_NAME");
                String lastname = resultSet.getString("LAST_NAME");
                java.sql.Date dateOfBirth = resultSet.getDate("DATE_OF_BIRTH");
                LocalDate birthdate = null;

                if (dateOfBirth != null) {
                    birthdate = dateOfBirth.toLocalDate();
                }

                Client client = new Client(id, firstname, lastname, birthdate);
                clients.add(client);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }


    public Client getClientById(int id) {
        String sql = "SELECT * FROM clients WHERE ID_CLIENT = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstname = resultSet.getString("FIRST_NAME");
                String lastname = resultSet.getString("LAST_NAME");
                java.sql.Date dateOfBirth = resultSet.getDate("DATE_OF_BIRTH");
                LocalDate birthdate = (dateOfBirth != null) ? dateOfBirth.toLocalDate() : null;

                Client client = new Client(id, firstname, lastname, birthdate);
                resultSet.close();
                statement.close();
                return client;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Client> getClientByName(String firstname, String lastname) {
        List<Client> cl = new ArrayList<>();
        String sql = "SELECT * FROM clients WHERE FIRST_NAME = ? AND LAST_NAME = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_CLIENT");
                LocalDate birthdate = null;

                // Check if the birthdate is null
                if (resultSet.getDate("DATE_OF_BIRTH") != null) {
                    birthdate = resultSet.getDate("DATE_OF_BIRTH").toLocalDate();
                }

                Client client = new Client(id, firstname, lastname, birthdate);
                cl.add(client);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cl;
    }

    public void updateClient(Client client) {
        if (getClientById(client.getId()) == null) {
            System.out.println("Client with ID " + client.getId() + " does not exist.");
            return;
        }
        String sql = "UPDATE clients SET FIRST_NAME = ?, LAST_NAME = ?, DATE_OF_BIRTH = ? WHERE ID_CLIENT = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, client.getFirstname());
            statement.setString(2, client.getLastname());
            statement.setDate(3, java.sql.Date.valueOf(client.getBirthdate()));
            statement.setInt(4, client.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Models.Client> getClientByBirthdate(LocalDate birthdate) {
//        List<Models.Client> cl = new ArrayList<>();
//        String sql = "SELECT * FROM clients WHERE DATE_OF_BIRTH = ?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setDate(1, java.sql.Date.valueOf(birthdate));
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("ID_CLIENT");
//                String firstname = resultSet.getString("FIRST_NAME");
//                String lastname = resultSet.getString("LAST_NAME");
//
//                Models.Client client = new Models.Client(id, firstname, lastname, birthdate);
//                cl.add(client);
//            }
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cl;
//    }
}

