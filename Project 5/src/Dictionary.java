/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Project Number: 5
 * Program that acts as an auto grader for students in each class
 */
import java.io.*;
import java.util.*;

public class Dictionary {
	private ArrayList<String> dictionary = new ArrayList<>();
	
	//Information
	public int getVocabularySize() {
		return dictionary.size();	
	}
	
	//Loads dictionary
	public boolean loadDictionaryFromFile(String filePath) {
		File words = new File(filePath);
		Scanner type = null;
		try {
			type = new Scanner (words);
		}
		//Throws exception
		catch (IOException e) {
			return false;
		}
		//Adds word
		if (words.exists()) {
			while (type.hasNext()) {
				dictionary.add(type.next());
			}
			type.close();
			return true;
		}
		else {
			type.close();
			return false;
		}
	}
	
	public boolean isWord(String word) {
		//received help from student: Chris Hoyek
		if(dictionary.contains(word.toLowerCase()) || dictionary.contains(word.toUpperCase())) {
			return true;
		//end help from student: Chris Hoyek
		} 
		else {
			return false;
		}
	}
}
