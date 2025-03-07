// Todo class
/**
 * The {@code Todo} class represents a simple task with only a description.
 */
public class Todo extends Task {
    /**
     * Constructs a {@code Todo} task with the given description.
     *
     * @param description The description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + description;
    }

    @Override
    public String toFileFormat() {
        return "T | " + getStatusIcon() + " | " + description;
    }
}

