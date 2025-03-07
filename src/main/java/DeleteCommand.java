import java.util.ArrayList;
public class DeleteCommand extends Command {
    private final String[] parts;

    public DeleteCommand(String[] parts) {
        this.parts = parts;
    }

    @Override
    public boolean execute(ArrayList<Task> tasks) throws BobException {
        int index = Ui.parseTaskIndex(parts, tasks);
        Task removedTask = tasks.remove(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println("   " + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        return false;
    }
}
