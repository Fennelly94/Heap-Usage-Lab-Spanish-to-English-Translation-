import java.util.Scanner;

public class CommandLineInterface {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] agrs) {
		MaxHeap<Pair> myheap = new MaxHeap<Pair>();
		ReadFile.readFile(myheap);

		int choice = 0;
		do {
			System.out.println("**********MENU***********");
			System.out.println("1. Add Entry");
			System.out.println("3. Delete Entry");
			System.out.println("2. Search for an entry");
			System.out.println("3. Exit");
			System.out.println("> ");
			try {

				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1:
					addEntry(myheap);
					break;
				case 2:
					searchEntry(myheap);
					break;
				}

			} catch (NumberFormatException e) {
				choice = 0;
			}
		} while (choice != 3);
		System.out.println("GoodBye");

		WriteFile.writeFile(myheap);

	}

	public static void addEntry(MaxHeap<Pair> myheap) {
		System.out.println("Enter the new Spanish Word you wish to use:");
		String spanish = sc.nextLine();
		// Here it will give a user a chance to add the English translation of
		// that word
		System.out
				.println("Enter the new English translation of the Spanish Word:");
		String english = sc.nextLine();
		// This here will add the Spanish and English word to the heap.
		myheap.add(new Pair(spanish, english));

	}

	public static void searchEntry(MaxHeap<Pair> myheap) {
		// Asks the user what word they want to search for

		System.out.println("Enter a Spanish word to search for");

		String spanish2 = sc.nextLine();

		Pair found = myheap.search(new Pair(spanish2, null));
		if (found == null) {
			System.out.println("Could not find the word!!!");
		} else {
			System.out.println("spanish:" + found.getSpanishWord());
			System.out.println("english:" + found.getEnglishTranslation());
		}

		WriteFile.writeFile(myheap);
	}
}
		