package task;

import exception.DukeInvalidArgumentException;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task with a specific deadline
 */
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

    /**
     * Gets the time of the event
     *
     * @return by the time of the event
     */
    public LocalDateTime getBy() {
        return by;
    }

    /**
     * Overrides the toString method to print the task
     *
     * @return [D] + statusIcon + description + (at: d MMM yyyy HH:mm)
     */
    @Override
    public String toString() {
        return "[" + type + "]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("d MMM yyyy HH:mm")) + ")";
    }

    /**
     * Gets the task type
     *
     * @return "D" the type of the task
     */
    @Override
    public String getTaskType() {
        return type;
    }
}
