package interview.prep.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s ==null)
			return false; 
		if(s.length()==1)
			return true;
		
		s = s.toLowerCase();
		
        int st = 0;
        int en = s.length()-1;

        Set<Character> set= new HashSet<>();
               
        for(char temp='a'; temp<='z';temp++){
            set.add(temp);
        }
        for(char i='0'; i<='9'; i++){
            set.add(i);
        }
        
        char[] c = s.toCharArray();
        
        while (st<=en){
            char stChar = c[st];
            char enChar = c[en];
            if(!set.contains(stChar)) {st++; continue;} //invalid char
            if(!set.contains(enChar)) {en--; continue;} //invalid char
            if(stChar!=enChar)
            	return false;
            
            st++; en--;
        }
        return true;
    }
	public static void main(String[] args) {
//		System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(new ValidPalindrome().isPalindrome("0P"));

	}

}
