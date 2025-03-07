// Event class
/**
 * The {@code Event} class represents a task that occurs within a specific time range.
 */
public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Constructs an {@code Event} task with a description and a time range.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toFileFormat() {
        return "E | " + getStatusIcon() + " | " + description + " | " + from + " | " + to;
    }
}