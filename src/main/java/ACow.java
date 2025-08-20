import java.util.Scanner;

public class ACow {
    public static void f(String command) {
        System.out.println("____________________________________________________________");
        if (command == "greet") {
            System.out.println("Hello! I'm acow123_bot");
            System.out.println("What can I do for you?");
        } else {
            System.out.println(command);
        }
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        f("greet");

        while (true) {
            String command = listener.nextLine();
            f(command);
        }
    }
}