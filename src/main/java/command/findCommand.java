package command;

import storage.Storage;
import task.Task;
import task.TaskList;
import ui.UI;

import java.util.ArrayList;

/**
 * Represents the find command, the command given by a user
 * when he/she wants to filter the task list based on a keyword
 */
public class findCommand extends Command {
    private String filter;

    public findCommand(String filter) {
        this.filter = filter;
    }

    /**
     * Prints the list of filtered tasks
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        ArrayList<Task> filteredTasks = tasks.findTasks(filter);
        UI.printFilteredList(filteredTasks);
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
