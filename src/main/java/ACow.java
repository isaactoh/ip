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
            String command = ui.readCommand();
            String[] words = command.split(" ", 2);
            String keyword = words[0];
            String rest = (words.length > 1) ? words[1] : null;

            ui.printDashes();

            try {
                switch (keyword) {
                    case "bye":
                        ExitCommand exit = new ExitCommand();
                        exit.execute(todolist, ui, storage);
                        isExit = exit.isExit();
                        break;

                    case "list":
                        new ListCommand().execute(todolist, ui, storage);
                        break;

                    case "todo":
                        if (rest == null || rest.trim().isEmpty()) {
                            throw new ACowException("Don't forget to add a tasty curry recipe to your todo list!");
                        }
                        AddCommand addT = new AddCommand(new Todo(rest));
                        addT.execute(todolist, ui, storage);
                        break;

                    case "deadline":
                        String[] deadParts = rest.split(" /by ");
                        AddCommand addD = new AddCommand(new Deadline(deadParts[0], deadParts[1]));
                        addD.execute(todolist, ui, storage);
                        break;

                    case "event":
                        String[] halves = rest.split(" /to ");
                        String name = halves[0].split(" /from ")[0];
                        String from = halves[0].split(" /from ")[1];
                        String to = halves[1];
                        AddCommand addE = new AddCommand(new Event(name, from, to));
                        addE.execute(todolist, ui, storage);
                        break;

                    case "mark":
                        if (rest == null) {
                            break;
                        }
                        MarkCommand mark = new MarkCommand(Integer.parseInt(rest));
                        mark.execute(todolist, ui, storage);
                        break;

                    case "unmark":
                        if (rest == null) {
                            break;
                        }
                        UnmarkCommand unmark = new UnmarkCommand(Integer.parseInt(rest));
                        unmark.execute(todolist, ui, storage);
                        break;

                    case "delete":
                        if (rest == null) {
                            break;
                        }
                        DeleteCommand del = new DeleteCommand(Integer.parseInt(rest));
                        del.execute(todolist, ui, storage);
                        break;

                    default:
                        throw new ACowException("I don't understand like when Shohib talks to me");
                }

                try {
                    storage.save(todolist);
                } catch (IOException e) {
                    ui.showError("Error saving data.");
                }

            } catch (ACowException e) {
                ui.showError(e.getMessage());
            }
            ui.printDashes();
        }
    }

    public static void main(String[] args) {
        new ACow("data/tasks.txt").run();
    }
}