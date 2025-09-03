package duke.commands;

import duke.ACowException;
import duke.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

import java.io.IOException;

/**
 * Represents the marking of a task as done.
 */
public class MarkCommand extends Command {
    private Integer index;

    /**
     * Constructs a command to mark a task as done.
     *
     * @param index the index of the task to mark.
     */
    public MarkCommand(Integer index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task toMark = tasks.get(index - 1);
        toMark.mark();
        ui.showMarked(toMark);
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
