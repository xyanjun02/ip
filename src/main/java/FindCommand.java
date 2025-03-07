import java.util.ArrayList;
// FindCommand class
/**
 * The {@code FindCommand} class implements the functionality to search for tasks
 * containing a specific keyword in their description. It filters tasks based on
 * a case-insensitive search and displays the matching tasks to the user.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructs a FindCommand with the specified input parts.
     *
     * @param parts An array of strings where the second element is the search keyword.
     * @throws BobException if the search keyword is not provided or is empty.
     */
    public FindCommand(String[] parts) throws BobException {
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new BobException(" Please specify a keyword to search for.");
        }
        this.keyword = parts[1].trim().toLowerCase();
    }

    /**
     * Executes the find command by searching through the task list for matching
     * descriptions. Displays all tasks containing the keyword.
     *
     * @param tasks The list of tasks to search through.
     * @return false as this command does not terminate the application.
     */
    @Override
    public boolean execute(ArrayList<Task> tasks) {
        Ui.printDivider();
        System.out.println(" Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword)) {
                System.out.println(" " + index + "." + task);
                index++;
            }
        }
        if (index == 1) {
            System.out.println(" No matching tasks found.");
        }
        Ui.printDivider();
        return false;
    }
}