package command;

import exception.DukeInvalidArgumentException;
import storage.Storage;
import task.Event;
import task.Deadline;
import task.TaskList;
import ui.UI;

/**
 * Represents the event and deadline command, the command given by a user
 * to add a task with a specific time / deadline
 */
public class eventDeadlineCommand extends Command {
    private String type;
    private String description;
    private String timeOfEvent;

    public eventDeadlineCommand(String type, String description, String timeOfEvent) {
        this.type = type;
        this.description = description;
        this.timeOfEvent = timeOfEvent;
    }

    /**
     * Adds event/deadline task to the list
     *
     * @param tasks the current list of tasks
     * @param storage the storage object to save the data
     */
    @Override
    public void execute(TaskList tasks, Storage storage) {
        if (type.equals("event")) {
            try {
                Event event = new Event(description, timeOfEvent);
                tasks.addToList(event);
            } catch (DukeInvalidArgumentException e) {
                UI.invalidDateMessage();
            }

        } else {
            try {
                Deadline deadline = new Deadline(description, timeOfEvent);
                tasks.addToList(deadline);
            } catch (DukeInvalidArgumentException e) {
                UI.invalidDateMessage();
            }
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

