import java.util.*;

/**
 *This class contains all operations that the user can perform on all Tasks added previously.
 */
public class TaskList {

	/**
	 *This method searches and shows all Tasks that are similar to the description provided by the user, every word in said description has to be part of the Task's description for it to be considered as being similar to what the user is looking for.
	 *@param userList is the list of all Tasks previously added by the user and is to be searched.
	 *@param userEntry is the description entered by the user in trying to find and list all Tasks similar to said description.
	 */
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

	/**
	 *This method allows the user to create Tasks to be tracked, be it of type 'Deadline', 'Event', 'ToDo' etc...
	 *@param type refers to the Task's type, and it is either 'Deadline', 'Event', or 'ToDo'.
	 *@param userEntry the actual string input as entered by the user. It contains information for the Task to be created.
	 *@return an object of type 'Deadline', 'Event', or 'ToDo', along with all the required information.
	 */
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

	/**
	 *This method deletes a Task, as specified by the user, from userList.
	 *@param userList refers to the List containing all Tasks previously added.
	 *@param index refers to the identification number of the Task (1-based indexing) that the user wants to delete.
	 */
	public static void removeTask (List<Task> userList, int index) {
		userList.remove(index);
	}
}
