package task;

import exception.DukeInvalidArgumentException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected LocalDate at;
    public static final String type = "E";

    public Event(String description, String at) throws DukeInvalidArgumentException {
        super(description);
        try {
            this.at = LocalDate.parse(at, DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        } catch (DateTimeParseException e){
            throw new DukeInvalidArgumentException();
        }
    }

    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = LocalDate.parse(at);
    }

    public LocalDate getAt() {
        return at;
    }

    @Override
    public String toString() {
        return "[" + type + "]" + super.toString() + " (at: " + at.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }

    @Override
    public String getTaskType() {
        return type;
    }
}
