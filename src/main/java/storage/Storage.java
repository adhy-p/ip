package storage;

import exception.DukeInvalidArgumentException;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the storage for saving and loading data
 */
public class Storage {
    private ArrayList<Task> tasks = new ArrayList<>();
    private String filePath;
    private final String SAVEDIR = "data";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Serializes each task into a string and write it to a file
     *
     * @param tasks the current list of Task
     * @throws IOException If the system failed to write the save data
     */
    public void saveData(ArrayList<Task> tasks) throws IOException {
        StringBuilder line = new StringBuilder();
        for (Task task : tasks) {
            line.append(serializeTask(task));
        }

        FileWriter fw = new FileWriter(filePath);
        fw.write(line.toString());
        fw.close();
    }

    /**
     * Deserializes the string from save file and parses them into commands
     * Adds each command to the list, and returns the list
     *
     * @return List of tasks
     * @throws FileNotFoundException if no save file was found
     */
    public ArrayList<Task> loadData() throws FileNotFoundException {
        File directory = new File(SAVEDIR);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Successfully created a new directory for save file");
            }
        } else {
            File f = new File(filePath); // create a File for the given file path
            Scanner s = new Scanner(f); // create a scanner using the file as the source
            while (s.hasNext()) {
                tasks.add(deserializeTask(s.nextLine()));
            }
        }

        return tasks;
    }

    private Task deserializeTask(String serializedTask) {
        Task task = null;
        String[] splitTask = serializedTask.split("\\|");

        String taskType = splitTask[0];
        boolean isDone = splitTask[1].equals("1");
        String description = splitTask[2].trim();

        switch (taskType) {
        case "T":
            task = new Todo(description, isDone);
            break;
        case "D":
            String by = splitTask[3].trim();
            task = new Deadline(description, by, isDone);
            break;
        case "E":
            String at = splitTask[3].trim();
            task = new Event(description, at, isDone);
            break;
        }
        return task;
    }

    /**
     * Serializes the task to strings, delimited by "|"
     * Format: TYPE | ISDONE | DESCRIPTION | TIME
     * Example:
     * T|1|something
     * D|0|another thing|2020-02-01T00:00
     *
     * @param task Task to be delimited
     */
    private String serializeTask(Task task) {
        String result = "";
        result += task.getTaskType() + "|";
        result += (task.getDoneStatus() ? 1 : 0) + "|";
        result += task.getDescription();

        if (task instanceof Deadline) {
            result += "|" + ((Deadline) task).getBy();
        } else if (task instanceof Event) {
            result += "|" + ((Event) task).getAt();
        }

        return result + "\n";
    }

}
