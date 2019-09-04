import java.util.*;

public class TaskList {

	public static void findTask (List<Task> userList, String userEntry) {
		ui.printHorizontalLines();
		System.out.println("       Here are the matching tasks in your list:");

		int index = 1;
		String[] removeFind = userEntry.split(" ", 2);
		String[] parse = removeFind[1].split(" ");

		for (Task j: userList) {
			String taskDescription = j.getStatus();
			String[] parseDescription = taskDescription.split(" ");

			boolean taskNotMatch = false;

			for (String s: parse) {
				boolean foundInParseDescription = false;

				for (String ss: parseDescription) {
					if (ss.equals(s)) {
						foundInParseDescription = true;
					}
				}

				if (!foundInParseDescription) {
					taskNotMatch = true;
					break;
				}
			}		

			if (!taskNotMatch) {
				System.out.println("       " + index + "." + j.getStatus());
				index++;
			}
		}

		ui.printHorizontalLines();
	}

	public static Task createTask(String type, String userEntry) {
		if (type.equals("deadline")) {
			String[] parse = userEntry.split(" /");
			String[] parse2 = parse[1].split(" ", 2);
			
			String output = Parser.regexCheck(parse2[1]);

			Deadline j = new Deadline(parse[0], output);
			return j;
		} else if (type.equals("event")) {
			String[] parse = userEntry.split(" /");
			String[] parse2 = parse[1].split(" ", 2);
			
			String output = Parser.regexCheck(parse2[1]);

			Event j = new Event(parse[0], output);
			return j;
		} else {
			ToDo j = new ToDo(userEntry);
			return j;
		}
	}

	public static void removeTask (List<Task> userList, int index) {
		userList.remove(index);
	}
}
