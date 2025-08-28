public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task toRemove = tasks.get(index - 1);
        tasks.remove(index-1);
        ui.showDeleted(toRemove, tasks.size());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
