import java.util.Scanner;

class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

public class BOB {
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

            if (input.equalsIgnoreCase("bye")) {
                printGoodbyeMessage();
                break;
            } else if (input.equalsIgnoreCase("list")) {
                printTasks();
            } else if (parts[0].equalsIgnoreCase("mark")) {
                handleMark(parts);
            } else if (parts[0].equalsIgnoreCase("unmark")) {
                handleUnmark(parts);
            } else {
                addTask(input);
            }
        }
        scanner.close();
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

    private static void addTask(String description) {
        if (taskCount < MAX_TASKS) {
            tasks[taskCount++] = new Task(description);
            printDivider();
            System.out.println(" Added: " + description);
            printDivider();
        } else {
            printDivider();
            System.out.println(" Task list is full!");
            printDivider();
        }
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 0 && taskNumber < taskCount;
    }
}

