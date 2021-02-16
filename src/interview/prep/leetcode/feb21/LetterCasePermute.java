package interview.prep.leetcode.feb21;
/*
Letter Case Permutation
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.



Example 1:

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: S = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: S = "12345"
Output: ["12345"]
Example 4:

Input: S = "0"
Output: ["0"]


Constraints:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
 */
import java.util.*;

public class LetterCasePermute {

    Set<Character> dict = getCharacterDictionary();

    public List<String> letterCasePermutation(String S) {
        Set<String> ans = new HashSet<>();

        permute("",0, S, ans);
        return new ArrayList<>(ans);
    }

    public void permute(String currState, int st, String orig,Set<String> ans){
        if(st == orig.length()) {
            ans.add(currState);
            return;
        }
        char c  = orig.charAt(st);
        if(Character.isLetter(c)){
            permute(currState + Character.toLowerCase(c) ,st+1,orig, ans);
            permute(currState + Character.toUpperCase(c) ,st+1,orig, ans);
        }else {
            permute(currState+ c, st + 1, orig,ans);
        }
    }

    public static void main(String[] args) {
        LetterCasePermute lc = new LetterCasePermute();
        List<String> ans = lc.letterCasePermutation("L2tcnhpZKsxe");
        System.out.println(ans);
        System.out.println("Sizeof the ans " + ans.size());
    }

    public List<String> _letterCasePermutation(String S) {
        Set<String> ans = new HashSet<>();
        if (S == null)
            return new ArrayList<>(ans);
        boolean containsNum = false;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (dict.contains(c)) {

                StringBuffer sbuf = new StringBuffer();
                String pre_str = (i == 0) ? "" : S.substring(0, i);
                String post_str = (i == S.length() - 1) ? "" : S.substring(i+1);

                sbuf.append(pre_str);
                sbuf.append(flip(c));
                sbuf.append(post_str);

                ans.add(sbuf.toString());
            } else {
                containsNum = true;
            }
        }
        if (containsNum)
            ans.add(S);

        return new ArrayList<String>(ans);
    }

    private Set<Character> getCharacterDictionary(){
        Set<Character> dict = new HashSet<>();
        for(char c='a';c<='z';c++){
            dict.add(c);
        }
        for(char c='A';c<='Z';c++){
            dict.add(c);
        }
        return dict;
    }

    private Character flip(char c){
        if(Character.isUpperCase(c))
            return Character.toLowerCase(c);

        return Character.toUpperCase(c);
    }

}
