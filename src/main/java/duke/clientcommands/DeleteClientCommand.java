package duke.clientcommands;

import duke.clients.Client;
import duke.clients.ClientList;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class DeleteClientCommand extends ClientCommand{
    private int index;

    public DeleteClientCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasklist, ClientList clients, Ui ui) {
        Client client = clients.get(index);
        for (Task t : tasklist.getTasks()) {
            if (!t.getClient().equals(client)) {
                t.deleteClient();
            }
        }
        clients.delete(index);
        ui.showDeleteClient(client);
    }
}
