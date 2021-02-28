package interview.prep.leetcode;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s.isEmpty())
            return false;
        if(s.length() == 1)
            return true;

        int st=0,en=s.length()-1;
        while(st<=en && st < s.length()){
            if(s.charAt(st) != s.charAt(en))
                return isPalindrome(removeChar(s,st)) || isPalindrome(removeChar(s,en));
            st++; en--;
        }
        return true;

    }
    private boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        StringBuilder rev = sb.reverse();
        boolean ret = rev.toString().equals(s.toString());
        return ret;
    }

    private String removeChar(String str,Integer pos){
        StringBuilder sb = new StringBuilder();

        sb.append(str);
        sb.deleteCharAt(pos);
        return sb.toString();
    }



    public boolean _validPalindrome(String s) {
        if(s.isEmpty())
            return false;
        if(s.length() == 1)
            return true;

        return isValid(s.toCharArray(), 1);
    }

    private boolean _isValid(char[] c, int allowedFaults){
        int st = 0;
        int en = c.length-1;
        while(en>=st){
            if(c[st] == c[en]){
                st++;
                en--;
                continue;
            }
            else{
                if(allowedFaults > 0){
                    allowedFaults--;
                    st++;
                    en--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[] c, int allowedFaults){
        int st = 0;
        int en = c.length-1;
        while(en>=st){
            if(c[st] == c[en]){
                st++;
                en--;
                continue;
            }
            else{
                if(allowedFaults > 0){
                    allowedFaults--;
                    if(c[st+1] == c[en])
                        st++;
                    else
                        en--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        ValidPalindromeII vp = new ValidPalindromeII();
        System.out.println(vp.validPalindrome("abca"));
    }
}
/*
"aba"
"abca"
"abbca"
"abbxca"
"deee"
"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
"lcuppucul"
*/