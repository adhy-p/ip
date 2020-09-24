import command.Command;
import exception.DukeInvalidArgumentException;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.UI;

import java.io.FileNotFoundException;

public class Duke {
    private static final String FILEPATH = "data/saveData.txt";
    private Storage storage;
    private TaskList tasks;

    public Duke(String filePath){
        storage = new Storage(filePath);
        try{
            tasks = new TaskList(storage.loadData());
        } catch (FileNotFoundException e){
            UI.fileNotFoundMessage();
            tasks = new TaskList();
        }
    }

    public void run(){
        UI.greet();
        boolean isExit = false;
        while(!isExit){
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
