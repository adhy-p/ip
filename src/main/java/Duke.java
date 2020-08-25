public class Duke {
    public static void greet(){
        // simply greet the user and exit
        String lines = "-----------------------------------";
        System.out.println(lines);
        System.out.println("Hello, I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(lines);
        System.out.println("Bye. Hope to see you soon!");
        System.out.println(lines);
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();
    }
}
