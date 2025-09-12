package duke.clientcommands;

import duke.clients.Client;
import duke.clients.ClientList;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class LeaveCommand extends ClientCommand {
    private int taskIndex;

    public LeaveCommand(int taskIndex) {
        this.taskIndex = taskIndex - 1;
    }

    @Override
    public void execute(TaskList tasklist, ClientList clients, Ui ui) {
        Task task = tasklist.get(taskIndex);
        Client client = task.getClient();
        ui.showLeave(taskIndex, client);
        task.deleteClient();
    }
}
