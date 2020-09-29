package command;

import exception.DukeInvalidArgumentException;
import storage.Storage;
import task.TaskList;

/**
 * Represents a command to be executed by the program
 * List of available commands:
 * bye
 * deadline DESCRIPTION /by YYYY-MM-DD HHmm
 * delete INDEX
 * done INDEX
 * event DESCRIPTION /at YYYY-MM-DD HHmm
 * find KEYWORD
 * list
 * todo DESCRIPTION
 */
public abstract class Command {

    /**
     * Blueprint for the execute methods
     * to be implemented by subclasses
     */
    public abstract void execute(TaskList tasks, Storage storage) throws DukeInvalidArgumentException;

    /**
     * Blueprint for the isExit methods
     * to be implemented by subclasses
     */
    public abstract boolean isExit();
}
