package interview.prep.leetcode;

import java.util.Arrays;

/*
 * Leetcode: Answer 242
 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class Anagram {
    public boolean isAnagram(String s, String t) {
    	if (s==null || t==null)
    			return false;
    	if (s.length() != t.length())
    			return false;
    	
        char[] sC = s.toCharArray();
        Arrays.parallelSort(sC);
        
        char[] sT = t.toCharArray();
        Arrays.parallelSort(sT);
        
        for (int i=0;i<sC.length;i++) {
        	if (sC[i]!= sT[i])
        		return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
//    	String s = "anagram", t="nagaram";
    	String s = "car", t="arc";
    	
    	System.out.println(new Anagram().isAnagram(s, t));
    }
}
