import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Service {
    // this class is meant to implement basic functionality for all services
    // this can be used as an interface
    // we are going to add crud functionality to this class
    // as well as others

    private ClientService clientService = ClientService.getInstance();
    private ResortService resortService = ResortService.getInstance();

    private static Service instance;

    private Scanner scanner = new Scanner(System.in);

    private Service(){}

    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }

    public void printUserMenu(){
        System.out.println(" 0 - Client");
        System.out.println(" 1 - Resort");
        System.out.println(" 2 - Exit");
    }

    public void userMenu(){
        while(true){
            printUserMenu();
            int option;
            try {
                option = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Provide an int between 0 and 2");
                option = scanner.nextInt();
            }
            if (option == 0) {
                printClientMenu();
            } else if (option == 1) {
                printResortMenu();
            } else if (option == 2) {
                break;
            }
        }
    }

    public void printClientMenu(){
        while (true) {
            System.out.println(" 0 - Add client");
            System.out.println(" 1 - Remove client");
            System.out.println(" 2 - Get client by id");
            System.out.println(" 3 - Get client by full name");
            System.out.println(" 4 - Get client by birthdate");
            System.out.println(" 5 - Get all clients");
            System.out.println(" 6 - Exit");

            int option;
            try {
                option = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Provide an int between 0 and 6");
                option = scanner.nextInt();
            }

            if (option == 0) {
                System.out.println("Provide a full name and a birthdate");
                System.out.println("First name: ");
                String firstName = scanner.next();
                System.out.println("Last name: ");
                String lastName = scanner.next();
                System.out.println("Birthdate (dd-mm-yyyy): ");
                String birthdate = scanner.next();
                LocalDate birthdateDate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                clientService.addClient(new Client(firstName, lastName, birthdateDate));
            } else if (option == 1) {
                System.out.println("Provide an id");
                int id = scanner.nextInt();
                Client client = clientService.getClientById(id);
                clientService.removeClient(client);
            } else if (option == 2) {
                System.out.println("Provide an id");
                int id = scanner.nextInt();
                System.out.println(clientService.getClientById(id).toString());
            } else if (option == 3) {
                System.out.println("Provide a full name");
                System.out.println("First name: ");
                String firstName = scanner.next();
                System.out.println("Last name: ");
                String lastName = scanner.next();
                List<Client> cl = clientService.getClientByFullName(firstName, lastName);
                for (Client client : cl) {
                    System.out.println(client.toString());
                }
            } else if (option == 4) {
                System.out.println("Provide a birthdate");
                System.out.println("Birthdate (dd-mm-yyyy): ");
                String birthdate = scanner.next();
                LocalDate birthdateDate = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                List<Client> cl = clientService.getClientByBirthdate(birthdateDate);
                for (Client client : cl) {
                    System.out.println(client.toString());
                }
            } else if (option == 5) {
                Set<Client> cl = clientService.getClients();
                for (Client client : cl) {
                    System.out.println(client.toString());
                }
            } else if (option == 6) {
                break;
            }
        }
    }

    public void printResortMenu() {
        while (true) {
            System.out.println(" 0 - Add resort");
            System.out.println(" 1 - Remove resort");
            System.out.println(" 2 - Get resort by id");
            System.out.println(" 3 - Get resort by name");
            System.out.println(" 4 - Get resort by location");
            System.out.println(" 5 - Get all resorts");
            System.out.println(" 6 - Exit");

            int option;
            try {
                option = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Provide an int between 0 and 6");
                option = scanner.nextInt();
            }

            if (option == 0) {
                System.out.println("Provide a name and a location");
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Location: ");
                String location = scanner.next();
                resortService.addResort(new Resort(name, location));
            } else if (option == 1) {
                System.out.println("Provide an id");
                int id = scanner.nextInt();
                Resort resort = resortService.getResortById(id);
                resortService.removeResort(resort);
            } else if (option == 2) {
                System.out.println("Provide an id");
                int id = scanner.nextInt();
                System.out.println(resortService.getResortById(id).toString());
            } else if (option == 3) {
                System.out.println("Provide a name");
                System.out.println("Name: ");
                String name = scanner.next();
                List<Resort> rl = resortService.getResortByName(name);
                for (Resort resort : rl) {
                    System.out.println(resort.toString());
                }
            } else if (option == 4) {
                System.out.println("Provide a location");
                System.out.println("Location: ");
                String location = scanner.next();
                List<Resort> rl = resortService.getResortByLocation(location);
                for (Resort resort : rl) {
                    System.out.println(resort.toString());
                }
            } else if (option == 5) {
                Set<Resort> rl = resortService.getResorts();
                for (Resort resort : rl) {
                    System.out.println(resort.toString());
                }
            } else if (option == 6) {
                break;
            }
        }
    }
}
