import java.util.ArrayList;

// UnmarkCommand class
/**
 * The {@code UnmarkCommand} class handles the "unmark" command to mark a task as not done.
 */
public class UnmarkCommand extends Command {
    private final String[] parts;

    /**
     * Constructs an {@code UnmarkCommand} with the specified input parts.
     *
     * @param parts An array of strings where the second element is the task index.
     */
    public UnmarkCommand(String[] parts) {
        this.parts = parts;
    }

    /**
     * Executes the unmark command by marking a task as not done.
     *
     * @param tasks The list of tasks to update.
     * @return false as this command does not terminate the application.
     * @throws BobException if the task index is invalid.
     */
    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        int index = Ui.parseTaskIndex(parts, tasks);
        tasks.get(index).unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("   " + tasks.get(index));
        return false;
    }
}

