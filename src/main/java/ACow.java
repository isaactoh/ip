import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ACow {
    private final Ui ui;
    private static ArrayList<Task> todolist = new ArrayList<>();
    private static Storage storage = new Storage("data/acow.txt");

    public ACow(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
    }

    public void add(Task task) {
        todolist.add(task);
        ui.showAdded(task, todolist.size());
    }

    public void mark(int index) {
        Task toMark = todolist.get(index - 1);
        toMark.mark();
        ui.showMarked(toMark);
    }

    public void unmark(int index) {
        Task toUnmark = todolist.get(index-1);
        toUnmark.unmark();
        ui.showUnmarked(toUnmark);
    }

    public void delete(int index) {
        Task toRemove = todolist.get(index - 1);
        todolist.remove(index-1);
        ui.showDeleted(toRemove, todolist.size());
    }

    public void run() {
        try {
            todolist = storage.load();
        } catch (IOException e) {
            ui.showError("No previous data found like my T100 money.");
            ui.showError("Starting fresh!");
        }

        ui.showGreeting();

        while (true) {
            String command = ui.readCommand();
            String[] words = command.split(" ", 2);
            String keyword = words[0];
            String rest = (words.length > 1) ? words[1] : null;

            ui.printDashes();

            try {
                switch (keyword) {
                    case "bye":
                        ui.showAdios();
                        ui.printDashes();
                        break;

                    case "list":
                        ui.showList(todolist);
                        break;

                    case "todo":
                        if (rest == null || rest.trim().isEmpty()) {
                            throw new ACowException("Don't forget to add a tasty curry recipe to your todo list!");
                        }
                        add(new Todo(rest));
                        break;

                    case "deadline":
                        String[] deadParts = rest.split(" /by ");
                        add(new Deadline(deadParts[0], deadParts[1]));
                        break;

                    case "event":
                        String[] halves = rest.split(" /to ");
                        String name = halves[0].split(" /from ")[0];
                        String from = halves[0].split(" /from ")[1];
                        String to = halves[1];
                        add(new Event(name, from, to));
                        break;

                    case "mark":
                        if (rest == null) {
                            break;
                        }
                        mark(Integer.parseInt(rest));
                        break;

                    case "unmark":
                        if (rest == null) {
                            break;
                        }
                        unmark(Integer.parseInt(rest));
                        break;

                    case "delete":
                        if (rest == null) {
                            break;
                        }
                        delete(Integer.parseInt(rest));
                        break;

                    default:
                        throw new ACowException("I don't understand like when Shohib talks to me");
                }

                try {
                    storage.save(todolist);
                } catch (IOException e) {
                    ui.showError("Error saving data.");
                }

                if (command.equals("bye")) {
                    break;
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