package interview.prep.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 */

public class ValidParenthesis {
	
	public boolean _checkValidString(String s) {//Wrong Answer
        if (s==null)
            return false; 
        if (s.trim()== "")
            return true; 
        
        char[] c = s.toCharArray();
        int lCnt = 0, rCnt = 0, sCnt= 0;
        for(int i= 0; i<c.length; i++){
         if(c[i] == '(')   
             lCnt++; 
         else if (c[i]==')')
             rCnt++; 
         else if (c[i]=='*')
             sCnt++;
         else // Invalid char identified
             return false; 
        }
        
        int diff = Math.abs(lCnt-rCnt); 
        if(diff == 0 || diff <= sCnt)
            return true;
        
        return false; 
    }
	
	
	private boolean checkValidString(String s) {

        if (s==null)
            return false; 
        if (s.trim()== "")
            return true; 
        
        Set<Character> lookup = new HashSet<>();
        lookup.add('('); lookup.add(')'); lookup.add('*');

        int sCnt = 0, lCnt = 0;  
        
        char[] c = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i<c.length; i++) {
        	if(!lookup.contains(c[i])) 
        		return false;        	
        	
        	if(c[i]=='*') {
        		sCnt++;
        	}
        	else if (c[i] == ')') {
        		if(!stk.isEmpty() && stk.peek()== '(') {      			
        			stk.pop();
        			lCnt--;
        		}
        		else {
        			if(sCnt>0) {
        				sCnt--;
        				continue;
        			}
        			return false; // no corresponding open braces or * found
        		}
        	}
        	else if (c[i] == '('){
        		lCnt++;
        		stk.push(c[i]);
        	}	
        }
        
        if (stk.isEmpty())
        	return true;
        if((lCnt-sCnt) <= 0 )
        	return true;
        
        return false; 
    
	}
	
	private void myWrapper(String s) {
		System.out.println(checkValidString(s));
	}
	
	public static void main(String a[]) {
		new ValidParenthesis().myWrapper("()");//true		
		new ValidParenthesis().myWrapper("(*)");//true		
		new ValidParenthesis().myWrapper("(*))");//true		
		new ValidParenthesis().myWrapper("**");//true
		new ValidParenthesis().myWrapper(")(");//false
		new ValidParenthesis().myWrapper("((**");//true
		new ValidParenthesis().myWrapper("(*()");//true
		new ValidParenthesis().myWrapper("(");//false
		
		new ValidParenthesis().myWrapper("(())((())()()(*)(*()(())())())()()((()())((()))(*"); //false
		new ValidParenthesis().myWrapper("**((*"); //false ????
		
		
		
		
		
		
	}
}
