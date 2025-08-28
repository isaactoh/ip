package duke.tasks;

import duke.ACowException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDate by;

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String byStr) {
        this(description, byStr, false);
    }

    public Deadline(String description, String byStr, boolean isDone) {
        super(description, isDone);
        try {
            this.by = LocalDate.parse(byStr, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new ACowException("Please use yyyy-mm-dd format for deadlines!");
        }
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
