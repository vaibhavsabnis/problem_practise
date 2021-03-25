package interview.prep.dailybyte;

import java.util.HashMap;
import java.util.Map;

/*
===
This question is asked by Microsoft. Given a string, return the index of its first unique character. If a unique character does not exist, return -1.

Ex: Given the following strings...

"abcabd", return 2
"thedailybyte", return 1
"developer", return 0
===

387. First Unique Character in a String
Easy

2778

139

Add to List

Share
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.


Note: You may assume the string contains only lowercase English letters.
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        if(s ==null || s.isEmpty())
            return -1;
        Map<Character,Integer> unique = new HashMap<>();
        for(char c: s.toCharArray())
            unique.put(c,unique.getOrDefault(c,0)+1);

        int minPos = -1;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(unique.get(curr)>1)
                continue;
            else
                return i;
        }
        return -1;
    }
}
