import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void addToList(String input) {
        boolean isValidCommand = true;
        try {
            if (input.startsWith("deadline")) {
                addDeadline(input);
            } else if (input.startsWith("event")) {
                addEvent(input);
            } else if (input.startsWith("todo")) {
                addTodo(input);
            } else {
                handleUnknownCommand(input);
            }
        } catch (DukeInvalidArgumentException e) {
            isValidCommand = false;
        }

        if (isValidCommand) {
            UI.addToListMessage(tasks);
        }
    }

    private static void handleUnknownCommand(String input) throws DukeInvalidArgumentException {
        UI.handleUnknownCommandMessage(input);
        throw new DukeInvalidArgumentException();
    }

    private static void addTodo(String input) throws DukeInvalidArgumentException {
        String description;
        try {
            description = input.trim().split("todo")[1].trim();
        } catch (IndexOutOfBoundsException e) {
            UI.noDescriptionExceptionMessage();
            throw new DukeInvalidArgumentException();
        }
        tasks.add(new Todo(description));
    }

    private static void addEvent(String input) throws DukeInvalidArgumentException {
        String eventDetails;
        try {
            eventDetails = input.trim().split("event")[1];
        } catch (IndexOutOfBoundsException e) {
            UI.noDescriptionExceptionMessage();
            throw new DukeInvalidArgumentException();
        }
        String description, at;
        try {
            description = eventDetails.split("/at")[0].trim();
            at = eventDetails.split("/at")[1].trim();
        } catch (IndexOutOfBoundsException e) {
            UI.notEnoughArgumentsMessage();
            throw new DukeInvalidArgumentException();
        }
        tasks.add(new Event(description, at));
    }

    private static void addDeadline(String input) throws DukeInvalidArgumentException {
        String deadlineDetails;
        try {
            deadlineDetails = input.trim().split("deadline")[1];
        } catch (IndexOutOfBoundsException e) {
            UI.noDescriptionExceptionMessage();
            throw new DukeInvalidArgumentException();
        }
        String description, by;
        try {
            description = deadlineDetails.split("/by")[0].trim();
            by = deadlineDetails.split("/by")[1].trim();
        } catch (IndexOutOfBoundsException e) {
            UI.notEnoughArgumentsMessage();
            throw new DukeInvalidArgumentException();
        }
        tasks.add(new Deadline(description, by));
    }

    public static void markAsDone(int index) throws DukeInvalidArgumentException {
        try {
            tasks.get(index - 1).markAsDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidArgumentException();
        }
        String description = tasks.get(index - 1).toString();
        UI.markAsDoneMessage(description);
    }

    public static void deleteTask(int index) {
        // todo: throw exception when index is invalid
        String deletedTask = tasks.get(index - 1).toString();
        tasks.remove(index - 1);
        int size = tasks.size();
        UI.deleteTaskMessage(deletedTask, size);
    }

    public static int handleInput(String input) {
        if (input.trim().equals("bye")) {
            return 0;
        }

        if (input.trim().equals("list")) {
            UI.printList(tasks);
        } else if (input.startsWith("done")) {
            int index;
            try {
                index = Integer.parseInt(input.split("done")[1].trim());
                markAsDone(index);
            } catch (DukeInvalidArgumentException e) {
                UI.invalidIndexMessage();
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                UI.doneMessage();
            }
        } else if (input.startsWith("delete")) {
            // todo: throw exception when index is invalid
            int index;
            index = Integer.parseInt(input.split("delete")[1].trim());
            deleteTask(index);
        } else {
            addToList(input);
        }
        return 1;
    }

    public static void main(String[] args) {
        UI.greet();
        Scanner in = new Scanner(System.in);
        String input;
        try {
            tasks = Storage.loadData();
        } catch (FileNotFoundException f) {
            UI.fileNotFoundMessage();
        }

        do {
            UI.prompt();
            input = in.nextLine();
            try {
                Storage.saveData(tasks);
            } catch (IOException e) {
                UI.failToWriteMessage();
            }
        } while (handleInput(input) == 1);
        UI.bye();
        in.close();
    }
}
