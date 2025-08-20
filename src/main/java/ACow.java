import java.util.Scanner;

public class ACow {
    private static Task[] todolist = new Task[100];
    private static int pointer = 1;

    public static void printDashes() {
        System.out.println("____________________________________________________________");
    }

    public static void greet() {
        System.out.println("Hello! I'm acow123_bot");
        System.out.println("What can I do for you?");
    }

    public static void add(Task task) {
        todolist[pointer] = task;
        pointer += 1;
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + (pointer - 1) + " tasks in this list.");
    }

    public static void list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i < pointer; i++) {
            System.out.println(i + ". " + todolist[i]);
        }
    }

    public static void exit() {
        System.out.println("Good night my pookies! Rest well and dream of victory in our");
        System.out.println("next race. See you on the track tomorrow. -Adarsh");
    }

    public static void mark(int index) {
        todolist[index].mark();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + todolist[index]);
    }

    public static void unmark(int index) {
        todolist[index].unmark();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + todolist[index]);
    }

    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        printDashes();
        greet();
        printDashes();

        while (true) {
            String command = listener.nextLine();
            String[] words = command.split(" ", 2);
            String keyword = words[0];
            String rest = (words.length > 1) ? words[1] : null;

            printDashes();
            switch (keyword) {
                case "bye":
                    exit();
                    printDashes();
                    break;

                case "list":
                    list();
                    break;

                case "todo":
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
            }

            if (command.equals("bye")) {
                break;
            }
            printDashes();
        }
    }
}