import java.util.Scanner;

public class Bob {
    private static final int MAX_TASKS = 100;
    private static final Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printDivider();
        System.out.println(" Hello! I'm BOB");
        System.out.println(" What can I do for you? 😀");
        printDivider();

        while (true) {
            String input = scanner.nextLine().trim();
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
                default:
                    System.out.println(" Unknown command! Use 'todo', 'deadline', 'event', 'mark', 'unmark', or 'list'.");
                    break;
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

    private static void printTasks() {
        printDivider();
        System.out.println(" Here are the tasks in your list:");

        if (taskCount == 0) {
            System.out.println(" No tasks added yet.");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
        printDivider();
    }

    private static void handleMark(String[] parts) {
        try {
            int taskNumber = Integer.parseInt(parts[1]) - 1;
            if (isValidTaskNumber(taskNumber)) {
                tasks[taskNumber].markAsDone();
                printDivider();
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println("   " + tasks[taskNumber]);
                printDivider();
            } else {
                System.out.println(" Invalid task number!");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(" Please enter a valid task number.");
        }
    }

    private static void handleUnmark(String[] parts) {
        try {
            int taskNumber = Integer.parseInt(parts[1]) - 1;
            if (isValidTaskNumber(taskNumber)) {
                tasks[taskNumber].unmarkAsDone();
                printDivider();
                System.out.println(" OK, I've marked this task as not done yet:");
                System.out.println("   " + tasks[taskNumber]);
                printDivider();
            } else {
                System.out.println(" Invalid task number!");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(" Please enter a valid task number.");
        }
    }

    private static void addTask(String[] parts) {
        if (taskCount >= MAX_TASKS) {
            printDivider();
            System.out.println(" Task list is full!");
            printDivider();
            return;
        }

        if (parts.length < 2) {
            System.out.println(" Please provide a task description.");
            return;
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
                    System.out.println(" Invalid deadline format! Use: deadline <task> /by <time>");
                    return;
                }
                newTask = new Deadline(deadlineParts[0], deadlineParts[1]);
                break;
            case "event":
                String[] eventParts = details.split(" /from | /to ", 3);
                if (eventParts.length < 3) {
                    System.out.println(" Invalid event format! Use: event <task> /from <time> /to <time>");
                    return;
                }
                newTask = new Event(eventParts[0], eventParts[1], eventParts[2]);
                break;
            default:
                System.out.println(" Unknown task type.");
                return;
        }

        tasks[taskCount++] = newTask;
        printDivider();
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + newTask);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
        printDivider();
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 0 && taskNumber < taskCount;
    }
}