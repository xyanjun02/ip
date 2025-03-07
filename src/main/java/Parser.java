public class Parser {
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
            case "find" -> new FindCommand(parts);
            default -> throw new BobException(" What that mean? Use 'todo', 'deadline', 'event', 'mark', 'unmark', 'delete', 'list', or 'find'.");
        };
    }
}