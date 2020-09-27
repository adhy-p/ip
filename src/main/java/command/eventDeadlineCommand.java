package command;

import exception.DukeInvalidArgumentException;
import storage.Storage;
import task.Event;
import task.Deadline;
import task.TaskList;
import ui.UI;

public class eventDeadlineCommand extends Command {
    private String type;
    private String description;
    private String timeOfEvent;

    public eventDeadlineCommand(String type, String description, String timeOfEvent) {
        this.type = type;
        this.description = description;
        this.timeOfEvent = timeOfEvent;
    }

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

    @Override
    public boolean isExit() {
        return false;
    }
}

