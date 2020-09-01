import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void printLine(){
        System.out.println("-----------------------------------");
    }

    public static void greet(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void bye(){
        printLine();
        System.out.println("Bye. Hope to see you soon!");
        printLine();
    }

    public static void addToList(String input){
        if(input.startsWith("deadline")) {
            addDeadline(input);
        } else if(input.startsWith("event")){
            addEvent(input);
        } else if(input.startsWith("todo")){
            addTodo(input);
        } else {
            tasks.add(new Todo(input));
        }

        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        printLine();
    }

    private static void addTodo(String input) {
        input = input.split("todo")[1].trim();
        tasks.add(new Todo(input));
    }

    private static void addEvent(String input) {
        input = input.split("event")[1].trim();
        String description = input.split("/at")[0].trim();
        String time = input.split("/at")[1].trim();
        tasks.add(new Event(description, time));
    }

    private static void addDeadline(String input) {
        input = input.split("deadline")[1].trim();
        String description = input.split("/by")[0].trim();
        String by = input.split("/by")[1].trim();
        tasks.add(new Deadline(description, by));
    }

    public static void printList(){
        printLine();
        int i = 1;
        for(Task item: tasks){
            System.out.println((i++) + ". " + item);
        }
        printLine();
    }

    public static void markAsDone(int index){
        if(index <= tasks.size()) {
            tasks.get(index - 1).markAsDone();
            printLine();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[\u2713] " + tasks.get(index - 1).getDescription());
        } else {
            printLine();
            System.out.println("Invalid index!");
        }
        printLine();
    }

    public static int handleInput(String input){
        if(input.equals("bye")){
            return 0;
        }

        if(input.equals("list")) {
            printList();
        } else if(input.startsWith("done")){
            int index = Integer.parseInt(input.split("done")[1].trim());
            markAsDone(index);
        } else {
            addToList(input);
        }
        return 1;
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input;
        do {
            System.out.print("root@PC:~# ");
            input = in.nextLine();
        } while (handleInput(input) == 1);
        bye();
        in.close();
    }
}
