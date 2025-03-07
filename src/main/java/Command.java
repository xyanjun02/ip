import java.util.ArrayList;

// Command class
/**
 * The {@code Command} class is an abstract class for handling user commands.
 * It defines the structure for executing specific commands on the task list.
 */
public abstract class Command {
    /**
     * Executes the command using the provided list of tasks.
     *
     * @param tasks The list of tasks to modify.
     * @return true if the application should exit, false otherwise.
     * @throws BobException if an error occurs during command execution.
     */
    public abstract boolean execute(ArrayList<Task> tasks) throws BobException;
}

