package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class UniqueWordCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// input text document
		File inputFile = new File("inputFile.txt");
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> wordList = new ArrayList<String>();
		String[] words = null;

		int totalLinesinFile = 0;
		int totalCharinFile = 0;

		// reading file data
		FileReader fileReader = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fileReader);
		String s;
		while ((s = br.readLine()) != null) // Reading Content from the file
		{

			lines.add(s);
			for (String line : lines) {

				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) != ' ') {
						totalCharinFile++;
					}
				}

				words = line.split(" ");
			}
			for (String word : words) {
				if (word.endsWith(",") || word.endsWith(".") || word.endsWith("-")) {
					word = word.substring(0, word.length() - 1);
					wordList.add(word.toLowerCase());
				}

				else {
					wordList.add(word.toLowerCase());
				}
			}

			totalLinesinFile++;

		}

		// printing total number of line in text file
		System.out.println("Total number of lines in Files :" + totalLinesinFile);
		// printing total number of characters in text file except spaces
		System.out.println("Total number of characters except spaces :" + totalCharinFile);

		HashMap<String, Integer> uniqueWordAndCount = new HashMap<String, Integer>();

		int value = 1;
		// finding unique words and its count and add it to hashmap
		for (String word : wordList) {

			if (word.length() > 0 && uniqueWordAndCount.containsKey(word)) {
				uniqueWordAndCount.put(word, uniqueWordAndCount.get(word) + 1);

			} else if (word.length() > 0) {
				value = 1;
				uniqueWordAndCount.put(word, value);

			}
		}
		// print unique word and count of all occurences
		for (Entry<String, Integer> entry : uniqueWordAndCount.entrySet()) {
			String key = entry.getKey();
			int value2 = entry.getValue();

			System.out.println("Unique Word- '" + key + "'has" + " Count - '" + value2 + "'");
		}
	}

}
