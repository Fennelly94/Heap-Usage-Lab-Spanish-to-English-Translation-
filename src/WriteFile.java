import java.io.BufferedWriter;

/**
 * @author Gavin Fennelly
 * @version 1 Created: 01/005/2016
 * @Last edited: 10/05/2016
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void writeFile(MaxHeap<Pair> heap) {
		BufferedWriter bw = null;
		try {
			File file = new File("AdditionalSpanishWords.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for (int i = 1; i <= heap.getSize(); i++) {
				Pair p = heap.get(i);
				bw.write(p.getSpanishWord() + "\t" + p.getEnglishTranslation()
						+ "\n");
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}

}
