package duke.clients;

import java.util.ArrayList;

public class ClientList {
    private ArrayList<Client> clients;

    public ClientList() {
        this.clients = new ArrayList<>();
    }

    public ClientList(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void add(Client client) {
        clients.add(client);
    }

    public void delete(int index) {
        clients.remove(index);
    }

    public int size() {
        return clients.size();
    }

    public Client get(int index) {
        return clients.get(index);
    }
}