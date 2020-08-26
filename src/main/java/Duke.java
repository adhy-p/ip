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
        tasks.add(new Task(input));
        printLine();
        System.out.println("added: " + input);
        printLine();
    }

    public static void printList(){
        printLine();
        int i = 1;
        for(Task item: tasks){
            System.out.println((i++) + ". " + item.getStatusIcon() + " " + item.getDescription());
        }
        printLine();
    }

    public static void markAsDone(int index){
        tasks.get(index - 1).markAsDone();
        printLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[\u2713] " + tasks.get(index - 1).getDescription());
        printLine();
    }
    public static void handleInput(String input){
        if(input.equals("list")) {
            printList();
        } else if(input.startsWith("done")){
            int index = Integer.parseInt(input.split("done")[1].trim());
            markAsDone(index);
        } else {
            addToList(input);
        }
    }
    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while(!input.equals("bye")){
            handleInput(input);
            input = in.nextLine();
        }
        bye();
        in.close();
    }
}
