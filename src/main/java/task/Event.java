package task;

import exception.DukeInvalidArgumentException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task at a specific time
 */
public class Event extends Task {
    protected LocalDate at;
    public static final String type = "E";

    public Event(String description, String at) throws DukeInvalidArgumentException {
        super(description);
        try {
            this.at = LocalDate.parse(at, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        } catch (DateTimeParseException e) {
            throw new DukeInvalidArgumentException();
        }
    }

    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = LocalDate.parse(at);
    }

    /**
     * Gets the time of the event
     *
     * @return at the time of the event
     */
    public LocalDate getAt() {
        return at;
    }

    /**
     * Overrides the toString method to print the task
     *
     * @return [E] + statusIcon + description + (at: d MMM yyyy HH:mm)
     */
    @Override
    public String toString() {
        return "[" + type + "]" + super.toString() + " (at: " + at.format(DateTimeFormatter.ofPattern("d MMM yyyy HH:mm")) + ")";
    }

    /**
     * Gets the task type
     *
     * @return "E" the type of the task
     */
    @Override
    public String getTaskType() {
        return type;
    }
}
