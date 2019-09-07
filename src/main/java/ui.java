import java.util.*;

/**
 *This class handles all codes and operations that involvement interaction and IO interactions with the user.
 */
public class ui {

	/**
	 *Prints the introductory messages each time the Duke Java Application is run by the user.
	 */
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

	/**
	 *Prints the acknowledgement that the Task the user wants to mark as done has been marked as done.
	 *@param j is the Task the user wants to mark as done.
	 *@param index refers to the index of the Task that the user wants to mark as done.
	 */
	public static void printDone(Task j, int index) {
		index++;
		printHorizontalLines();
		System.out.println("       Nice! I've marked this task as done:");
		System.out.println("       " + index + ". " + j.getStatus());
		printHorizontalLines();
	}

	/**
	 *Prints the acknowledgement that the Task the user wants to add has been added.
	 *@param getStatus the status of the Task that has just been added and is to be printed.
	 *@param size refers to the total number of Tasks added by the user.
	 */
	public static void printAdded(String getStatus, int size) {
		printHorizontalLines();
		System.out.println("       Got it. I've added this task:");
		System.out.println("         " + getStatus);
		System.out.println("       Now you have " + size + " tasks in the list.");
		printHorizontalLines();
	}

	/**
	 *Prints an acknowledgement that a Task has been removed whenever the user wants to remove a Task.
	 *@param j is the Task that is to be removed.
	 *@param size refers to the total number of Tasks left after the Task to be removed has been removed.
	 */
	public static void printRemoved (Task j, int size) {
		printHorizontalLines();
		System.out.println("       Noted. I've removed this task: ");
		System.out.println("        " + j.getStatus());
		System.out.println("       Now you have " + size + " tasks in the list");
		printHorizontalLines();
	}

	/**
	 *This method allows the user to list all Tasks currently added and to be tracked.
	 *@param userList is the list of all previously added Tasks that are to be tracked.
	 */
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

	/**
	 *Prints the exit message each time the user wants to exit the Java Application.
	 */
	public static void printOutro() {
		printHorizontalLines();
		System.out.println("       Bye. Hope to see you again soon!");
		printHorizontalLines();
	}

	/**
	 *A simple method to print a horizontal bar line, for aesthetic purposes.
	 */
	public static void printHorizontalLines() {
		System.out.println("       ___________________________________________________________");
	}
}
