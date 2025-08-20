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

    public static void add(String item) {
        Task newTask = new Task(item);
        todolist[pointer] = newTask;
        pointer += 1;
        System.out.println("added: " + item);
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

    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        printDashes();
        greet();
        printDashes();

        while (true) {
            String command = listener.nextLine();
            String[] words = command.split(" ");
            String keyword = words[0];
            String rest = (words.length > 1) ? words[1] : null;

            printDashes();
            if (command.equals("bye")) {
                exit();
                printDashes();
                break;
            } else if (command.equals("list")) {
                list();
            } else if (keyword.equals("mark")){
                if (rest == null) {
                    continue;
                }
                mark(Integer.parseInt(rest));
            } else if (keyword.equals("unmark")) {
                if (rest == null) {
                    continue;
                }
                todolist[Integer.parseInt(rest)].unmark();
            } else {
                add(command);
            }
            printDashes();
        }
    }
}