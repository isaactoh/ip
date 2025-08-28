package duke.commands;

import duke.ACowException;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Todo;

import java.time.LocalDate;

public class Parser {

    public static Command parse(String command) throws ACowException {
        String[] words = command.split(" ", 2);
        String keyword = words[0];
        String rest = (words.length > 1) ? words[1] : null;

        switch (keyword) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "todo":
                if (rest == null || rest.trim().isEmpty()) {
                    throw new ACowException("Don't forget to add a tasty curry recipe to your todo list!");
                }
                return new AddCommand(new Todo(rest));

            case "deadline":
                if (rest == null) {
                    throw new ACowException("Need '/by!'");
                }
                String[] deadParts = rest.split(" /by ");
                if (deadParts.length < 2) {
                    throw new ACowException("By when? Christmas?");
                }
                return new AddCommand(new Deadline(deadParts[0], deadParts[1]));

            case "event":
                String[] halves = rest.split(" /to ");
                String name = halves[0].split(" /from ")[0];
                String from = halves[0].split(" /from ")[1];
                String to = halves[1];
                return new AddCommand(new Event(name, from, to));

            case "mark":
                return new MarkCommand(Integer.parseInt(rest));

            case "unmark":
                return new UnmarkCommand(Integer.parseInt(rest));

            case "delete":
                return new DeleteCommand(Integer.parseInt(rest));

            default:
                throw new ACowException("I don't understand like when Shohib talks to me");
        }
    }
}
