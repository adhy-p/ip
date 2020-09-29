package command;

import storage.Storage;
import task.TaskList;

/**
 * Represents the delete command, the command given by a user
 * when he/she wants to delete a task
 */
public class deleteCommand extends Command {
    private int index;

    public deleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes one task from the list
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        // index - 1 will be done at task.TaskList.deleteFromList
        tasks.deleteFromList(index);
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
