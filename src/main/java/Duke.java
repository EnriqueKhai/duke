import java.util.Scanner;

/**
 * Javadoc summary... ?
 */
public class Duke {
	/**
	 * Javadoc comment... ? 
	 */
	public static void main(String[] args) {
		String logo = " ____        _        \n"
			+ "|  _ \\ _   _| | _____ \n"
			+ "| | | | | | | |/ / _ \\\n"
			+ "| |_| | |_| |   <  __/\n"
			+ "|____/ \\__,_|_|\\_\\___|\n";
		System.out.println("Hello from\n" + logo);
		System.out.println("Hello, I'm Duke.");
		System.out.println("What can I do for you?");

		int currIndex = 0;
		String[] userInputs = new String[100];
		String bye = "bye";
		String bye1 = "list";
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();

		while (!bye.equals(userInput)) {
			if (bye1.equals(userInput)) {
				System.out.println("       __________________________________________");
				for (int i = 0; i < currIndex; i++) {
					int j = i + 1;
					System.out.println("       " + j + ". " + userInputs[i]);
				}				
				System.out.println("       __________________________________________");
				userInput = sc.nextLine();
				continue;
			}

			System.out.println("       __________________________________________");
			System.out.println("       added: " + userInput);
			System.out.println("       __________________________________________");
			userInputs[currIndex] = userInput;
			currIndex++;
			userInput = sc.nextLine();
		}


		System.out.println("       __________________________________________");
		System.out.println("       Bye. Hope to see you again soon!");
		System.out.println("       __________________________________________");
	}
}
