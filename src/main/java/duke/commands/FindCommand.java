package duke.commands;

import duke.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Represents the listing of tasks with the given substring.
 */
public class FindCommand extends Command{
    private String toSearch;

    /**
     * Constructs a new command with the substring to search for.
     *
     * @param toSearch the given substring.
     */
    public FindCommand(String toSearch) {
        this.toSearch = toSearch;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFind(tasks, toSearch);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
