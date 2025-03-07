import java.util.ArrayList;
import java.util.Scanner;

public class Bob {
    private static final String FILE_PATH = "data/bob.txt";
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tasks.addAll(Storage.loadTasks(FILE_PATH));
        Ui.printWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new BobException(Ui.ERROR_EMPTY_INPUT);
                }

                Command command = Parser.parse(input);
                isExit = command.execute(tasks);

                Storage.saveTasks(tasks, FILE_PATH);
            } catch (BobException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
