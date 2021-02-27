package interview.prep.dailybyte;

/*
This question is asked by Facebook. Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

Ex: Given the following strings...

"level", return true
"algorithm", return false
"A man, a plan, a canal: Panama.", return true
 */
public class ValidPalindrome {
    public boolean isPalindrome(String S){
        if(S.isEmpty())
            return false;
        StringBuilder sb = new StringBuilder();

        for(char c: S.toCharArray()){
            int ch = (int)c;
            if( (ch >=(int)'A' && ch <= (int)'Z') ||
                (ch >=(int)'a' && ch <= (int)'z') ||
                (ch >=(int)'0' && ch <= (int)'9')
              )
                sb.append(Character.toLowerCase(c));
        }

        System.out.println("After removing not required characters: " + sb.toString());

        if(sb.toString().length() ==1 )
            return true;

        char[] ch = sb.toString().toCharArray();
        int st = 0;
        int en = ch.length-1;
        while(st <= en){
            if(ch[st] != ch[en] )
                return false;
            st++;
            en--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String[] s = {"0p","level","algorithm","A man, a plan, a canal: Panama."};
        for(String S: s)
            System.out.println("is--> " + S +" <-- a valid palindrome: ? " + v.isPalindrome(S));
    }
}
