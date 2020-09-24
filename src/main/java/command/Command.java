package command;

import exception.DukeInvalidArgumentException;
import storage.Storage;
import task.TaskList;

public abstract class Command {
    public abstract void execute(TaskList tasks, Storage storage) throws DukeInvalidArgumentException;

    public abstract boolean isExit();
}
