package ui;

import task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static Scanner in = new Scanner(System.in);

    private static void printLine() {
        System.out.println("----------------------------------------------");
    }

    public static void greet() {
        printLine();
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void bye() {
        in.close();
        printLine();
        System.out.println("Bye. Hope to see you soon!");
        printLine();
    }

    public static String prompt() {
        System.out.print("root@PC:~# ");
        return in.nextLine();
    }

    public static void addToListMessage(ArrayList<Task> tasks) {
        printLine();
        System.out.println("Got it bro. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        printLine();
    }

    public static void handleUnknownCommandMessage(String input) {
        printLine();
        System.out.println("Huh? " + input + "?");
        System.out.println("You haven't read the documentation, have you?");
        printLine();
    }

    public static void noDescriptionExceptionMessage() {
        printLine();
        System.out.println("Please give me more details..");
        printLine();
    }

    public static void notEnoughArgumentsMessage() {
        printLine();
        System.out.println("Forgot to type something?");
        System.out.println("I need both the description and the time!!");
        printLine();
    }

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

    public static void markAsDoneMessage(String description) {
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[\u2713] " + description);
        printLine();
    }

    public static void deleteTaskMessage(String description, int size) {
        printLine();
        System.out.println("Got it! I've removed this task:");
        System.out.println(description);
        System.out.println("Now you have " + size + " tasks in the list.");
        printLine();
    }

    public static void invalidIndexMessage() {
        printLine();
        System.out.println("Hey bro.. Don't try to break me okay.. Invalid index.");
        printLine();
    }

    public static void doneMessage() {
        printLine();
        System.out.println("Done using the program? You should type \"bye\" instead.");
        printLine();
    }

    public static void failToWriteMessage() {
        printLine();
        System.out.println("Failed to write data");
        printLine();
    }

    public static void fileNotFoundMessage() {
        printLine();
        System.out.println("Error: save file not found");
        printLine();
    }

    public static void invalidArgumentMessage() {
        printLine();
        System.out.println("Invalid argument. Please try again.");
        printLine();
    }

    public static void findWithoutArgumentMessage() {
        printLine();
        System.out.println("Missing argument. Executing list command.");
        printLine();
    }
    public static void invalidDateMessage() {
        printLine();
        System.out.println("Date should be in the format of YYYY-MM-DD HHmm");
        System.out.println("Type 0000 for the time if you don't want to include the time");
        printLine();
    }
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
