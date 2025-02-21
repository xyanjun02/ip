import java.util.ArrayList;
import java.util.Scanner;

public class Bob {
    private static final ArrayList<Task> tasks = new ArrayList<>();  // ✅ Changed to ArrayList
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tasks.addAll(Storage.loadTasks());  // ✅ Load tasks from file at startup

        printDivider();
        System.out.println(" Hello! I'm BOB");
        System.out.println(" What can I do for you? 😀");
        printDivider();

        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new BobException(" Input cannot be empty. Please enter a command.");
                }

                String[] parts = input.split(" ", 2);
                String command = parts[0].toLowerCase();

                switch (command) {
                    case "bye":
                        printGoodbyeMessage();
                        scanner.close();
                        return;
                    case "list":
                        printTasks();
                        break;
                    case "mark":
                        handleMark(parts);
                        break;
                    case "unmark":
                        handleUnmark(parts);
                        break;
                    case "todo":
                    case "deadline":
                    case "event":
                        addTask(parts);
                        break;
                    case "delete":
                        handleDelete(parts);
                        break;
                    default:
                        throw new BobException(" What that mean? Use 'todo', 'deadline', 'event', 'mark', 'unmark', 'delete', or 'list'.");
                }

                Storage.saveTasks(tasks);  // ✅ Save tasks after each change
            } catch (BobException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printDivider() {
        System.out.println("____________________________________________________________");
    }

    private static void printGoodbyeMessage() {
        printDivider();
        System.out.println(" Bye! Hope to see you again soon! 😀");
        System.out.println(" - BOB");
        printDivider();
    }

    private static void printWelcomeMessage() {
        printDivider();
        System.out.println(" Hello! I'm BOB");
        System.out.println(" What can I do for you? 😀");
        printDivider();
    }

    private static void printTasks() {
        printDivider();
        System.out.println(" Here are the tasks in your list:");

        if (tasks.isEmpty()) {
            System.out.println(" No tasks added yet.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        printDivider();
    }

    private static void handleDelete(String[] parts) {  // ✅ New delete method using ArrayList
        try {
            if (parts.length < 2) {
                throw new BobException(" Please specify a task number to delete.");
            }
            int taskNumber = Integer.parseInt(parts[1]) - 1;
            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                throw new BobException(" Sorry that is out of my range! \uD83D\uDE22 Please enter a valid task number.");
            }

            Task removedTask = tasks.remove(taskNumber);  // ✅ `ArrayList` makes it easy

            printDivider();
            System.out.println(" Noted. I've removed this task:");
            System.out.println("   " + removedTask);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            printDivider();
        } catch (NumberFormatException e) {
            System.out.println(" Please enter a valid numeric task number.");
        } catch (BobException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleMark(String[] parts) {
        try {
            if (parts.length < 2) {
                throw new BobException(" Please specify a task number to mark.");
            }
            int taskNumber = Integer.parseInt(parts[1]) - 1;
            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                throw new BobException(" Sorry that is out of my range! 😢 Please enter a valid task number.");
            }
            tasks.get(taskNumber).markAsDone();
            printDivider();
            System.out.println(" Nice! I've marked this task as done:");
            System.out.println("   " + tasks.get(taskNumber));
            printDivider();
        } catch (NumberFormatException e) {
            System.out.println(" Please enter a valid numeric task number.");
        } catch (BobException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleUnmark(String[] parts) {
        try {
            if (parts.length < 2) {
                throw new BobException(" Please specify a task number to unmark.");
            }
            int taskNumber = Integer.parseInt(parts[1]) - 1;
            if (taskNumber < 0 || taskNumber >= tasks.size()) {
                throw new BobException(" Sorry that is out of my range! 😢 Please enter a valid task number.");
            }
            tasks.get(taskNumber).unmarkAsDone();
            printDivider();
            System.out.println(" OK, I've marked this task as not done yet:");
            System.out.println("   " + tasks.get(taskNumber));
            printDivider();
        } catch (NumberFormatException e) {
            System.out.println(" Please enter a valid numeric task number.");
        } catch (BobException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addTask(String[] parts) {
        try {
            if (parts.length < 2) {
                throw new BobException(" Please provide a task description.");
            }

            String command = parts[0].toLowerCase();
            String details = parts[1];

            Task newTask;
            switch (command) {
                case "todo":
                    newTask = new Todo(details);
                    break;
                case "deadline":
                    String[] deadlineParts = details.split(" /by ", 2);
                    if (deadlineParts.length < 2) {
                        throw new BobException(" Sorry I don't really understand! 😕 Use: deadline <task> /by <time>");
                    }
                    newTask = new Deadline(deadlineParts[0], deadlineParts[1]);
                    break;
                case "event":
                    String[] eventParts = details.split(" /from | /to ", 3);
                    if (eventParts.length < 3) {
                        throw new BobException(" Sorry I don't really understand! 😕 Use: event <task> /from <time> /to <time>");
                    }
                    newTask = new Event(eventParts[0], eventParts[1], eventParts[2]);
                    break;
                default:
                    throw new BobException(" Unknown task type.");
            }

            tasks.add(newTask);  // ✅ Using ArrayList instead of array
            printDivider();
            System.out.println(" Got it. I've added this task:");
            System.out.println("   " + newTask);
            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
            printDivider();
        } catch (BobException e) {
            System.out.println(e.getMessage());
        }
    }
}
