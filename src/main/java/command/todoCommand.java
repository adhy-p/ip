package command;

import storage.Storage;
import task.TaskList;
import task.Todo;

public class todoCommand extends Command {
    private String description;

    public todoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        tasks.addToList(new Todo(description));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
