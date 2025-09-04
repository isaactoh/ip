package duke.ui;

import duke.tasks.Task;
import duke.tasks.TaskList;

import java.util.ArrayList;
import java.util.List;

public class GuiUi extends Ui {
    private final List<String> messages;

    public GuiUi() {
        messages = new ArrayList<>();
    }

    private void addMessage(String message) {
        messages.add(message);
    }

    public String getOutput() {
        // Combine all messages into a single string
        StringBuilder sb = new StringBuilder();
        for (String msg : messages) {
            sb.append(msg).append("\n");
        }
        messages.clear(); // reset after returning
        return sb.toString();
    }

    @Override
    public void showGreeting() {
        addMessage("Hello! I'm acow123_bot");
        addMessage("What can I do for you?");
    }

    @Override
    public void showAdios() {
        addMessage("Good night my pookies! Rest well and dream of victory in our");
        addMessage("next race. See you on the track tomorrow. -Adarsh");
    }

    @Override
    public void showError(String errorMessage) {
        addMessage("Error: " + errorMessage);
    }

    @Override
    public void showAdded(Task task, int size) {
        addMessage("Got it. I've added this task:");
        addMessage("  " + task);
        addMessage("Now you have " + size + " tasks in this list.");
    }

    @Override
    public void showList(TaskList tasks) {
        addMessage("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            addMessage((i + 1) + ". " + tasks.get(i));
        }
    }

    @Override
    public void showMarked(Task task) {
        addMessage("Nice! I've marked this task as done:");
        addMessage("  " + task);
    }

    @Override
    public void showUnmarked(Task task) {
        addMessage("OK, I've marked this task as not done yet:");
        addMessage("  " + task);
    }

    @Override
    public void showDeleted(Task task, int size) {
        addMessage("duke.tasks.Task removed like me from TREX soon:");
        addMessage("  " + task);
        addMessage("Now you have " + size + " tasks in the list.");
    }

    @Override
    public void showFind(TaskList tasks, String toSearch) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toString().contains(toSearch)) {
                addMessage((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
