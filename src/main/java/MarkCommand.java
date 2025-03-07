import java.util.ArrayList;
public class MarkCommand extends Command {
    private final String[] parts;

    public MarkCommand(String[] parts) {
        this.parts = parts;
    }

    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        int index = Ui.parseTaskIndex(parts, tasks);
        tasks.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("   " + tasks.get(index));
        return false;
    }
}