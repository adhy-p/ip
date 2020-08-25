import java.util.Scanner;
public class Duke {
    static String lines = "-----------------------------------";
    private static String[] list = new String[100];
    private static Boolean[] isDone = new Boolean[100];
    private static int listCount =0;

    public static void greet(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(lines);
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(lines);
    }

    public static void bye(){
        System.out.println(lines);
        System.out.println("Bye. Hope to see you soon!");
        System.out.println(lines);
    }

    public static void addToList(String input){
        list[listCount] = input;
        isDone[listCount++] = false;

        System.out.println(lines);
        System.out.println("added: " + input);
        System.out.println(lines);
    }

    public static void printList(){
        System.out.println(lines);
        for(int i = 0; i < listCount; i++) {
            System.out.println((i+1) + ". " + (isDone[i] ? "[\u2713] " : "[\u2718] ") + list[i]);
        }
        System.out.println(lines);
    }

    public static void markAsDone(int index){
        isDone[index - 1] = true;
        System.out.println(lines);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[\u2713] " + list[index - 1]);
        System.out.println(lines);
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while(!input.equals("bye")){
            if(input.equals("list")) {
                printList();
            } else if(input.startsWith("done")){
                int index = Integer.parseInt(input.split("done")[1].trim());
                markAsDone(index);
            } else {
                addToList(input);
            }
            input = in.nextLine();
        }
        bye();
        in.close();
    }
}
