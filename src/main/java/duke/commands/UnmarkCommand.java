package duke.commands;

import duke.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class UnmarkCommand extends Command {
    private Integer index;

    public UnmarkCommand(Integer index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task toUnmark = tasks.get(index - 1);
        toUnmark.unmark();
        ui.showUnmarked(toUnmark);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
