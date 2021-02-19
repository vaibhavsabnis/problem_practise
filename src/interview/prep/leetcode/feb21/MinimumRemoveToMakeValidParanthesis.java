package interview.prep.leetcode.feb21;
/*
Minimum Remove to Make Valid Parentheses

Solution
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"


Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
   Hide Hint #1
Each prefix of a balanced parentheses has a number of open parentheses greater or equal than closed parentheses, similar idea with each suffix.
   Hide Hint #2
Check the array from left to right, remove characters that do not meet the property mentioned above, same idea in backward way.
 */
public class MinimumRemoveToMakeValidParanthesis {
    public String minRemoveToMakeValid(String s) {
        if(s.isEmpty())
            return "";
        char[] c = s.toCharArray();

        int open = 0;
        int close = 0;

        for(int i=0;i < c.length; i++){
            if(c[i] == '(' ) open++;
            if(c[i] == ')' ) close++;
            // System.out.println("Working with char : " +c[i] + ", open: " + open + ", close: " + close);
            if(open < close && c[i] == ')' )    {
                c[i]= '1';
                close--;
            }
        }
        // System.out.println("Post forward traversal character Array is: " + Arrays.toString(c));

        open = 0;
        close = 0;
        for(int i=c.length-1;i >=0; i--){
            if(c[i] == '(' ) open++;
            if(c[i] == ')' ) close++;
            if(close < open && c[i] == '(' )    {
                c[i]= '1';
                open--;
            }
        }
        return String.valueOf(c).replaceAll("1","");
    }
}
