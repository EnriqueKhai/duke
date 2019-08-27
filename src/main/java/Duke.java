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

		String bye = "bye";
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();

		while (!bye.equals(userInput)) {
			System.out.println("       __________________________________________");
			System.out.println("       " + userInput);
			System.out.println("       __________________________________________");
			userInput = sc.nextLine();
		}

		System.out.println("       __________________________________________");
		System.out.println("       Bye. Hope to see you again soon!");
		System.out.println("       __________________________________________");
	}
}
