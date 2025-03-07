public class Parser {
    public static Command parse(String input) throws BobException {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();

        switch (command) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(parts);
            case "unmark":
                return new UnmarkCommand(parts);
            case "todo":
            case "deadline":
            case "event":
                return new AddCommand(parts);
            case "delete":
                return new DeleteCommand(parts);
            default:
                throw new BobException(" What that mean? Use 'todo', 'deadline', 'event', 'mark', 'unmark', 'delete', or 'list'.");
        }
    }
}
