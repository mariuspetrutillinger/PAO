import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private Connection connection;
    private static ReservationService instance;

    public ReservationService() {
        try {
            connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public void addReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations (ID_RESERVATION, CLIENT_ID) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reservation.getReservation_number());
            statement.setInt(2, reservation.getClient_id());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeReservation(int reservationNumber) {
        String sql = "DELETE FROM reservations WHERE ID_RESERVATION = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reservationNumber);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int reservationNumber = resultSet.getInt("ID_RESERVATION");
                int clientId = resultSet.getInt("CLIENT_ID");

                Reservation reservation = new Reservation(reservationNumber, clientId);
                reservations.add(reservation);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public Reservation getReservationById(int reservationId) {
        Reservation reservation = null;
        String sql = "SELECT * FROM reservations WHERE ID_RESERVATION = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, reservationId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int reservationNumber = resultSet.getInt("ID_RESERVATION");
                int clientId = resultSet.getInt("CLIENT_ID");

                reservation = new Reservation(reservationNumber, clientId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservation;
    }
    public List<Reservation> getReservationsByClientId(int clientId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE CLIENT_ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int reservationNumber = resultSet.getInt("ID_RESERVATION");
                int client_id = resultSet.getInt("CLIENT_ID");

                Reservation reservation = new Reservation(reservationNumber, client_id);
                reservations.add(reservation);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
}
