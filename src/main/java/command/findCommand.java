package command;

import storage.Storage;
import task.Task;
import task.TaskList;
import ui.UI;

import java.util.ArrayList;

public class findCommand extends Command {
    private String filter;

    public findCommand(String filter) {
        this.filter = filter;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        ArrayList<Task> filteredTasks = tasks.findTasks(filter);
        UI.printFilteredList(filteredTasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
