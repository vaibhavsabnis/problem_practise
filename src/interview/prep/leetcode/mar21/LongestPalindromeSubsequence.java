package interview.prep.leetcode.mar21;
/*
647. Palindromic Substrings
Medium

3920

134

Add to List

Share
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.
 */
public class LongestPalindromeSubsequence {

    //TC: O(N^2), SC=O(1) - where N = length of string s.
    public int countSubstrings(String s) {
        if(s ==null ||s.isEmpty())
            return 0;
        if(s.length() == 1)
            return 1;

        int ans = 0;
        for(int i=0; i<s.length(); i++){
            ans += palindromeAroundCenter(s, i, i+1);
            ans += palindromeAroundCenter(s, i,i);
        }
        return ans;
    }

    private int palindromeAroundCenter(String s, int left, int right){
        // System.out.println("Incoming string: " + s +" left: " + left + " right : "+ right);
        int ans = 0; //self is a string
        while(left>=0 && right<s.length()){
            // System.out.println("Working on left: " + left + " right : "+ right);
            if(s.charAt(left) != s.charAt(right))
                return ans;

            left--; right++; ans++;
        }

        return ans;
    }

    //TC: O(N^3), SC=O(1) - where N = length of string s.
    public int _countSubstrings(String s) {
        if(s ==null ||s.isEmpty())
            return 0;
        if(s.length() == 1)
            return 1;

        int ans = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++ ){
                String sub = s.substring(i, j+1);
                boolean isPalin = isPalindrome(s.substring(i,j+1));
                // System.out.println("The string : "+ sub + " is a palindrome " + isPalin);

                if(isPalin){
                    ans++;
                }
            }
        }
        return ans;
    }
    private boolean isPalindrome(String s){
        if(s ==null ||s.isEmpty())
            return false;
        if(s.length() == 1)
            return true;

        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        // System.out.println("The string : "+ s + " is a palindrome " + true);
        return true;
    }
}
/*
"abc"
"aaa"
"a"
""
*/