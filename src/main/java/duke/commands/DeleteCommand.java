package duke.commands;

import duke.ACowException;
import duke.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Represents the deletion of a task.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructs the command to delete the chosen task.
     *
     * @param index the index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task toRemove = tasks.get(index - 1);
        tasks.remove(index-1);
        ui.showDeleted(toRemove, tasks.size());
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
