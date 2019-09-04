import java.util.*;

public class ui {

	public static void printIntro() {
		String logo = " ____        _        \n"
			+ "|  _ \\ _   _| | _____ \n"
			+ "| | | | | | | |/ / _ \\\n"
			+ "| |_| | |_| |   <  __/\n"
			+ "|____/ \\__,_|_|\\_\\___|\n";
		System.out.println("Hello from\n" + logo);
		System.out.println("Hello, I'm Duke.");
		System.out.println("What can I do for you?");
	}

	public static void printDone(Task j, int index) {
		index++;
		printHorizontalLines();
		System.out.println("       Nice! I've marked this task as done:");
		System.out.println("       " + index + ". " + j.getStatus());
		printHorizontalLines();
	}

	public static void printAdded(String getStatus, int size) {
		printHorizontalLines();
		System.out.println("       Got it. I've added this task:");
		System.out.println("         " + getStatus);
		System.out.println("       Now you have " + size + " tasks in the list.");
		printHorizontalLines();
	}

	public static void printRemoved (Task j, int size) {
		printHorizontalLines();
		System.out.println("       Noted. I've removed this task: ");
		System.out.println("        " + j.getStatus());
		System.out.println("       Now you have " + size + " tasks in the list");
		printHorizontalLines();
	}

	public static void printList(List<Task> userList) {
		printHorizontalLines();
		System.out.println("       Here are the tasks in your list:");

		int index = 1;
		for (Task j: userList) {
			System.out.println("       " + index + ". " + j.getStatus());
			index++;
		}

		printHorizontalLines();
	}

	public static void printOutro() {
		printHorizontalLines();
		System.out.println("       Bye. Hope to see you again soon!");
		printHorizontalLines();
	}

	public static void printHorizontalLines() {
		System.out.println("       ___________________________________________________________");
	}
}
