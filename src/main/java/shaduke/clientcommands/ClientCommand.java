package shaduke.clientcommands;

import shaduke.clients.ClientList;
import shaduke.tasks.TaskList;
import shaduke.ui.Ui;

public abstract class ClientCommand {
    public abstract void execute(TaskList tasklist, ClientList clients, Ui ui);
}
