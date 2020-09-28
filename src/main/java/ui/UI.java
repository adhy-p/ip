package ui;

import task.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the user interface of the application
 */
public class UI {
    private static Scanner in = new Scanner(System.in);

    private static void printLine() {
        System.out.println("----------------------------------------------");
    }

    /**
     * Prints welcome message
     */
    public static void greet() {
        printLine();
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    /**
     * Closes the scanner and prints exit message
     */
    public static void bye() {
        in.close();
        printLine();
        System.out.println("Bye. Hope to see you soon!");
        printLine();
    }

    /**
     * Prints the prompt and read user input
     *
     * @return the input given by the user
     */
    public static String prompt() {
        System.out.print("root@PC:~# ");
        return in.nextLine();
    }

    /**
     * Prints the message after successfully added a task to the list
     *
     * @param tasks the current list of tasks
     */
    public static void addToListMessage(ArrayList<Task> tasks) {
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        printLine();
    }

    /**
     * Prints the message for unknown command
     *
     * @param input the command given by the user
     */
    public static void handleUnknownCommandMessage(String input) {
        printLine();
        System.out.println("Huh? " + input + "?");
        System.out.println("Invalid command. Please try again.");
        printLine();
    }

    /**
     * Prints all tasks in the list
     *
     * @param tasks the list of current tasks
     */
    public static void printList(ArrayList<Task> tasks) {
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

    /**
     * Prints the message for done command
     *
     * @param description the description of the task marked as done
     */
    public static void markAsDoneMessage(String description) {
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[\u2713] " + description);
        printLine();
    }

    /**
     * Prints the message for delete command
     *
     * @param description the description of the deleted task
     * @param size        the size of TaskList after deletion
     */
    public static void deleteTaskMessage(String description, int size) {
        printLine();
        System.out.println("Got it! I've removed this task:");
        System.out.println(description);
        System.out.println("Now you have " + size + " tasks in the list.");
        printLine();
    }

    /**
     * Prints the error message for IO exception
     */
    public static void failToWriteMessage() {
        printLine();
        System.out.println("Failed to write data");
        printLine();
    }

    /**
     * Prints the error message for FileNotFound exception
     */
    public static void fileNotFoundMessage() {
        printLine();
        System.out.println("Error: save file not found");
        printLine();
    }

    /**
     * Prints the error message for invalid argument for certain commands
     * List of commands that requires one or more arguments:
     * deadline
     * delete
     * done
     * event
     * todo
     */
    public static void invalidArgumentMessage() {
        printLine();
        System.out.println("Invalid argument. Please try again.");
        printLine();
    }

    /**
     * Prints the message for executing find command without a keyword
     */
    public static void findWithoutArgumentMessage() {
        printLine();
        System.out.println("Missing argument. Executing list command.");
    }

    /**
     * Prints the error message for invalid date format
     */
    public static void invalidDateMessage() {
        printLine();
        System.out.println("Date should be in the format of YYYY-MM-DD HHmm");
        printLine();
    }

    /**
     * Prints list of tasks matching the keyword
     * If the list is empty, prints "Found no matching tasks!"
     *
     * @param tasks the list of filtered tasks
     */
    public static void printFilteredList(ArrayList<Task> tasks) {
        printLine();
        if (!tasks.isEmpty()) {
            int i = 1;
            for (Task item : tasks) {
                System.out.println((i++) + ". " + item);
            }
        } else {
            System.out.println("Found no matching tasks!");
        }
        printLine();
    }
}
