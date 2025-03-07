// Parser class
/**
 * The {@code Parser} class is responsible for interpreting user input
 * and creating the appropriate {@code Command} object.
 */
public class Parser {
    /**
     * Parses the user input and returns the corresponding {@code Command} object.
     *
     * @param input The full input string entered by the user.
     * @return The {@code Command} object to execute.
     * @throws BobException if the input command is not recognized.
     */
    public static Command parse(String input) throws BobException {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();

        return switch (command) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(parts);
            case "unmark" -> new UnmarkCommand(parts);
            case "todo", "deadline", "event" -> new AddCommand(parts);
            case "delete" -> new DeleteCommand(parts);
            default -> throw new BobException(" What that mean? Use 'todo', 'deadline', 'event', 'mark', 'unmark', 'delete' or 'list'.");
        };
    }
}

