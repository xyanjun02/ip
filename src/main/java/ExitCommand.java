import java.util.ArrayList;
public class ExitCommand extends Command {
    @Override
    public boolean execute(ArrayList<Task> tasks) {
        Ui.printGoodbyeMessage();
        return true;
    }
}
