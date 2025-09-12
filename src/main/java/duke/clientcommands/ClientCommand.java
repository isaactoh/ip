package duke.clientcommands;

import duke.clients.ClientList;
import duke.tasks.TaskList;
import duke.ui.Ui;

public abstract class ClientCommand {
    public abstract void execute(TaskList tasklist, ClientList clients, Ui ui);
}
