import java.util.ArrayList;

// MarkCommand class
/**
 * The {@code MarkCommand} class handles the "mark" command to mark a task as done.
 */
public class MarkCommand extends Command {
    private final String[] parts;

    /**
     * Constructs a {@code MarkCommand} with the specified input parts.
     *
     * @param parts An array of strings where the second element is the task index.
     */
    public MarkCommand(String[] parts) {
        this.parts = parts;
    }

    /**
     * Executes the mark command by marking a task as done.
     *
     * @param tasks The list of tasks to update.
     * @return false as this command does not terminate the application.
     * @throws BobException if the task index is invalid.
     */
    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        int index = Ui.parseTaskIndex(parts, tasks);
        tasks.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("   " + tasks.get(index));
        return false;
    }
}