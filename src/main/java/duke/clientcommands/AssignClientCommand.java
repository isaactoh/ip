package duke.clientcommands;

import duke.clients.Client;
import duke.clients.ClientList;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class AssignClientCommand extends ClientCommand {
    int taskIndex;
    int clientIndex;

    public AssignClientCommand(int taskIndex, int clientIndex) {
        this.taskIndex = taskIndex - 1;
        this.clientIndex = clientIndex - 1;
    }

    @Override
    public void execute(TaskList tasklist, ClientList clients, Ui ui) {
        Client client = clients.get(clientIndex);
        Task task = tasklist.get(taskIndex);
        task.addClient(client);
        ui.showAssignClient(task, client);
    }
}
