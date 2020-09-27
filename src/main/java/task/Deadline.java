package task;

import exception.DukeInvalidArgumentException;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected LocalDateTime by;
    public static final String type = "D";

    public Deadline(String description, String by) throws DukeInvalidArgumentException {
        super(description);
        try {
            this.by = LocalDateTime.parse(by, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        } catch (DateTimeParseException e) {
            throw new DukeInvalidArgumentException();
        }
    }

    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = LocalDateTime.parse(by);
    }

    public LocalDateTime getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[" + type + "]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("d MMM yyyy hh:mm")) + ")";
    }

    @Override
    public String getTaskType() {
        return type;
    }
}
