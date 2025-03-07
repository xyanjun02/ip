import java.util.ArrayList;
// ExitCommand class
/**
 * The {@code ExitCommand} class handles the "bye" command, terminating the application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by displaying a goodbye message.
     *
     * @param tasks The list of tasks (unused in this command).
     * @return true to indicate the application should exit.
     */
    @Override
    public boolean execute(ArrayList<Task> tasks) {
        Ui.printGoodbyeMessage();
        return true;
    }
}
