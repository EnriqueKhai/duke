import java.util.*;
import java.io.*;

public class Duke {
	protected static Scanner inputHistory;
	protected static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ui.printIntro();

		File userHistory = storage.findFile("userHistory.txt"); 


		try {
			inputHistory = new Scanner(userHistory);
		} catch (IOException ex) {
			System.out.println("ERROR: " + ex);
		}


		String[] userCommands = {"bye", "list"};
		List<Task> userList = new ArrayList<Task>();


		//loads userHistory.txt
		if (inputHistory.hasNextLine()) {
			String userEntry = inputHistory.nextLine();
			storage.loadData(userHistory, userCommands, userList, inputHistory, userEntry);
		}

		//resumes from loaded user data
		String userEntry = input.nextLine();
		Parser.processData(userHistory, userCommands, userList, input, userEntry);

		ui.printOutro();

	}
}
