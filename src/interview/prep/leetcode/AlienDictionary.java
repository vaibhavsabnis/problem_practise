package interview.prep.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 953. Verifying an Alien Dictionary
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > nothing , where nothing is defined as the blank character which is less than any other character (More info).
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
 */

public class AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
    	if(words.length ==1) //Guaranteed due to constraint 
    		return true;
    	
    	Map<Character,Integer> cMap = new HashMap<>();
    	
    	int seq = 1;
    	for(char c: order.toCharArray()) {
    		cMap.put(c,seq++);
    	}
    	
    	for(int i=0; i<words.length-1; i++) {
    		String currentWord = words[i];
    		String nextWord = words[i+1];
    		
    		if(currentWord == null && nextWord == null)
    			continue;
    		
    		//Check additional boundary conditions -- null checks, NPM etc.
    		
    		if(currentWord.length() > nextWord.length() )
    			return false; 
    		else {
    			char[] curr = currentWord.toCharArray(); 
    			char[] next = nextWord.toCharArray();
    			
    			for (int j=0;j<curr.length;j++) {
    				if (cMap.get(curr[j]) > cMap.get(next[j]))
    					return false;
    			}
    		}
    	}
    	return true;
    }
    
    public static void main(String a[]) {
    	String[] s = {"hello","leetcode"}; 
    	String order = "hlabcdefgijkmnopqrstuvwxyz";
    	System.out.println(new AlienDictionary().isAlienSorted(s, order));
    }
}
