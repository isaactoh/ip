public class TaskLoader {
    public static Task load(String line) {
        String[] parts = line.split(" \\| ");

        String type = parts[0];
        boolean isDone = parts[1].equals("1");

        switch (type) {
            case "T":
                return new Todo(parts[2], isDone);
            case "D":
                return new Deadline(parts[2], parts[3], isDone);
            case "E":
                String from = parts[3].split(" - ")[0];
                String to = parts[3].split(" - ")[1];
                return new Event(parts[2], from, to, isDone);
            default:
                throw new ACowException("Too slow a file for me!");
        }
    }
}


