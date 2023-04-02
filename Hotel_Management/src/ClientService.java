import java.time.LocalDate;
import java.util.*;
public class ClientService {
    private static ClientService instance;
    private Set<Client> clients = new HashSet<Client>();


    private ClientService() {}

    public static ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public Set<Client> getClients() {
        return clients;
    }

    public Client getClientById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    public List<Client> getClientByFullName(String firstname, String lastname) {
        List<Client> cl = new ArrayList<Client>();
        for (Client client : clients) {
            if (client.getFirstname().equals(firstname) && client.getLastname().equals(lastname)) {
                cl.add(client);
            }
        }
        if(cl.size() == 1) {
            return cl;
        } else {
            return null;
        }
    }

    public List<Client> getClientByBirthdate(LocalDate birthdate) {
        List<Client> cl = new ArrayList<Client>();
        for (Client client : clients) {
            if (client.getBirthdate().equals(birthdate)) {
                cl.add(client);
            }
        }
        if(cl.size() == 1) {
            return cl;
        } else {
            return null;
        }
    }

}
