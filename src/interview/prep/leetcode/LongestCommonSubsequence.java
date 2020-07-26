package interview.prep.leetcode;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 


""

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 */

public class LongestCommonSubsequence {
	
	
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1 ==null || text2 == null)
			return 0;
		
		int len1 = text1.length();
		int len2 = text2.length();
		
        if(len1 == len2)
        	return (text1.equals(text2))?len1 :0 ;
        
		String str1 = text1;
		String str2 = text2;
//		if (len1<len2) {
//			str1 = text2; 
//			str2=text1;
//		}
		
        Set<Character> set2 = convertToSet(str2);
        str1 = getStrippedString(str1, set2);
        
        Set<Character> set1 = convertToSet(str1);
        str2 = getStrippedString(str2, set1);
        
        return str1.equals(str2)?str1.length():0;
    }
	
	private Set<Character> convertToSet(String s){
		return s.chars().mapToObj(e ->(char)e).collect(Collectors.toSet());
	}
	
	private String getStrippedString(String s, Set<Character> set) {
		char[] c1= s.toCharArray();
        
        for(int i=0; i<c1.length; i++) {
        	if (!set.contains(c1[i]))
        		c1[i] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(char c:c1) {
        	if (c == 0)
        		continue;
        	sb.append(c);
        }
        
        return sb.toString();
	}

	
	
	public void myWrapper(String text1, String text2) {
		System.out.println(longestCommonSubsequence (text1, text2));
	}
	public static void main(String[] args) {
		new LongestCommonSubsequence().myWrapper("abcde", "ace");
		new LongestCommonSubsequence().myWrapper("abc", "abc");
		new LongestCommonSubsequence().myWrapper("abc", "def");	
		new LongestCommonSubsequence().myWrapper("abcde", "ae");
		new LongestCommonSubsequence().myWrapper("bl", "yby");
		new LongestCommonSubsequence().myWrapper("ezupkr", "ubmrapg");
	}

}
