package duke.clientcommands;

import duke.ACowException;

import java.util.Arrays;

public class ClientParser {
    public static ClientCommand parse(String command) throws ACowException{
        String[] words = command.split(" ");
        String keyword = words[1];
        String rest = (words.length > 2) ? String.join(" ", Arrays.copyOfRange(words, 2, words.length)) : null;

        switch (keyword) {
            case "add": return parseAddClient(rest);
            case "delete": return new DeleteClientCommand(Integer.parseInt(rest));
            case "list": return new ListClientCommand();
            case "assign": return parseAssign(rest);
            case "leave": return new LeaveCommand(Integer.parseInt(rest));
            case "tasks": return new ClientTasksCommand(Integer.parseInt(rest));
            default: throw new ACowException("Clients are blur, need instructions");
        }
    }

    private static ClientCommand parseAddClient(String rest) {
        String[] halves = rest.split(" /email ");
        String name = halves[0];
        String[] quarters = halves[1].split(" /phone ");
        String email = quarters[0];
        String phone = quarters[1];
        return new AddClientCommand(name, email, phone);
    }

    private static ClientCommand parseAssign(String rest) {
        String[] halves = rest.split(" ");
        int taskIndex = Integer.parseInt(halves[0]);
        int clientIndex = Integer.parseInt(halves[1]);

        return new AssignClientCommand(taskIndex, clientIndex);
    }
}
