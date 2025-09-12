package duke;

import duke.clientcommands.ClientCommand;
import duke.clientcommands.ClientParser;
import duke.clients.ClientList;
import duke.commands.Command;
import duke.commands.Parser;
import duke.tasks.TaskList;
import duke.ui.Ui;

import java.io.IOException;
import java.util.Objects;

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
    private static ClientList clients;

    /**
     * Constructs an ACow instance with the specified storage file
     *
     * @param filePath the file path to where tasks are stored
     */
    public ACow(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        clients = new ClientList();

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
                if (Objects.equals(command.split(" ")[0], "client")) {
                    System.out.println("client success!");
                    ClientCommand c = ClientParser.parse(command);
                    c.execute(todolist, clients, ui);
                } else {
                    Command c = Parser.parse(command);
                    c.execute(todolist, ui, storage);
                    isExit = c.isExit();
                }
            } catch (ACowException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.printDashes();
            }
        }
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.executeAndReturn(todolist, storage);
        } catch (ACowException e) {
            return e.getMessage();
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