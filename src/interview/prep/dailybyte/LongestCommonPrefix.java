package interview.prep.dailybyte;

import java.util.Arrays;
/*
Daily Byte description:
This question is asked by Microsoft. Given an array of strings, return the longest common prefix that is shared amongst all strings.
Note: you may assume all strings only contain lowercase alphabetical characters.

Ex: Given the following arrays...

["colorado", "color", "cold"], return "col"
["a", "b", "c"], return ""
["spot", "spotty", "spotted"], return "spot"

Leet code description:
14. Longest Common Prefix
Easy

3765

2142

Add to List

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {
    //TC: O(N*M) SC: O(M) where M = length of the smallest string in strs. N= len of strs array
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0)
            return "";
        if(strs.length ==1 || strs[0].isEmpty())
            return strs[0];

        Arrays.sort(strs); //NlogN

        String primary = strs[0];
        int prefixLen = Integer.MAX_VALUE;
        String prefix="";
        for(int i=1; i<strs.length; i++){
            String next = strs[i];
            String overlap = findOverlap(primary, next,prefixLen);
            if(overlap.length() < prefixLen){
                prefixLen = overlap.length();
                prefix = overlap;
            }
        }
        return prefix;
    }

    //TC:O(N^3), SC: O(N)
    public String _longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0)
            return "";
        if(strs.length ==1)
            return strs[0];

        int prefixLen = Integer.MAX_VALUE;
        String prefix="";
        for(int i=0; i<strs.length; i++){
            String currWord = strs[i];
            for( int j=i+1; j<strs.length; j++){
                String next = strs[j];
                String overlap = findOverlap(currWord, next,prefixLen);
                if(overlap.length() < prefixLen){
                    prefixLen = overlap.length();
                    prefix = overlap;
                }
            }
        }
        return prefix;
    }

    private String findOverlap(String source, String target,int bound){
        if(source == null || target==null || source.isEmpty() || target.isEmpty())
            return "";


        int len = source.length()>target.length() ? target.length(): source.length();
        len = bound<len ?bound:len;

        int i=0;
        for(; i<len; i++){
            if(source.charAt(i) != target.charAt(i))
                break;
        }
        if(i==0)
            return "";
        return source.substring(0,i);
    }
}
/*
["flower","flow","flight"]
["dog","racecar","car"]
["colorado", "color", "cold"]
["a", "b", "c"]
["spot", "spotty", "spotted"]
["a"]
*/
