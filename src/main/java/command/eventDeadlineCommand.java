package command;

import storage.Storage;
import task.Event;
import task.Deadline;
import task.TaskList;

public class eventDeadlineCommand extends Command {
    private String type;
    private String description;
    private String time;

    public eventDeadlineCommand(String type, String description, String time) {
        this.type = type;
        this.description = description;
        this.time = time;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        if (type.equals("event")) {
            tasks.addToList(new Event(description, time));
        } else {
            tasks.addToList(new Deadline(description, time));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

