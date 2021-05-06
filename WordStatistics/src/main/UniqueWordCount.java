package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueWordCount {

	private static List<String> lines = new ArrayList<>();
	private static List<String> totWord = new ArrayList<>();
	private static int totalCharinFile;
	
	private static int totalLinesinFile;
	private static List<String> wordList = new ArrayList<>();
	 private static Map<Integer, String> replaceSimOccurences = new HashMap<>();
	private static String replaceLines;

	public static void main(String[] args) throws IOException {
		
		// input text document
		File inputFile = new File("inputFile.txt");
		List<String> allLines;
		
		List<String> allWords ;
		Map<Integer, String> allWordsWithSerial;
		
		allLines = getLines(inputFile);
		allWords=getWords(allLines);
		allWordsWithSerial= getuniqueWordsWithCount(allWords);
		replaceSameOccurences(allWordsWithSerial);
		
		
	}

	public static String replaceSameOccurences(Map<Integer, String> allWordsWithSerial) {
	
		for (Entry<Integer, String> entry : allWordsWithSerial.entrySet())
		{
			String s= entry.getValue();
			
			for (Entry<Integer, String> entry1 : allWordsWithSerial.entrySet())
			{
				String d =entry1.getValue();
				
				if (s.length()==d.length() && ! s.equalsIgnoreCase(d))
				{
					
					allWordsWithSerial.replace(entry1.getKey(),s);
				}
				
			}
			
		}
		
		for (Entry<Integer, String> entry : allWordsWithSerial.entrySet())
		{
			
			 replaceLines= replaceLines+" "+entry.getValue()+" ";
			 
		}
		
		
		 System.out.println("Replaced same Occurences from text --- "+replaceLines.substring(4));
		return replaceLines.substring(4);
		
	}

	public static Map<Integer, String> getuniqueWordsWithCount(List<String> allWords) {
		
		int keyOcc =1;
		for (String word : allWords) {
			
			if (word.endsWith(",") || word.endsWith(".") || word.endsWith("-")) {
				word = word.substring(0, word.length() - 1);
				replaceSimOccurences.put(keyOcc, word);
				
				wordList.add(word.toLowerCase());
			
			}

			else {
				replaceSimOccurences.put(keyOcc, word);
				
				wordList.add(word.toLowerCase());
				
			}
			keyOcc++;
		}
		Map<String, Integer> uniqueWordAndCount = new HashMap<>();
		int value=1;
		for (String word : wordList) {

			if (word.length() > 0 && uniqueWordAndCount.containsKey(word)) {
				uniqueWordAndCount.put(word, uniqueWordAndCount.get(word) + 1);

			} else if (word.length() > 0) {
				value = 1;
				uniqueWordAndCount.put(word, value);

			}
		}
		
		for (Entry<String, Integer> entry : uniqueWordAndCount.entrySet()) {
			String key = entry.getKey();
			int value2 = entry.getValue();

			System.out.println("Unique Word- '" + key + "'has" + " Count - '" + value2 + "'");
		}
		return replaceSimOccurences;
	}

	public static List<String> getWords(List<String> allLines) {
		
		for(String line : allLines)
			{
			
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) != ' ') {
					totalCharinFile++;
				}
			}

			String[] words = line.split(" ");
			for (String word:words)
			{
				totWord.add(word);
			}
		}
		
		System.out.println("Total number of characters except spaces :" + totalCharinFile);
		return totWord;
		
		}
		
	

	public static List<String> getLines(File inputFile) throws IOException {
		
		FileReader fileReader = new FileReader(inputFile);
		try(BufferedReader br = new BufferedReader(fileReader)){
		String s;
		while ((s = br.readLine()) != null)
		{
			lines.add(s);
			totalLinesinFile++;
		}}
		System.out.println("Total number of lines in Files :" + totalLinesinFile);
		
		return lines;
		
	}


}
