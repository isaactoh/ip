import java.util.ArrayList;

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
