package interview.prep.leetcode;

/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

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
 */
public class BackspaceEditor {
	
    public boolean backspaceCompare(String S, String T) {
    	
        return fetchBackspaceString(S).equals(fetchBackspaceString(T));
    }
    private String fetchBackspaceString(String str) {
    	
    	char[] c = str.toCharArray();
    	int j=-1;//last non-# char 
    	for(int i=0; i<c.length;i++) {    		
    		if(c[i] == '#') {    			
    			if(j>-1) {
    				c[i] = c[j] = Character.MIN_VALUE;
    				j--;
    			}
    		}else {
    			j=i;
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(char x:c) {
    		if (x !=Character.MIN_VALUE && x!='#') {
    			sb.append(x);
    		}
    	}
    	System.out.println(sb.toString());
    	return sb.toString();
    }
    
    public static void main(String a[]) {
    	new BackspaceEditor().backspaceCompare("bxj##tw","bxo#j##tw" );
    	new BackspaceEditor().backspaceCompare("ab#c","ad#c" );
    	new BackspaceEditor().backspaceCompare("ab##","c#d#" );
    	new BackspaceEditor().backspaceCompare("a##c","#a#c" );
    	new BackspaceEditor().backspaceCompare("a#c","b" );
    }

}
