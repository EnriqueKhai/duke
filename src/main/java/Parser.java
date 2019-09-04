import java.util.*;
import java.io.*;

public class Parser {

	public static void processData(File userHistory, String[] userCommands, List<Task> userList, Scanner input, String userEntry) {	
		while (!userEntry.equals(userCommands[0])) {
			String[] parse = userEntry.split(" ", 2);

			if (parse[0].equals("done")) {
				int index = Integer.parseInt(parse[1]);
				index--;

				userList.get(index).markAsDone();

				//Writes to userHistory when a task is marked as done.
				storage.writeHistory(userEntry, userHistory);
				ui.printDone(userList.get(index), index);

				userEntry = input.nextLine();
			} else if (parse[0].equals("find")) {
				TaskList.findTask(userList, userEntry);

				userEntry = input.nextLine();
			} else if (parse[0].equals("delete")) {
				int index = Integer.parseInt(parse[1]);
				index--;

				int size = userList.size();
				size--;

				ui.printRemoved(userList.get(index), size);
				TaskList.removeTask(userList, index);

				//Writes to userHistory when a task is marked as done.
				storage.writeHistory(userEntry, userHistory);

				userEntry = input.nextLine();
			} else if (parse[0].equals("todo") ||
				   parse[0].equals("deadline") ||
				   parse[0].equals("event") ||
				   parse[0].equals("list")) {
				if (userEntry.equals(userCommands[1])) {
					ui.printList(userList);

					userEntry = input.nextLine();
				} else {
					Task j = TaskList.createTask(parse[0], parse[1]);
					userList.add(j);

					int size = userList.size();
					ui.printAdded(j.getStatus(), size);

					//Writes to userHistory when a task is added.
					storage.writeHistory(userEntry, userHistory);
					userEntry = input.nextLine();
				}
			} else {
				System.out.println("Command: '" + userEntry + "' not recognised, please try again.");
				userEntry = input.nextLine();
			}
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
}
