/**
 * @author Gavin Fennelly
 * @version 1 Created: 01/005/2016
 * @Last edited: 10/05/2016
 */
public class Pair implements Comparable<Object> {
	private String spanishWord;
	private String englishTranslation;

	public Pair(String spanishWord, String englishTranslation) {
		this.spanishWord = spanishWord;
		this.englishTranslation = englishTranslation;
	}

	public String getSpanishWord() {
		return spanishWord;
	}

	public String getEnglishTranslation() {
		return englishTranslation;
	}
	//comparing pair p and this based on Spanish word
	@Override
	public int compareTo(Object o) {
		Pair p = (Pair) o;
		return spanishWord.compareTo(p.getSpanishWord());
	}

	// Searches for the word by looking for the Spanish word until it finds a
	// match
	// where it equals a word in the text file.
	@Override
	public boolean equals(Object obj) {
		Pair p = (Pair) obj;
		return spanishWord.equals(p.getSpanishWord());
	}

	{

	}

}
