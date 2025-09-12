package duke.clientcommands;

import duke.clients.Client;
import duke.clients.ClientList;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class ClientTasksCommand extends ClientCommand {
    private int index;

    public ClientTasksCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public void execute(TaskList tasklist, ClientList clients, Ui ui) {
        Client client = clients.get(index);
        ui.showClientTasks(tasklist, client);
    }
}
