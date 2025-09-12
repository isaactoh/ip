package duke.commands;


import duke.ACowException;
import duke.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Represents the addition of a task.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs the command to add the given task.
     *
     * @param task the task to be added.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(task);
        ui.showAdded(task, tasks.size());
        try {
            storage.save(tasks);
        } catch (IOException e) {
            throw new ACowException(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
