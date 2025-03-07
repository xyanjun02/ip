import java.util.ArrayList;

// Ui class
/**
 * The {@code Ui} class handles all user interactions, including reading input and displaying output.
 * It provides methods for showing messages, task lists, and error handling.
 */
public class Ui {
    public static final String ERROR_EMPTY_INPUT = "Input cannot be empty. Please enter a command.";
    public static final String ERROR_OUT_OF_RANGE = "Sorry, that is out of range! Please enter a valid task number.";

    public static void printDivider() {
        System.out.println("____________________________________________________________");
    }

    public static void printGoodbyeMessage() {
        printDivider();
        System.out.println(" Bye! Hope to see you again soon! 😀");
        System.out.println(" - BOB");
        printDivider();
    }

    public static void printWelcomeMessage() {
        printDivider();
        System.out.println(" Hello! I'm BOB");
        System.out.println(" What can I do for you? 😀");
        printDivider();
    }

    public static int parseTaskIndex(String[] parts, ArrayList<Task> tasks) throws BobException {
        if (parts.length < 2) {
            throw new BobException("Please specify a task number.");
        }
        try {
            int index = Integer.parseInt(parts[1]) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new BobException(ERROR_OUT_OF_RANGE);
            }
            return index;
        } catch (NumberFormatException e) {
            throw new BobException("Please enter a valid numeric task number.");
        }
    }

    public static void printTaskList(ArrayList<Task> tasks) {
        printDivider();
        System.out.println(" Here are the tasks in your list:");
        if (tasks.isEmpty()) {
            System.out.println(" No tasks added yet.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        printDivider();
    }
}
