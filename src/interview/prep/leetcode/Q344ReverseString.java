package interview.prep.leetcode;

import java.util.Arrays;

public class Q344ReverseString {
	public void reverseString(char[] s) {
		if (s.length ==0 || s.length ==1)
			return;
		
        for(int i=0,j=s.length-1;i<s.length;i++,j--){
        	
        	if(i>=j)
        		break;
        	
            char temp = s[i];
            s[i]=s[j];
            s[j]= temp;
        }
//        System.out.println(Arrays.toString(s));
    }

	public static void main(String args[]) {
		String s = "vaibhavs";
		new Q344ReverseString().reverseString(s.toCharArray());
	}
}
