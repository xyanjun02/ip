import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static final String FILE_PATH = "./data/bob.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();
            PrintWriter writer = new PrintWriter(file);
            for (Task task : tasks) {
                writer.println(task.toFileFormat());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return tasks;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromFileFormat(line));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks.");
        }
        return tasks;
    }
}