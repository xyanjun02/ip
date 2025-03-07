import java.io.*;
import java.util.ArrayList;

// Storage class
/**
 * The {@code Storage} class is responsible for saving and loading tasks from a file.
 */
public class Storage {
    /**
     * Saves the list of tasks to the specified file path.
     *
     * @param tasks The list of tasks to save.
     * @param filePath The file path to save the tasks to.
     */
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

    /**
     * Loads the list of tasks from the specified file path.
     *
     * @param filePath The file path to load the tasks from.
     * @return A list of tasks loaded from the file.
     */
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
