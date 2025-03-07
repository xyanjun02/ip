import java.util.ArrayList;
public abstract class Command {
    public abstract boolean execute(ArrayList<Task> tasks) throws BobException;
}

