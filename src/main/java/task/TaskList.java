package task;

import exception.DukeInvalidArgumentException;
import ui.UI;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addToList(Task t) {
        tasks.add(t);
        UI.addToListMessage(tasks);
    }

    public void deleteFromList(int index) {
        String deletedTask = tasks.get(index - 1).toString();
        tasks.remove(index - 1);
        int size = tasks.size();
        UI.deleteTaskMessage(deletedTask, size);
    }

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

    public ArrayList<Task> findTasks(String filter){
        return tasks.stream()
                .filter(task -> task.getDescription().contains(filter))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
