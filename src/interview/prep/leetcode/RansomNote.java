package interview.prep.leetcode;

import java.util.*;
/*
 * Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine==null || ransomNote==null)
            return false; 
        
        
        Map<Character, Integer> mMap = new HashMap<>();
        
        for(char c:magazine.toCharArray()) {
        	mMap.put(c,mMap.getOrDefault(c, 0)+1);
        }
        
        char[] r = ransomNote.toCharArray();
        for(int i =0; i<r.length; i++) {
        	if(mMap.containsKey(r[i])) {
        		if(mMap.get(r[i])>1){
        			mMap.put(r[i],mMap.get(r[i])-1);
        		}else {
        			mMap.remove(r[i]);
        		}
        	}
        	else {
        		return false; 
        	}
        }
        return true;
	}
	
	public void myWrapper(String ransomNote, String magazine) {
		System.out.println(canConstruct(ransomNote, magazine));
	}
	
	public static void main(String[] args) {
		new RansomNote().myWrapper("a","b");
		new RansomNote().myWrapper("aa","ab");
		new RansomNote().myWrapper("aa","aba");
		new RansomNote().myWrapper("","");
		new RansomNote().myWrapper("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj");
		
	}

}
