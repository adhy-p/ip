package command;

import exception.DukeInvalidArgumentException;
import storage.Storage;
import task.TaskList;

public class doneCommand extends Command {
    private int index;

    public doneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) throws DukeInvalidArgumentException {
        try {
            tasks.markAsDone(index); // index - 1 will be done at task.TaskList.markAsDone
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidArgumentException();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
