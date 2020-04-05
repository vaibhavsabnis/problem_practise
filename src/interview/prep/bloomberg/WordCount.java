package interview.prep.bloomberg;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Asked by Meenakshi (Bloomberg) on Feb 18th 2020. Round 1
 * @author vaibhav
 *
 */
public class WordCount {
	
	public static void main(String args[]) throws Exception{
		testMe();
	}

	private static void testMe() throws IOException {			
		String content = new String(Files.readAllBytes(Paths.get("C:\\vaibhav\\dev\\eclipse-workspace\\scatchpad\\src\\interview\\prep\\WordCount.java")), StandardCharsets.UTF_8);		
//		String[] str = new String ("This is the test function which is the "
//				+ " the best way to test function").split(" ");
		
		System.out.println(countWordFrequency(content.split(" "), 5));
	}
	
	/**
	 * Returns the top 'n' frequently occurring words in a list of words. 
	 * 
	 * @param words
	 * @param n
	 * @return
	 */
	private static List<String> countWordFrequency(String words[], int n) {
		
		List<String> listToRet = new ArrayList<String>(n);
		
		//get a map with counts of words. 		
		Map<String, Integer> wordMapCounts = new HashMap<String, Integer>();
		for (String word: words) {			
			if(wordMapCounts.get(word) != null ) {//word already present, so increment counter
				wordMapCounts.put(word, wordMapCounts.get(word)+1);
			}
			else {
				wordMapCounts.put(word,1);				
			}
		}
//		System.out.println(wordMapCounts);
		
		//Get the frequency count sorted in reverse order
		List<Integer> freqCount = new ArrayList<Integer>(wordMapCounts.values());
		Collections.sort(freqCount,Collections.reverseOrder());
		
//		System.out.println(freqCount);
		
		Set<String> keys = wordMapCounts.keySet();
		
		for (int i = 0; i<n;i++) {
			int valueToLookup = freqCount.get(i);
			for (String key: keys) {
				if(wordMapCounts.get(key) == valueToLookup) {					
					if(listToRet.contains(key+"("+valueToLookup+")")) {
						continue; 
					} 
					else {	
						listToRet.add(key+"("+valueToLookup+")");
					}
				}
			}
		}		
		return listToRet;
	}
	
	
}
