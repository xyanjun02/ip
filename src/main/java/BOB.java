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

    public String getStatusIcon () {
        return (isDone ? "X" : " ");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}

public class BOB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm BOB");
        System.out.println(" What can I do for you?\uD83D\uDE00");
        System.out.println("____________________________________________________________");

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye! Hope to see you again soon!\uD83D\uDE00");
                System.out.println(" - BOB");
                System.out.println("____________________________________________________________");
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Here are the tasks in your list:");
                if (taskCount == 0) {
                    System.out.println(" No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else if (parts[0].equalsIgnoreCase("mark")) {
                try {
                    int taskNumber = Integer.parseInt(parts[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCount) {
                        tasks[taskNumber].markAsDone();
                        System.out.println("____________________________________________________________");
                        System.out.println(" Nice! I've marked this task as done:");
                        System.out.println("   " + tasks[taskNumber]);
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println(" Invalid task number!");
                    }
                } catch (Exception e) {
                    System.out.println(" Please enter a valid task number.");
                }
            } else if (parts[0].equalsIgnoreCase("unmark")) {
                try {
                    int taskNumber = Integer.parseInt(parts[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCount) {
                        tasks[taskNumber].unmarkAsDone();
                        System.out.println("____________________________________________________________");
                        System.out.println(" OK, I've marked this task as not done yet:");
                        System.out.println("   " + tasks[taskNumber]);
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println(" Invalid task number!");
                    }
                } catch (Exception e) {
                    System.out.println(" Please enter a valid task number.");
                }
            } else {
                if (taskCount < 100) {
                    tasks[taskCount] = new Task(input);
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Task list is full!");
                    System.out.println("____________________________________________________________");
                }
            }
        }
        scanner.close();
    }
}
