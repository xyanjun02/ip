import java.util.Scanner;

public class BOB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tasks = new String[100];
        int taskCount = 0;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm BOB");
        System.out.println(" What can I do for you?\uD83D\uDE00");
        System.out.println("____________________________________________________________");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye! Hope to see you again soon!\uD83D\uDE00");
                System.out.println(" - BOB");
                System.out.println("____________________________________________________________");
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                if (taskCount == 0) {
                    System.out.println(" No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            }else {
                    if (taskCount < 100) {
                        tasks[taskCount] = input;
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
