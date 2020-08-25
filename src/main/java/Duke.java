import java.util.Scanner;
public class Duke {
    static String lines = "-----------------------------------";

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

    public static void echo(String input){
        System.out.println(lines);
        System.out.println(input);
        System.out.println(lines);
    }

    public static void main(String[] args) {
        greet();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while(!input.equals("bye")){
            echo(input);
            input = in.nextLine();
        }
        bye();
        in.close();
    }
}
