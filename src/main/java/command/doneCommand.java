package command;

import exception.DukeInvalidArgumentException;
import storage.Storage;
import task.TaskList;

/**
 * Represents the done command, the command given by a user
 * to mark one task as done
 */
public class doneCommand extends Command {
    private int index;

    public doneCommand(int index) {
        this.index = index;
    }

    /**
     * Sets the isDone attribute to true
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) throws DukeInvalidArgumentException {
        try {
            tasks.markAsDone(index); // index - 1 will be done at task.TaskList.markAsDone
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidArgumentException();
        }
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
