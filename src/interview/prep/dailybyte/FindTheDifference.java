package interview.prep.dailybyte;
/*
This question is asked by Google. You are given two strings, s and t which only consist of lowercase letters. t is generated by shuffling the letters in s as well as potentially adding an additional random character. Return the letter that was randomly added to t if it exists, otherwise, return ’ ‘.
Note: You may assume that at most one additional character can be added to t.

Ex: Given the following strings...

s = "foobar", t = "barfoot", return 't'
s = "ide", t = "idea", return 'a'
s = "coding", t "ingcod", return ''
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        if(s.isEmpty())
            return t.charAt(0);

        int[] freq = new int[26];
        for(char c: s.toCharArray())
            freq[c-'a']++;

        for(char c: t.toCharArray())
            freq[c-'a']--;

        for(int i=0; i<freq.length;i++){
            if(freq[i]!=0)
                return (char)(i+'a');
        }
        return '\0';

    }
}