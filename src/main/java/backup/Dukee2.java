import java.util.*;
import java.io.*;

/**
 * Javadoc summary... ?
 */
public class Duke {
	/**
	 * Javadoc comment... ? 
	 */
	public static void main(String[] args) {
		printIntro();

		//Loads saved state/ user's history.
		File userHistory = new File("userHistory.txt");

		String[] userCommands = {"bye", "list"};
		List<Task> userList = new ArrayList<Task>();

		Scanner input = new Scanner(System.in);
		String userEntry = input.nextLine();

		processData(userHistory, userCommands, userList, input, userEntry);
		/*while (!userEntry.equals(userCommands[0])) {
			String[] parse = userEntry.split(" ", 2);

			if (parse[0].equals("done")) {
				int index = Integer.parseInt(parse[1]);
				index--;

				userList.get(index).markAsDone();

				//Writes to userHistory when a task is marked as done.
				writeHistory(userEntry, userHistory);
				printDone(userList.get(index), index);

				userEntry = input.nextLine();
			} else {
				if (userEntry.equals(userCommands[1])) {
					printList(userList);

					userEntry = input.nextLine();
				} else {
					Task j = createTask(parse[0], parse[1], userList.size());
					userList.add(j);

					//Writes to userHistory when a task is added.
					writeHistory(userEntry, userHistory);
					userEntry = input.nextLine();
				}
			}
		}*/

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

	public static void processData(File userHistory, String[] userCommands, List<Task> userList, Scanner input, String userEntry) {	
		while (!userEntry.equals(userCommands[0])) {
			String[] parse = userEntry.split(" ", 2);

			if (parse[0].equals("done")) {
				int index = Integer.parseInt(parse[1]);
				index--;

				userList.get(index).markAsDone();

				//Writes to userHistory when a task is marked as done.
				writeHistory(userEntry, userHistory);
				printDone(userList.get(index), index);

				userEntry = input.nextLine();
			} else {
				if (userEntry.equals(userCommands[1])) {
					printList(userList);

					userEntry = input.nextLine();
				} else {
					Task j = createTask(parse[0], parse[1], userList.size());
					userList.add(j);

					//Writes to userHistory when a task is added.
					writeHistory(userEntry, userHistory);
					userEntry = input.nextLine();
				}
			}
		}
	}

	public static void writeHistory(String userEntry, File userHistory) {
		try {
			FileWriter fr = new FileWriter(userHistory, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter updateHistory = new PrintWriter(br);
			updateHistory.println(userEntry);
			updateHistory.close();
			br.close();
			fr.close();
		} catch (IOException ex) {
			System.out.println("ERROR: File 'userHistory.txt' does not exist!");
		}
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

	public static Task createTask(String type, String userEntry, int size) {

		size++;

		if (type.equals("deadline")) {
			String[] parse = userEntry.split(" /");
			String[] parse2 = parse[1].split(" ", 2);
			Deadline j = new Deadline(parse[0], parse2[1]);
			printAdded(j.getStatus(), size);
			return j;
		} else if (type.equals("event")) {
			String[] parse = userEntry.split(" /");
			String[] parse2 = parse[1].split(" ", 2);
			Event j = new Event(parse[0], parse2[1]);
			printAdded(j.getStatus(), size);
			return j;
		} else {
			ToDo j = new ToDo(userEntry);
			printAdded(j.getStatus(), size);
			return j;
		}
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
