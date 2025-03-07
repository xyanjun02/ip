import java.util.ArrayList;
public class UnmarkCommand extends Command {
    private final String[] parts;

    public UnmarkCommand(String[] parts) {
        this.parts = parts;
    }

    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        int index = Ui.parseTaskIndex(parts, tasks);
        tasks.get(index).unmarkAsDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("   " + tasks.get(index));
        return false;
    }
}

