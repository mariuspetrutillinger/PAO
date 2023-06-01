import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
    private Scanner scanner;
    private ClientService clientService;
    private ResortService resortService;
    private StaffService staffService;
    private ReservationService reservationService;
    private static Service instance;
    AuditLogger auditLogger = new AuditLogger();

    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }

    public Service() {
        scanner = new Scanner(System.in);
        clientService = ClientService.getInstance();
        resortService = ResortService.getInstance();
        staffService = StaffService.getInstance();
        reservationService = ReservationService.getInstance();
    }

    public void userMenu() {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    printClientMenu();
                    auditLogger.logAction("Accessed client menu");
                    break;
                case 2:
                    printResortMenu();
                    auditLogger.logAction("Accessed resort menu");
                    break;
                case 3:
                    printStaffMenu();
                    auditLogger.logAction("Accessed staff menu");
                    break;
                case 4:
                    printReservationMenu();
                    auditLogger.logAction("Accessed reservation menu");
                    break;
                case 0:
                    exit = true;
                    auditLogger.logAction("Exited the application");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void printMainMenu() {
        System.out.println("===== Main Menu =====");
        System.out.println("1. Clients");
        System.out.println("2. Resorts");
        System.out.println("3. Staff");
        System.out.println("4. Reservations");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void printClientMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Client Menu =====");
            System.out.println("1. Add a new client");
            System.out.println("2. Remove a client");
            System.out.println("3. View all clients");
            System.out.println("4. Search client by ID");
            System.out.println("5. Search client by name");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    addClient();
                    auditLogger.logAction("Added a new client");
                    break;
                case 2:
                    removeClient();
                    auditLogger.logAction("Removed a client");
                    break;
                case 3:
                    viewAllClients();
                    auditLogger.logAction("Viewed all clients");
                    break;
                case 4:
                    searchClientById();
                    auditLogger.logAction("Searched client by ID");
                    break;
                case 5:
                    searchClientByName();
                    auditLogger.logAction("Searched client by name");
                    break;
                case 0:
                    back = true;
                    auditLogger.logAction("Returned to main menu");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addClient() {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Birthdate (dd-MM-yyyy): ");
        String birthdate = scanner.nextLine();
        LocalDate birthdateDate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Client client = new Client(firstName, lastName, birthdateDate);
        clientService.addClient(client);
        System.out.println("Client added successfully.");
    }

    private void removeClient() {
        System.out.print("Enter the ID of the client to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Client client = clientService.getClientById(id);
        if (client != null) {
            clientService.removeClient(client);
            System.out.println("Client removed successfully.");
        } else {
            System.out.println("Client not found with the given ID.");
        }
    }

    private void viewAllClients() {
        Set<Client> clients = clientService.getClients();
        if (!clients.isEmpty()) {
            System.out.println("\n===== All Clients =====");
            for (Client client : clients) {
                System.out.println(client.toString());
            }
        } else {
            System.out.println("No clients found.");
        }
    }

    private void searchClientById() {
        System.out.print("Enter the ID of the client to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Client client = clientService.getClientById(id);
        if (client != null) {
            System.out.println("Client found:");
            System.out.println(client.toString());
        } else {
            System.out.println("Client not found with the given ID.");
        }
    }

    private void searchClientByName() {
        System.out.print("Enter the name of the client to search: ");
        String name = scanner.nextLine();
        System.out.println(name.split(" ")[0] + name.split(" ")[1]);
        List<Client> clients = clientService.getClientByName(name.split(" ")[0], name.split(" ")[1]);
        if (!clients.isEmpty()) {
            System.out.println("\n===== Clients Found =====");
            for (Client client : clients) {
                System.out.println(client.toString());
            }
        } else {
            System.out.println("No clients found with the given name.");
        }
    }

    private void printResortMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Resort Menu =====");
            System.out.println("1. Add a new resort");
            System.out.println("2. Remove a resort");
            System.out.println("3. View all resorts");
            System.out.println("4. Search resort by ID");
            System.out.println("5. Search resort by name");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    addResort();
                    auditLogger.logAction("Added a new resort");
                    break;
                case 2:
                    removeResort();
                    auditLogger.logAction("Removed a resort");
                    break;
                case 3:
                    viewAllResorts();
                    auditLogger.logAction("Viewed all resorts");
                    break;
                case 4:
                    searchResortById();
                    auditLogger.logAction("Searched resort by ID");
                    break;
                case 5:
                    searchResortByName();
                    auditLogger.logAction("Searched resort by name");
                    break;
                case 0:
                    back = true;
                    auditLogger.logAction("Returned to main menu");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addResort() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Location: ");
        String location = scanner.nextLine();

        Resort resort = new Resort(name, location);
        resortService.addResort(resort);
        System.out.println("Resort added successfully.");
    }

    private void removeResort() {
        System.out.print("Enter the ID of the resort to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Resort resort = resortService.getResortById(id);
        if (resort != null) {
            resortService.removeResort(resort);
            System.out.println("Resort removed successfully.");
        } else {
            System.out.println("Resort not found with the given ID.");
        }
    }

    private void viewAllResorts() {
        Set<Resort> resorts = resortService.getResorts();
        if (!resorts.isEmpty()) {
            System.out.println("\n===== All Resorts =====");
            for (Resort resort : resorts) {
                System.out.println(resort.toString());
            }
        } else {
            System.out.println("No resorts found.");
        }
    }

    private void searchResortById() {
        System.out.print("Enter the ID of the resort to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Resort resort = resortService.getResortById(id);
        if (resort != null) {
            System.out.println("Resort found:");
            System.out.println(resort.toString());
        } else {
            System.out.println("Resort not found with the given ID.");
        }
    }

    private void searchResortByName() {
        System.out.print("Enter the name of the resort to search: ");
        String name = scanner.nextLine();

        List<Resort> resorts = resortService.getResortByName(name);
        if (!resorts.isEmpty()) {
            System.out.println("\n===== Resorts Found =====");
            for (Resort resort : resorts) {
                System.out.println(resort.toString());
            }
        } else {
            System.out.println("No resorts found with the given name.");
        }
    }

    private void printStaffMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Staff Menu =====");
            System.out.println("1. Add a new staff member");
            System.out.println("2. Remove a staff member");
            System.out.println("3. View all staff members");
            System.out.println("4. Search staff member by ID");
            System.out.println("5. Search staff member by name");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    addStaff();
                    auditLogger.logAction("Added a new staff member");
                    break;
                case 2:
                    removeStaff();
                    auditLogger.logAction("Removed a staff member");
                    break;
                case 3:
                    viewAllStaff();
                    auditLogger.logAction("Viewed all staff members");
                    break;
                case 4:
                    searchStaffById();
                    auditLogger.logAction("Searched staff member by ID");
                    break;
                case 5:
                    searchStaffByName();
                    auditLogger.logAction("Searched staff member by name");
                    break;
                case 0:
                    back = true;
                    auditLogger.logAction("Returned to main menu");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addStaff() {
        System.out.print("Enter Resort ID: ");
        int resortId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Role: ");
        String role = scanner.nextLine();

        Staff staff = new Staff(resortId, firstName, lastName, role);
        staffService.addStaff(staff);
        System.out.println("Staff member added successfully.");
    }

    private void removeStaff() {
        System.out.print("Enter the ID of the staff member to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            staffService.removeStaff(staff);
            System.out.println("Staff member removed successfully.");
        } else {
            System.out.println("Staff member not found with the given ID.");
        }
    }

    private void viewAllStaff() {
        Set<Staff> staffMembers = staffService.getStaff();
        if (!staffMembers.isEmpty()) {
            System.out.println("\n===== All Staff Members =====");
            for (Staff staff : staffMembers) {
                System.out.println(staff.toString());
            }
        } else {
            System.out.println("No staff members found.");
        }
    }

    private void searchStaffById() {
        System.out.print("Enter the ID of the staff member to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            System.out.println("Staff member found:");
            System.out.println(staff.toString());
        } else {
            System.out.println("Staff member not found with the given ID.");
        }
    }

    private void searchStaffByName() {
        System.out.print("Enter the name of the staff member to search: ");
        String name = scanner.nextLine();

        List<Staff> staffMembers = staffService.getStaffByName(name.split(" ")[0], name.split(" ")[1]);
        if (!staffMembers.isEmpty()) {
            System.out.println("\n===== Staff Members Found =====");
            for (Staff staff : staffMembers) {
                System.out.println(staff.toString());
            }
        } else {
            System.out.println("No staff members found with the given name.");
        }
    }

    private void printReservationMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== Reservation Menu =====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Remove a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Search reservation by ID");
            System.out.println("5. Search reservations by client ID");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    addReservation();
                    auditLogger.logAction("Added a new reservation");
                    break;
                case 2:
                    removeReservation();
                    auditLogger.logAction("Removed a reservation");
                    break;
                case 3:
                    viewAllReservations();
                    auditLogger.logAction("Viewed all reservations");
                    break;
                case 4:
                    searchReservationById();
                    auditLogger.logAction("Searched reservation by ID");
                    break;
                case 5:
                    searchReservationsByClientId();
                    auditLogger.logAction("Searched reservations by client ID");
                    break;
                case 0:
                    back = true;
                    auditLogger.logAction("Returned to main menu");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addReservation() {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Client client = clientService.getClientById(clientId);
        if (client == null) {
            System.out.println("Client with ID " + clientId + " does not exist.");
            return;
        }
        Reservation reservation = new Reservation(clientId);
        reservationService.addReservation(reservation);
        System.out.println("Reservation added successfully.");
    }

    private void removeReservation() {
        System.out.print("Enter reservation ID: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation with ID " + reservationId + " does not exist.");
            return;
        }

        reservationService.removeReservation(reservationId);
        System.out.println("Reservation removed successfully.");
    }

    private void viewAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("===== All Reservations =====");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    private void searchReservationById() {
        System.out.print("Enter reservation ID: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Reservation with ID " + reservationId + " does not exist.");
        } else {
            System.out.println("===== Reservation Details =====");
            System.out.println(reservation);
        }
    }

    private void searchReservationsByClientId() {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        List<Reservation> reservations = reservationService.getReservationsByClientId(clientId);
        if (reservations.isEmpty()) {
            System.out.println("No reservations found for client with ID " + clientId + ".");
        } else {
            System.out.println("===== Reservations for Client ID " + clientId + " =====");
            for (Reservation reservation : reservations) {
                System.out.println("Reservation ID: " + reservation.getReservation_number());
                System.out.println("Client ID: " + reservation.getClient_id());
                System.out.println("---------------------------");
            }
        }
    }

}