import java.util.ArrayList;

// AddCommand class
/**
 * The {@code AddCommand} class handles adding new tasks to the task list.
 */
public class AddCommand extends Command {
    private final String[] parts;

    /**
     * Constructs an {@code AddCommand} with the specified input parts.
     *
     * @param parts An array of strings where the first element is the command and the second is the task details.
     */
    public AddCommand(String[] parts) {
        this.parts = parts;
    }

    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        if (parts.length < 2) {
            throw new BobException(" Please provide a task description.");
        }
        String command = parts[0];
        String details = parts[1];
        Task newTask;
        switch (command) {
            case "todo":
                newTask = new Todo(details);
                break;
            case "deadline":
                String[] deadlineParts = details.split(" /by ", 2);
                if (deadlineParts.length < 2) {
                    throw new BobException(" Sorry I don't really understand what you mean! 😕 Use: deadline <task> /by <time>");
                }
                newTask = new Deadline(deadlineParts[0], deadlineParts[1]);
                break;
            case "event":
                String[] eventParts = details.split(" /from | /to ", 3);
                if (eventParts.length < 3) {
                    throw new BobException(" Sorry I don't really understand what you mean! 😕 Use: event <task> /from <time> /to <time>");
                }
                newTask = new Event(eventParts[0], eventParts[1], eventParts[2]);
                break;
            default:
                throw new BobException(" Unknown task type.");
        }
        tasks.add(newTask);
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + newTask);
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        return false;
    }
}
