package duke.clientcommands;

import duke.clients.Client;
import duke.clients.ClientList;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class AddClientCommand extends ClientCommand {
    private Client client;

    public AddClientCommand(String name, String email, String phone) {
        this.client = new Client(name, email, phone);
    }

    @Override
    public void execute(TaskList tasklist, ClientList clients, Ui ui) {
        clients.add(client);
        ui.showAddClient(client, clients);
    }
}
