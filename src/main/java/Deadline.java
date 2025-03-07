// Deadline class
/**
 * The {@code Deadline} class represents a task that has a specific due date.
 */
public class Deadline extends Task {
    private final String by;

    /**
     * Constructs a {@code Deadline} task with a description and a due date.
     *
     * @param description The description of the task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + " (by: " + by + ")";
    }

    @Override
    public String toFileFormat() {
        return "D | " + getStatusIcon() + " | " + description + " | " + by;
    }
}