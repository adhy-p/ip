package command;

import storage.Storage;
import task.TaskList;
import ui.UI;

public class listCommand extends Command {

    @Override
    public void execute(TaskList tasks, Storage storage) {
        UI.printList(tasks.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
