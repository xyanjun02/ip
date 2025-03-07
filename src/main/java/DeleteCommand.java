import java.util.ArrayList;
// DeleteCommand class
/**
 * The {@code DeleteCommand} class handles the "delete" command to remove a task.
 */
public class DeleteCommand extends Command {
    private final String[] parts;

    /**
     * Constructs a {@code DeleteCommand} with the specified input parts.
     *
     * @param parts An array of strings where the second element is the task index.
     */
    public DeleteCommand(String[] parts) {
        this.parts = parts;
    }

    /**
     * Executes the delete command by removing a task from the task list.
     *
     * @param tasks The list of tasks to modify.
     * @return false as this command does not terminate the application.
     * @throws BobException if the task index is invalid.
     */
    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        int index = Ui.parseTaskIndex(parts, tasks);
        Task removedTask = tasks.remove(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println("   " + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        return false;
    }
}
