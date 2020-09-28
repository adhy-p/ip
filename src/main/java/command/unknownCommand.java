package command;

import storage.Storage;
import task.TaskList;
import ui.UI;

public class unknownCommand extends Command {
    String description;

    public unknownCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Storage storage) {
        UI.handleUnknownCommandMessage(description);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
