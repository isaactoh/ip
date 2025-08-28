package duke.ui;

import duke.tasks.Task;
import duke.tasks.TaskList;

import java.util.Scanner;

/**
 * Class that deals with interactions with the user.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructs a new Ui object with a scanner to handle input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message when the application starts.
     */
    public void showGreeting() {
        printDashes();
        System.out.println("Hello! I'm acow123_bot");
        System.out.println("What can I do for you?");
        printDashes();
    }

    /**
     * Displays the goodbye message when the application is closed.
     */
    public void showAdios() {
        System.out.println("Good night my pookies! Rest well and dream of victory in our");
        System.out.println("next race. See you on the track tomorrow. -Adarsh");
    }

    /**
     * Displays the message confirming that a task has been added.
     *
     * @param task the task added to the list.
     * @param size the current number of tasks.
     */
    public void showAdded(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in this list.");
    }

    /**
     * Displays the current tasks in the list.
     *
     * @param tasks list of current tasks.
     */
    public void showList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * Displays the message confirming that a task has been marked.
     *
     * @param task task that has been marked as done.
     */
    public void showMarked(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    /**
     * Displays the message confirming that a task has been unmarked.
     *
     * @param task task that has been marked as undone.
     */
    public void showUnmarked(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    /**
     * Displays the message confirming that a task has been deleted.
     *
     * @param task task that has been deleted.
     * @param size the current number of tasks.
     */
    public void showDeleted(Task task, int size) {
        System.out.println("duke.tasks.Task removed like me from TREX soon:");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Shows the divider line.
     */
    public void printDashes() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays the error message.
     *
     * @param errorMessage the message given by the exception thrown.
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Retrieves the instruction to be parsed.
     *
     * @return return the next input from the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }
}
