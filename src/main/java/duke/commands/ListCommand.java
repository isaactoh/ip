package duke.commands;

import duke.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Represents the command to list out all current tasks.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
