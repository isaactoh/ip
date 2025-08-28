package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDate by;

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String byStr) {
        super(description);
        this.by = LocalDate.parse(byStr, INPUT_FORMAT);
    }

    public Deadline(String description, String byStr, boolean isDone) {
        super(description, isDone);
        this.by = LocalDate.parse(byStr, INPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String store() {
        // store in yyyy-MM-dd format for consistency
        return "D" + super.store() + " | " + by.format(INPUT_FORMAT);
    }
}
