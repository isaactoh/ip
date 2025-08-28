import java.io.IOException;

public class ACow {
    private final Ui ui;
    private static TaskList todolist;
    private static Storage storage;

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

    public static void main(String[] args) {
        new ACow("data/tasks.txt").run();
    }
}