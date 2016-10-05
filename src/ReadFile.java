/**
 * @author Gavin Fennelly
 * @version 1 Created: 01/005/2016
 * @Last edited: 10/05/2016
 */
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	private static Scanner sc = new Scanner(System.in);

	public static void readFile(MaxHeap<Pair> myheap) {
		BufferedReader br = null;
		// Just in case of an error it will catch it
		try {
			// Reads whatever is in the SpanishWords.txt file to the console
			// window
			br = new BufferedReader(new FileReader("SpanishWords.txt"));
			// reads one line of text at a time from the string
			String oneLine = br.readLine();
			// Keeps reading all lines until its equal to null
			while (oneLine != null) {
				System.out.println(oneLine);

				// Takes in the Spanish word and translates it to English
				// Makes all the words into separate strings using ("\\s+").
				String[] words = oneLine.split("\\s+");
				String englishTranslation = "";
				for (int i = 1; i < words.length; i++)
					englishTranslation += words[i] + " ";

				myheap.add(new Pair(words[0], englishTranslation));
				oneLine = br.readLine();

			}

			// In the case of an error it will be caught here
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Implements a max heap called pair
		MaxHeap<Pair> myheap = new MaxHeap<Pair>();
		// initialised as null to begin with
		BufferedReader br = null;
		// Just in case of an error it will catch it
		try {
			// Reads whatever is in the SpanishWords.txt file to the console
			// window
			br = new BufferedReader(new FileReader("SpanishWords.txt"));
			// reads one line of text at a time from the string
			String oneLine = br.readLine();
			// Keeps reading all lines until its equal to null
			while (oneLine != null) {
				System.out.println(oneLine);

				// Takes in the Spanish word and translates it to English
				// Makes all the words into separate strings using ("\\s+").
				String[] words = oneLine.split("\\s+");
				// System.out.println("*" + words[0] + "*");
				myheap.add(new Pair(words[0], oneLine));
				oneLine = br.readLine();

			}

			// In the case of an error it will be caught here
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// Splits up the actual words in the text file from the option which
		// allows a user
		System.out.println("==========================================");
		// Enter new words and there English translation
		// Here it will give the user a chance to add a Spanish word to the text
		// file
		System.out.println("Enter the new Spanish Word you wish to use:");
		String spanish = sc.nextLine();
		// Here it will give a user a chance to add the English translation of
		// that word
		System.out.println("Enter the new English translation of the Spanish Word:");
		String english = sc.nextLine();
		// This here will add the Spanish and English word to the heap.
		myheap.add(new Pair(spanish, english));

		// Asks the user what word they want to search for
		System.out.println("-------------");
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