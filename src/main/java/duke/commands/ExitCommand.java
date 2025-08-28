package duke.commands;

import duke.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showAdios();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
