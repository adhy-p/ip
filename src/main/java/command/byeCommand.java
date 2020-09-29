package command;

import storage.Storage;
import task.TaskList;
import ui.UI;

import java.io.IOException;

/**
 * Represents the bye command, the command given by a user
 * after done using the program
 */
public class byeCommand extends Command {

    /**
     * Saves the data and closes the input scanner
     * Prints goodbye message to the user
     *
     * @param tasks   the current list of Task
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        try {
            storage.saveData(tasks.getTasks());
            UI.bye();
        } catch (IOException e) {
            UI.failToWriteMessage();
        }

    }

    /**
     * Returns a boolean to determine whether the app must continue
     * to read inputs or not
     *
     * @return true the app will terminate after executing this command
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
