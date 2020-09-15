import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static final String FILEPATH = "data/saveData.txt";

    public static void printLine() {
        System.out.println("----------------------------------------------");
    }

    public static void greet() {
        printLine();
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void bye() {
        printLine();
        System.out.println("Bye. Hope to see you soon!");
        printLine();
    }

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
            printLine();
            System.out.println("Got it bro. I've added this task:");
            System.out.println(tasks.get(tasks.size() - 1));
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
            printLine();
        }
    }

    private static void handleUnknownCommand(String input) throws DukeInvalidArgumentException {
        printLine();
        System.out.println("Huh? " + input + "?");
        System.out.println("You haven't read the documentation, have you?");
        printLine();
        throw new DukeInvalidArgumentException();
    }

    private static void addTodo(String input) throws DukeInvalidArgumentException {
        String description;
        try {
            description = input.trim().split("todo")[1].trim();
        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("What task do you have? Add the task description please...");
            printLine();
            throw new DukeInvalidArgumentException();
        }
        tasks.add(new Todo(description));
    }

    private static void addEvent(String input) throws DukeInvalidArgumentException {
        String eventDetails;
        try {
            eventDetails = input.trim().split("event")[1];
        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("Come on bro you must specify the event details...");
            printLine();
            throw new DukeInvalidArgumentException();
        }
        String description, at;
        try {
            description = eventDetails.split("/at")[0].trim();
            at = eventDetails.split("/at")[1].trim();
        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("Forgot to type something?");
            System.out.println("I need both the description and the time to add an event.");
            printLine();
            throw new DukeInvalidArgumentException();
        }
        tasks.add(new Event(description, at));
    }

    private static void addDeadline(String input) throws DukeInvalidArgumentException {
        String deadlineDetails;
        try {
            deadlineDetails = input.trim().split("deadline")[1];
        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("Come on bro you must specify the deadline details...");
            printLine();
            throw new DukeInvalidArgumentException();
        }
        String description, by;
        try {
            description = deadlineDetails.split("/by")[0].trim();
            by = deadlineDetails.split("/by")[1].trim();
        } catch (IndexOutOfBoundsException e) {
            printLine();
            System.out.println("Forgot to type something?");
            System.out.println("I need both the description and the time to add a deadline.");
            printLine();
            throw new DukeInvalidArgumentException();
        }
        tasks.add(new Deadline(description, by));
    }

    public static void printList() {
        printLine();
        if (!tasks.isEmpty()) {
            int i = 1;
            for (Task item : tasks) {
                System.out.println((i++) + ". " + item);
            }
        } else {
            System.out.println("You have nothing to do! Yeay!");
        }

        printLine();
    }

    public static void markAsDone(int index) throws DukeInvalidArgumentException {
        try {
            tasks.get(index - 1).markAsDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeInvalidArgumentException();
        }
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[\u2713] " + tasks.get(index - 1).getDescription());
        printLine();
    }
    public static void deleteTask(int index) {
        // todo: throw exception when index is invalid
        printLine();
        System.out.println("Got it! I've removed this task:");
        System.out.println(tasks.get(index - 1));
        tasks.remove(index - 1);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        printLine();
    }
    public static int handleInput(String input) {
        if (input.trim().equals("bye")) {
            return 0;
        }

        if (input.trim().equals("list")) {
            printList();
        } else if (input.startsWith("done")) {
            int index;
            try {
                index = Integer.parseInt(input.split("done")[1].trim());
                markAsDone(index);
            } catch (DukeInvalidArgumentException e) {
                printLine();
                System.out.println("Hey bro.. Don't try to break me okay.. Invalid index.");
                printLine();
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                printLine();
                System.out.println("Done using the program? You should type \"bye\" instead.");
                printLine();
            }
        } else if (input.startsWith("delete")){
            // todo: throw exception when index is invalid
            int index;
            index = Integer.parseInt(input.split("delete")[1].trim());
            deleteTask(index);
        } else {
            addToList(input);
        }
        return 1;
    }

    private static void saveData() throws IOException{
        StringBuilder line = new StringBuilder();
        for(Task task: tasks){
            line.append(serializeTask(task));
        }
        FileWriter fw = new FileWriter(FILEPATH);
        fw.write(line.toString());
        fw.close();
    }

    private static void loadData() throws FileNotFoundException{
        File f = new File(FILEPATH); // create a File for the given file path
        Scanner s = new Scanner(f); // create a scanner using the file as the source
        while(s.hasNext()){
            tasks.add(deserializeTask(s.nextLine()));
        }
    }

    private static Task deserializeTask(String serializedTask){
        Task task = null;
        String[] splitTask = serializedTask.split("\\|");

        String taskType = splitTask[0];
        boolean isDone = splitTask[1].equals("1");
        String description = splitTask[2].trim();

        switch (taskType){
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

    // T|1/0|Description
    // D|1/0|Description|by
    // E|1/0|Description|at
    private static String serializeTask(Task task){
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

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input;
        try{
            loadData();
        } catch(FileNotFoundException e) {
            // no save data, do nothing.
        }
        do {
            System.out.print("root@PC:~# ");
            input = in.nextLine();
        } while (handleInput(input) == 1);
        try {
            saveData(); //todo: implement an efficient method to save data each time receiving input
        } catch (IOException e){
            System.out.println("Failed to write data");
        }
        bye();
        in.close();
    }
}
