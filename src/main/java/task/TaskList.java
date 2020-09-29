package task;

import exception.DukeInvalidArgumentException;
import ui.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents the list of tasks
 */
public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add one task to the list
     * Gives feedback message to the user
     *
     * @param t the task to be added to the list
     */
    public void addToList(Task t) {
        tasks.add(t);
        UI.addToListMessage(tasks);
    }

    /**
     * Deletes one task from the list
     * Gives feedback message to the user
     *
     * @param index the index of the task to be deleted
     */
    public void deleteFromList(int index) {
        String deletedTask = tasks.get(index - 1).toString();
        tasks.remove(index - 1);
        int size = tasks.size();
        UI.deleteTaskMessage(deletedTask, size);
    }

    /**
     * Sets the isDone attribute of a task to true
     * Gives feedback message to the user
     *
     * @param index the index of the task to be marked as done
     * @throws DukeInvalidArgumentException If the index is invalid
     */
    public void markAsDone(int index) throws DukeInvalidArgumentException {
        try {
            tasks.get(index - 1).setDoneStatus();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidArgumentException();
        }
        String description = tasks.get(index - 1).toString();
        UI.markAsDoneMessage(description);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Filter the current list of task based on the keyword
     *
     * @param filter the keyword
     * @return ArrayList the new task list
     */
    public ArrayList<Task> findTasks(String filter) {
        return tasks.stream()
                .filter(task -> task.getDescription().contains(filter))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
