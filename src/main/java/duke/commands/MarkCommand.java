package duke.commands;

import duke.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

public class MarkCommand extends Command {
    private Integer index;

    public MarkCommand(Integer index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task toMark = tasks.get(index - 1);
        toMark.mark();
        ui.showMarked(toMark);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
