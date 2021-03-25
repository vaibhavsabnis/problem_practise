package interview.prep.leetcode;

import java.util.HashSet;
import java.util.Set;
/*
392. Is Subsequence
Easy

2300

229

Add to List

Share
Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubSequence {

    public static void main(String[] args) {
        IsSubSequence i = new IsSubSequence();
//        i.isSubsequence("abc", "ahbgdc");
//        i.isSubsequence("bb", "ahbgdc");
        i.isSubsequence("acb", "ahbgdc");
    }
    public boolean isSubsequence(String s, String t) {
        if(s == null ||t ==null || s.length() > t.length())
            return false;
        if(s.equals(t))
            return true;

        int sPtr = 0;
        int tPtr = 0;
        for( ;sPtr<s.length() ; sPtr++,tPtr++){
            char sChar = s.charAt(sPtr);
            if(tPtr < t.length() &&sChar == t.charAt(tPtr)){
                continue;
            }else {// try finding until next position of char
                while (tPtr < t.length() && sChar != t.charAt(tPtr)) {
                    tPtr++;
                }
            }
            if(tPtr >= t.length())
                return false;
        }

        return (sPtr <= s.length() && tPtr <= t.length());
    }

    //TC: O(N!), SC: O(N) where N = length of orig string
    public boolean _isSubsequence(String s, String t) {
        if(s == null ||t ==null || s.length() > t.length())
            return false;
        if(s.equals(t))
            return true;

        Set<String> subSeqSet = new HashSet<>();
        generateSubSequences(t, 0, "",0, subSeqSet );

        return subSeqSet.contains(s);
    }
    //TC: O(N!), SC: O(N) where N = length of orig string
    private void generateSubSequences(String orig, int origId, String subSeq, int subSeqId, Set<String> res){
        if(origId >= orig.length()){
            res.add(subSeq);
            return;
        }
        //exclude charAt origId
        generateSubSequences(orig, origId+1, subSeq, subSeqId, res);

        //include charAt origId
        subSeq += orig.charAt(origId);
        generateSubSequences(orig, origId+1, subSeq, subSeqId+1, res);
    }
}
/*
"acb"
"ahbgdc"
"bb"
"ahbgdc"
"a"
"a"
"abc"
"ahbgdc"
"axc"
"ahbgdc"
""
""
*/