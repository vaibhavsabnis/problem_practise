package interview.prep.dailybyte;
/*
This question is asked by Facebook. Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

Ex: Given the following strings...

"abcba", return true
"foobof", return true (remove the first 'o', the second 'o', or 'b')
"abccab", return false
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s.isEmpty())
            return false;
        if(s.length() == 1)
            return true;

        int st=0,en=s.length()-1;
        while(st<en && st < s.length()){
            if(s.charAt(st) != s.charAt(en))
                return isPalindrome(removeChar(s,st)) || isPalindrome(removeChar(s,en));
            st++; en--;
        }
        return true;

    }
    private boolean isPalindrome(String s){
        if(s.isEmpty())
            return true;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s.toString());
    }

    private String removeChar(String str,Integer pos){
        StringBuilder sb = new StringBuilder();

        sb.append(str);
        sb.deleteCharAt(pos);
        return sb.toString();
    }
}
