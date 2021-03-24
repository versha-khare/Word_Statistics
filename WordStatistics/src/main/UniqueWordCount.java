package main;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class UniqueWordCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File inputFile = new File("inputFile.txt");
		String[] words = null;

		FileReader fileReader = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fileReader);
		String s;
		while ((s = br.readLine()) != null) // Reading Content from the file
		{
			words = s.split(" ");

		}

		HashMap<String, Integer> uniqueWordAndCount = new HashMap<String, Integer>();

		int totword = 0;
		int value = 1;

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > 0 && uniqueWordAndCount.containsKey(words[i])) {
				uniqueWordAndCount.put(words[i], uniqueWordAndCount.get(words[i]) + 1);
				totword += 1;
			} else if (words[i].length() > 0) {
				value = 1;
				uniqueWordAndCount.put(words[i], value);
				totword += 1;
			}
		}

		for (Entry<String, Integer> entry : uniqueWordAndCount.entrySet()) {
			String key = entry.getKey();
			int value2 = entry.getValue();

			System.out.println("Unique Word- '" + key + "'has" + " Count - '" + value2+"'");
		}
	}

}
