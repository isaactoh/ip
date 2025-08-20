public class ACow {
    public static void f(String command) {
        System.out.println("____________________________________________________________");
        if (command == "greet") {
            System.out.println("Hello! I'm acow123_bot");
            System.out.println("What can I do for you?");
        } else if (command == "exit") {
            System.out.println("Bye. Hope to see you again soon!");
        }
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        f("greet");
        f("exit");
    }
}