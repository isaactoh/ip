package duke.clientcommands;

import duke.clients.ClientList;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class ListClientCommand extends ClientCommand{
    @Override
    public void execute(TaskList tasklist, ClientList clients, Ui ui) {
        ui.showClients(clients);
    }
}
