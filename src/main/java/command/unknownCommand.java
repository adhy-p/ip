package command;

import storage.Storage;
import task.TaskList;
import ui.UI;

/**
 * Represent the commands unknown by the program
 */
public class unknownCommand extends Command {
    String description;

    public unknownCommand(String description) {
        this.description = description;
    }

    /**
     * Prints the error message to the user
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        UI.handleUnknownCommandMessage(description);
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
