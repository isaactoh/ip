import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            tasks.add(TaskLoader.load(line));
        }
        scanner.close();
        return tasks;
    }

    public void save(TaskList tasks) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (Task task : tasks.getTasks()) {
            writer.write(task.store() + System.lineSeparator());
        }
        writer.close();
    }

    public static void main(String[] args) {
        Storage storage = new Storage("data/acow.txt");
        ArrayList<Task> tasks = null;
        try {
            tasks = storage.load();
        } catch (IOException e) {
            System.out.println("Hi");
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }
}
