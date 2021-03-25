package interview.prep.dailybyte;

import java.util.Stack;
/*
844. Backspace String Compare
Easy

2350

112

Add to List

Share
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

==
This question is asked by Amazon. Given two strings s and t, which represents a sequence of keystrokes, where # denotes a backspace, return whether or not the sequences produce the same result.

Ex: Given the following strings...

s = "ABC#", t = "CD##AB", return true
s = "como#pur#ter", t = "computer", return true
s = "cof#dim#ng", t = "code", return false
 */
public class CompareKeyStroke_BackspaceKeyCompare {
    //TC: O(N), SC: O(N) where N = max(s.length, T.length)
    public boolean backspaceCompare(String S, String T) {

        Stack<Character> sStk= process(S);
        Stack<Character> tStk= process(T);

        if(sStk.size()!= tStk.size())
            return false;

        while(!sStk.isEmpty()){
            char sChar = sStk.pop();
            char tChar = tStk.pop();

            if(sChar != tChar)
                return false;
        }

        return true;

    }

    private Stack<Character> process(String str){
        Stack<Character> stk = new Stack<>();
        for(char c: str.toCharArray()){
            if(c == '#'){
                if(!stk.isEmpty()) {
                    stk.pop();
                }
            }else{
                stk.push(c);
            }
        }

        return stk;
    }
}
/*
"ab#c"
"ad#c"
"ab##"
"c#d#"
"a##c"
"a#c#"
"a#c"
"b"
*/
