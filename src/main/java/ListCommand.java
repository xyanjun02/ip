import java.util.ArrayList;
// ListCommand class
/**
 * The {@code ListCommand} class handles the "list" command to display all tasks.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by displaying all tasks in the task list.
     *
     * @param tasks The list of tasks to display.
     * @return false as this command does not terminate the application.
     */
    @Override
    public boolean execute(ArrayList<Task> tasks) {
        Ui.printTaskList(tasks);
        return false;
    }
}
