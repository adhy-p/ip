package task;


/**
 * Represents the Task object
 */
public class Task {
    protected String description;
    protected boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Gets the status icon of the task
     *
     * @return ticks or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    /**
     * An 'abstract' class, to be overridden by subclasses
     */
    public String getTaskType() {
        return "To be overridden by subclass";
    }

    /**
     * Gets the description of the task
     *
     * @return description the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets task isDone status
     *
     * @return isDone
     */
    public boolean getDoneStatus() {
        return isDone;
    }

    /**
     * Sets isDone to true
     */
    public void setDoneStatus() {
        isDone = true;
    }

    /**
     * Overrides the toString method to print the tasks
     *
     * @return status icon + task description
     */
    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }
}
