package command;

import storage.Storage;
import task.Event;
import task.Deadline;
import task.TaskList;

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
            tasks.addToList(new Event(description, timeOfEvent));
        } else {
            tasks.addToList(new Deadline(description, timeOfEvent));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

