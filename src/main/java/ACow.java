import java.util.Scanner;

public class ACow {
    private static String[] todolist = new String[100];
    private static int pointer = 1;

    public static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm acow123_bot");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void add(String item) {
        todolist[pointer] = item;
        pointer += 1;
        System.out.println("____________________________________________________________");
        System.out.println("added: " + item);
        System.out.println("____________________________________________________________");
    }

    public static void list() {
        System.out.println("____________________________________________________________");
        for (int i = 1; i < pointer; i++) {
            System.out.println(i + ". " + todolist[i]);
        }
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("____________________________________________________________");
        System.out.println("Good night my pookies! Rest well and dream of victory in our next race. See you on the track tomorrow. -Adarsh");
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        greet();

        while (true) {
            String command = listener.nextLine();
            if (command.equals("bye")) {
                exit();
                break;
            } else if (command.equals("list")) {
                list();
            } else {
                add(command);
            }
        }
    }
}