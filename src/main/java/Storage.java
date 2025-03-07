import java.io.*;
import java.util.ArrayList;

public class Storage {
    public static void saveTasks(ArrayList<Task> tasks, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                System.out.println("Failed to create directories for file path: " + filePath);
                return;
            }
            try (PrintWriter writer = new PrintWriter(file)) {
                for (Task task : tasks) {
                    writer.println(task.toFileFormat());
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks(String filePath) {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }
}
