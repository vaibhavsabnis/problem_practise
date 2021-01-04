package interview.prep.leetcode.easy.mustdo;
/*
242. Valid Anagram
Easy

2083

156

Add to List

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

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
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] idx = new int[26];
        for(char c: s.toCharArray())
            idx[c-'a']++;
        for(char c: t.toCharArray())
            idx[c-'a']--;

        for(int i:idx)
            if(i!=0)
                return false;
        return true;
    }

}
