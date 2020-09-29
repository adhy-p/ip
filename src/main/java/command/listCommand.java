package command;

import storage.Storage;
import task.TaskList;
import ui.UI;

/**
 * Represents the bye command, the command given by a user
 * to show the all the tasks in the list
 */
public class listCommand extends Command {

    /**
     * Prints the current list of tasks
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        UI.printList(tasks.getTasks());
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
