// Task class
/**
 * The {@code Task} class is an abstract base class for all task types.
 * It provides common functionality for managing task descriptions and completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a {@code Task} with the specified description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Returns the status icon representing completion ('X' if done, ' ' if not).
     *
     * @return A string representing the task's completion status.
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";  // Display 'X' when done, otherwise a blank space
    }

    /**
     * Retrieves the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    /**
     * Converts the task to a savable string format.
     *
     * @return The formatted string for saving the task to a file.
     */
    public abstract String toFileFormat();

    /**
     * Converts a string from file format to a {@code Task} object.
     *
     * @param line The line from the saved file representing a task.
     * @return The reconstructed {@code Task} object.
     */
    public static Task fromFileFormat(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
            case "T":
                Todo todo = new Todo(description);
                if (isDone) todo.markAsDone();
                return todo;
            case "D":
                Deadline deadline = new Deadline(description, parts[3]);
                if (isDone) deadline.markAsDone();
                return deadline;
            case "E":
                Event event = new Event(description, parts[3], parts[4]);
                if (isDone) event.markAsDone();
                return event;
            default:
                throw new IllegalArgumentException("Invalid task format.");
        }
    }
}
