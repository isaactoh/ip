package shaduke.commands;

import shaduke.ACowException;
import shaduke.Storage;
import shaduke.tasks.TaskList;
import shaduke.ui.GuiUi;
import shaduke.ui.Ui;

/**
 * Abstract class with the methods to be implemented.
 */
public abstract class Command {
    /**
     * Carries out the command given.
     *
     * @param tasks the current list of tasks.
     * @param ui the user interface object.
     * @param storage the storage object.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    /**
     * Returns true if the command is the Exit command, false otherwise.
     */
    public abstract boolean isExit();

    public String executeAndReturn(TaskList tasks, Storage storage) throws ACowException {
        GuiUi tempUi = new GuiUi(); // e.g. UI that buffers instead of printing
        this.execute(tasks, tempUi, storage);
        return tempUi.getOutput();
    }
}
