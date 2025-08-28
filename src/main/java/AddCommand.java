import java.util.ArrayList;


public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(task);
        ui.showAdded(task, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
