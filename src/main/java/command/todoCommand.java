package command;

import storage.Storage;
import task.TaskList;
import task.Todo;

/**
 * Represents the todo command, the command given by a user
 * to add a task without a specific time
 */
public class todoCommand extends Command {
    private String description;

    public todoCommand(String description) {
        this.description = description;
    }

    /**
     * Adds todo task to the list
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        tasks.addToList(new Todo(description));
    }

    /**
     * Returns a boolean to determine whether the app must continue
     * to read inputs or not
     *
     * @return false the app will continue after executing this command
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
