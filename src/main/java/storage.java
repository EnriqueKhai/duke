import java.util.*;
import java.io.*;

public class storage {

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
