import java.util.Scanner;

public class ACow {
    public static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm acow123_bot");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void echo(String command) {
        System.out.println("____________________________________________________________");
        System.out.println(command);
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
            } else {
                echo(command);
            }
        }
    }
}