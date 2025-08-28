package duke.tasks;

/**
 * Represents a Task with a start and end time.
 */
public class Event extends Task {
    /**
     * The start time.
     */
    private String from;

    /**
     * The end time.
     */
    private String to;

    /**
     * Constructs a Task with the given description, start and end times
     *
     * @param description the description of the task.
     * @param from the start time of the task.
     * @param to the end time of the task.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a Task with the given description, start and end
     * times and whether it has been done.
     *
     * @param description the description of the task.
     * @param from the start time of the task.
     * @param to the end time of the task.
     * @param isDone whether the task has been done before.
     */
    public Event(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = from;
        this.to = to;
    }

    /**
     * A string representation of the task.
     *
     * @return the string representation of the task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from +  " to: " + this.to + ")";
    }

    /**
     * Converts the task into a format for storage.
     *
     * @return the task in a storable format.
     */
    @Override
    public String store() {
        return "E" + super.store() + " | " + from + " - " + to;
    }
}
