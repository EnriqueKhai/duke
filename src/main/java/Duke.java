import java.util.*;
import java.io.*;

public class Duke {

	public static void main(String[] args) {
		printIntro();

		File userHistory = new File("userHistory.txt");
		//File userHistory = new File("C:/Users/Enrique Khai/Desktop/duke/src/main/java/userHistory.txt");

		String[] userCommands = {"bye", "list"};
		List<Task> userList = new ArrayList<Task>();

		//loads userHistory.txt
		try {
			Scanner input = new Scanner(userHistory);
			String userEntry = input.nextLine();
			loadData(userHistory, userCommands, userList, input, userEntry);
		} catch (IOException ex) {
			System.out.println("ERROR: " + ex);
		}

		//resumes from loaded user data
		Scanner input = new Scanner(System.in);
		String userEntry = input.nextLine();
		processData(userHistory, userCommands, userList, input, userEntry);

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

	public static void loadData(File userHistory, String[] userCommands, List<Task> userList, Scanner input, String userEntry) {	
		while (true) {
			String[] parse = userEntry.split(" ", 2);

			if (parse[0].equals("done")) {
				int index = Integer.parseInt(parse[1]);
				index--;
				userList.get(index).markAsDone();

				if (input.hasNextLine()) {
					userEntry = input.nextLine();
				} else {
					break;
				}
			} else {
				Task j = createTask(parse[0], parse[1]);
				userList.add(j);

				if (input.hasNextLine()) {
					userEntry = input.nextLine();
				} else {
					break;
				}
			}
		}
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
					Task j = createTask(parse[0], parse[1]);
					userList.add(j);

					int size = userList.size();
					size++;
					printAdded(j.getStatus(), size);

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

	public static Task createTask(String type, String userEntry) {
		if (type.equals("deadline")) {
			String[] parse = userEntry.split(" /");
			String[] parse2 = parse[1].split(" ", 2);
			
			String output = regexCheck(parse2[1]);

			Deadline j = new Deadline(parse[0], output);
			return j;
		} else if (type.equals("event")) {
			String[] parse = userEntry.split(" /");
			String[] parse2 = parse[1].split(" ", 2);
			
			String output = regexCheck(parse2[1]);

			Event j = new Event(parse[0], output);
			return j;
		} else {
			ToDo j = new ToDo(userEntry);
			return j;
		}
	}

	public static String regexCheck(String preOutput) {
		String[] parse = preOutput.split(" ");

		boolean dateFound = false;
		boolean timeFound = false;
		String date = "";
		String time = "";

		for (String s:parse) {
			if (s.matches("\\d{2}/\\d{2}/\\d{4}")) {
				dateFound = true;
				
				String[] parseDate = s.split("/");

				int day = Integer.parseInt(parseDate[0]);
				int month = Integer.parseInt(parseDate[1]);
				int year = Integer.parseInt(parseDate[2]);

				date += Integer.toString(day);

				String[] prefix = {"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
							"th", "th", "th", "th", "th", "th", "th", "th", "th", "th"};
				String[] monthNames = { "indexCorrection", "January", "February", "March", "April", "May", "June",
							"July", "August", "September", "October", "November", "December"};

				date = date + prefix[day%20] + " of " + monthNames[month] + " " + parseDate[2];
			} else if (s.matches("\\d{4}")) {
				timeFound = true;

				int militaryTime = Integer.parseInt(s);
				int hour = militaryTime / 100;
				int min = militaryTime % 100;

				if (hour >= 13) {
					hour -= 12;
					time += Integer.toString(hour);
				} else {
					time += Integer.toString(hour);
				}

				if (min >= 10) {
					time = time + "." + Integer.toString(min);
				} else {
					time = time + ".0" + Integer.toString(min);
				}

				hour += 12;
				if (hour >= 12) {
					time += "pm";
				} else {
					time += "am";
				}
			}
		}

		String modifiedOutput = date + (dateFound && timeFound ? ", " : "") + time;

		if (dateFound || timeFound) {
			return modifiedOutput;
		} else {
			return preOutput;
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
