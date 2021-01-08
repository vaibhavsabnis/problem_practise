package interview.prep.leetcode.jan21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Check If Two String Arrays are Equivalent

Solution
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.



Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true


Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.
 */
public class StringArrayEquivalent {
    public boolean _arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1 ==null || word2 == null)
            return false;

        StringBuilder sb1 = new StringBuilder();
        for(String piece: word1)
            sb1.append(piece);

        StringBuilder sb2 = new StringBuilder();
        for(String piece: word2)
            sb2.append(piece);

        return sb2.toString().equals(sb1.toString());
    }

    public boolean __arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1 ==null || word2 == null)
            return false;

        List<Character> one = convertToCharacterList(word1);
        List<Character> two = convertToCharacterList(word2);
        if(one.size() != two.size())
            return false;
        for(int i=0;i<one.size();i++){
            if(! one.get(i).equals(two.get(i))){
                return false;
            }
        }
        return true;
    }

    private List<Character> convertToCharacterList(String[] word1) {
        List<Character> ch = new ArrayList<>();
        for(String piece: word1){
            char[] temp = piece.toCharArray();
            for(char c: temp){
                ch.add(c);
            }
        }
        return ch;
    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0, w1 = 0, w2 = 0;
        while (w1<word1.length && w2<word2.length) {
            if (word1[w1].charAt(i) != word2[w2].charAt(j))
                return false;
            i++; j++;
            if (i == word1[w1].length()) {
                i=0; w1++;
            }
            if (j == word2[w2].length()) {
                j=0; w2++;
            }
        }
        //System.out.println("i:" + i + " j:"+j);
        return (w1==word1.length) && (w2==word2.length);
    }

    public static void main(String[] args) {
        StringArrayEquivalent sae = new StringArrayEquivalent();
        String[] word1 = {"a", "bc"}, word2 = {"ab", "c"};
        sae.arrayStringsAreEqual(word1,word2);
    }
}
