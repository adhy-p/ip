import command.Command;
import exception.DukeInvalidArgumentException;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.UI;

import java.io.FileNotFoundException;

/**
 * Duke, the personal task manager.
 *
 */
public class Duke {
    private static final String FILEPATH = "data/saveData.txt";
    private Storage storage;
    private TaskList tasks;

    /**
     * Load save data if the save file exists.
     * Create a new folder and save data otherwise
     *
     * @param filePath the path for the save data
     */
    public Duke(String filePath) {
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadData());
        } catch (FileNotFoundException e) {
            UI.fileNotFoundMessage();
            tasks = new TaskList();
        }
    }

    /**
     * Reads the input from user, parse it as command, and execute the command.
     * Repeats the process until "bye" command is executed
     */
    public void run() {
        UI.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = UI.prompt();
                Command c = Parser.parse(tasks, input);
                c.execute(tasks, storage);
                isExit = c.isExit();
            } catch (DukeInvalidArgumentException e) {
                UI.invalidArgumentMessage();
            }
        }
    }

    public static void main(String[] args) {
        new Duke(FILEPATH).run();
    }
}
