package interview.prep.leetcode.google;

import java.util.HashSet;
import java.util.Set;

/*
 * 3. Longest Substring Without Repeating Characters
Medium

11409

629

Add to List

Share
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */

public class LongestSubStringWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0; 
        if(s.length() ==1)
            return 1; 
        
        int max =0; 
        int st=0; 
        int en=0; 
        Set<Character> dist = new HashSet<>(); 
        
        while(en<s.length()){
            char curr = s.charAt(en); 
            
            if(!dist.contains(curr)){
                dist.add(curr); 
                en++; 
                max = Math.max(max,dist.size());
            }else{
                dist.remove(s.charAt(st++));
            }                
        }
        // System.out.println(dist); 
        return max; 
    }
}
/*
"abcabcbb"
"bbbb"
"pwwkew"
""
*/
