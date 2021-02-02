package interview.prep.leetcode.easy.mustdo;

import java.util.HashMap;
import java.util.Map;

/*
 *290. Word Pattern
Easy

1681

206

Add to List

Share
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */
public class WordPattern { public boolean wordPattern(String pattern, String s) {
    Map<Character, String> patternMap = new HashMap<>();
    Map<String, Character> reverseMap = new HashMap<>();

    String[] sArr = s.split(" ");
    char[] ch = pattern.toCharArray();
    if(ch.length != sArr.length)
        return false;

    for(int i=0; i<ch.length;i++){
        Character pat= ch[i];
        String str = sArr[i];

        if(patternMap.get(pat)!=null || reverseMap.get(str)!=null){
            if(!patternMap.getOrDefault(pat,"").equals(str) || !reverseMap.getOrDefault(str,'-').equals(pat)){
                return false;
            }
        }else{
            patternMap.put(pat,str);
            reverseMap.put(str,pat);
        }
    }
    return true;
}
}
/*
"abba"
"dog cat cat dog"
"abba"
"dog cat cat fish"
"aaaa"
"dog cat cat dog"
"abba"
"dog dog dog dog"
*/