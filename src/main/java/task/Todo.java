package task;

/**
 * Represents a task without a specific time
 */
public class Todo extends Task {
    public static final String type = "T";

    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Overrides the toString method to print the task
     *
     * @return [T] + statusIcon + description
     */
    @Override
    public String toString() {
        return "[" + type + "]" + super.toString();
    }

    /**
     * Gets the task type
     *
     * @return "T" the type of the task
     */
    @Override
    public String getTaskType() {
        return type;
    }
}
