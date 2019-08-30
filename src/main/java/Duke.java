import java.util.*;

/**
 * Javadoc summary... ?
 */
public class Duke {
	/**
	 * Javadoc comment... ? 
	 */
	public static void main(String[] args) {
		printIntro();

		String[] userCommands = {"bye", "list"};
		List<Task> userList = new ArrayList<Task>();

		Scanner input = new Scanner(System.in);
		String userEntry = input.nextLine();

		while (!userEntry.equals(userCommands[0])) {
			String[] parse = userEntry.split(" ");

			if (parse[0].equals("done")) {
				int index = Integer.parseInt(parse[1]);
				index--;

				userList.get(index).markAsDone();
				printDone(userList.get(index), index);

				userEntry = input.nextLine();
			} else {
				if (userEntry.equals(userCommands[1])) {
					printList(userList);

					userEntry = input.nextLine();
				} else {
					Task j = new Task(userEntry);
					userList.add(j);

					printAdded(userEntry);

					userEntry = input.nextLine();
				}
			}
		}

		printOutro();
	}

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

	public static void printAdded(String userEntry) {
		printHorizontalLines();
		System.out.println("       added: " + userEntry);
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
