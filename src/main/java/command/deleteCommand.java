package command;

import storage.Storage;
import task.TaskList;

public class deleteCommand extends Command {
    private int index;

    public deleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        // todo: handle exception for invalid index
        // index - 1 will be done at task.TaskList.deleteFromList
        tasks.deleteFromList(index);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
