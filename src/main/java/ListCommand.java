import java.util.ArrayList;
public class ListCommand extends Command {
    @Override
    public boolean execute(ArrayList<Task> tasks) {
        Ui.printTaskList(tasks);
        return false;
    }
}
