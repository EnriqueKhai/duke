import java.util.*;
import java.io.*;

/**
 *This class handles all the codes and methods required for the Duke Java Application to store (for later use) and load (from previously stored) the memory states of its objects.
 */
public class storage {

	/**
	 *This method attempts to find the File 'userHistory' that contains the last recorded memory states of the user's Tasks, failing which it will create one for current and future uses.
	 *@param filename refers to the name of the file ('userHistory') containing the relevant memory and object state information.
	 *@return the File in question.
	 */
	public static File findFile (String filename) {
		File userHistory = new File(filename);

		try {
			if (!userHistory.exists()) {
				userHistory.createNewFile();
			}
		} catch (IOException ex) {
			System.out.println("File was not created. [Error!]");
			System.out.println(ex);
		}

		return userHistory;
	}

	/**
	 *This method reads all previously recorded user inputs and recreates the object states of the latest use of the application.
	 *@param userHistory is a summary of all of the user's commands that directly or indirectly affect the object states of the application's memory.
	 *@param userCommands is an array of important user instructions such as "list" and "bye".
	 *@param userList is the list of Tasks currently being tracked by the user.
	 *@param input is the scanner object responsible of taking in commands from the user, whenever applicable.
	 *@param userEntry refers to the string input entered by the user.
	 */
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
			} else if (parse[0].equals("delete")) {
				int index = Integer.parseInt(parse[1]);
				index--;

				TaskList.removeTask(userList, index);

				if (input.hasNextLine()) {
					userEntry = input.nextLine();
				} else {
					break;
				}
			} else {
				Task j = TaskList.createTask(parse[0], parse[1]);
				userList.add(j);

				if (input.hasNextLine()) {
					userEntry = input.nextLine();
				} else {
					break;
				}
			}
		}
	}

	/**
	 *This method records all important commands entered by the user that will directly or indirectly change the memory state of the objects within the application in a file called 'userHistory'.
	 *@param userEntry refers to the string input entered by the user.
	 *@param userHistory is a summary of all of the user's commands that directly or indirectly affect the object states of the application's memory.
	 */
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
}
