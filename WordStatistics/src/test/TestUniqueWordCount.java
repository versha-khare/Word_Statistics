/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.UniqueWordCount;

@SuppressWarnings("static-access")
public class TestUniqueWordCount {
	UniqueWordCount uniqueWord ;
	List<String> actualLine = new ArrayList<>();
	List<String> actualWord = new ArrayList<>();
	Map<Integer,String> actualMap = new HashMap<>();
	String actualText;
	
	
	 @Before
	    public void init() {
	       
		 
		 actualLine.add("This is Junit test case");
		 actualLine.add("Compile the test case and Test Runner classes");
		 actualWord.add("This"); actualWord.add("is");actualWord.add("Junit");actualWord.add("test");actualWord.add("case");
		 actualWord.add("Compile"); actualWord.add("the");actualWord.add("test");actualWord.add("case");actualWord.add("and");actualWord.add("Test");actualWord.add("Runner");actualWord.add("classes");
	     actualMap.put(1, "This"); actualMap.put(2, "is");actualMap.put(3, "Junit");actualMap.put(4, "test");actualMap.put(5, "case");actualMap.put(6, "Compile");actualMap.put(7, "the");actualMap.put(8, "test");
	     actualMap.put(9, "case");actualMap.put(10, "and");actualMap.put(11, "Test");actualMap.put(12, "Runner");actualMap.put(13, "classes");
	      actualText=" This  is  Junit  This  This  Compile  the  This  This  the  This  Runner  Compile ";
	 }
	 

	//test getLines() method
	@Test
	public void testGetLines() throws IOException
	{
		File inputFile = new File("testinputFile.txt");		
		List<String> lines ;
		lines = UniqueWordCount.getLines(inputFile);
		assertEquals(actualLine, lines);
	}

    //test getWords() method
	@Test
	public void testGetWords()
	{
		List<String> totWord ;
		totWord= uniqueWord.getWords(actualLine);
		assertEquals(actualWord, totWord);
		
	}
	
	//test getuniqueWordsWithCount() method
	@Test
	public void testGetuniqueWordsWithCount()
	{
		
		Map<Integer, String> expectedMap;
		expectedMap = uniqueWord.getuniqueWordsWithCount(actualWord);
		
		assertEquals(actualMap, expectedMap);
		
	}
	
	//test replaceSameOccurences() method
	@Test
	public void testReplaceSameOccurences()
	{
	  String expectedText=null; 	  
	  expectedText=uniqueWord.replaceSameOccurences(actualMap);
	  
	  assertEquals(actualText, expectedText);
	}
}
