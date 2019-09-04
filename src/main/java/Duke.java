import java.util.*;
import java.io.*;

public class Duke {

	public static void main(String[] args) {
		ui.printIntro();

		File userHistory = new File("userHistory.txt");
		//File userHistory = new File("C:/Users/Enrique Khai/Desktop/duke/src/main/java/userHistory.txt");

		String[] userCommands = {"bye", "list"};
		List<Task> userList = new ArrayList<Task>();


		//loads userHistory.txt
		try {
			Scanner input = new Scanner(userHistory);
			if (input.hasNextLine()) {
				String userEntry = input.nextLine();
				storage.loadData(userHistory, userCommands, userList, input, userEntry);
			}
		} catch (IOException ex) {
			System.out.println("ERROR: " + ex);
		}

		//resumes from loaded user data
		Scanner input = new Scanner(System.in);
		String userEntry = input.nextLine();
		Parser.processData(userHistory, userCommands, userList, input, userEntry);

		ui.printOutro();
	}
}
