package duke;

import duke.commands.Command;
import duke.commands.Parser;
import duke.tasks.TaskList;
import duke.ui.Ui;

import java.io.IOException;

/**
 * The ACow program is the main entry point to an application
 * that stores and manages todo list tasks
 *
 * @author isaactoh
 */
public class ACow {
    private final Ui ui;
    private static TaskList todolist;
    private static Storage storage;

    /**
     * Constructs an ACow instance with the specified storage file
     *
     * @param filePath the file path to where tasks are stored
     */
    public ACow(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            todolist = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showError("No previous data found like my T100 money.");
            ui.showError("Starting fresh!");
            todolist = new TaskList();
        }
    }

    /**
     * Runs the main program loop, reading user commands,
     * executing them, and displaying results until exit command is issued
     */
    public void run() {
        ui.showGreeting();
        boolean isExit = false;

        while (!isExit) {
            try {
                String command = ui.readCommand();
                ui.printDashes();
                Command c = Parser.parse(command);
                c.execute(todolist, ui, storage);
                isExit = c.isExit();
            } catch (ACowException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.printDashes();
            }
        }
    }

    /**
     * The main entry point for the ACow application
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        new ACow("data/tasks.txt").run();
    }
}