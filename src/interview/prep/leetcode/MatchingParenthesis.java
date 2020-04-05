package interview.prep.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Q:20 - Leetcode
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class MatchingParenthesis {

	 public boolean isValid(String s) {     
		 
		 if (s == null)
			 return false;
		 if (s.length()%2 !=0) 
			 return false;
		 
		 Stack<Character> stk = new Stack<>();
		 Map<Character,Character> closing = new HashMap<>();
		 
		 closing.put('{','}');
		 closing.put('[',']');
		 closing.put('(',')');
		 
		 for(int i=0;i<s.length();i++) {
			 char c = s.charAt(i);
			 
			 if(c == '{' || c == '[' || c == '(') {
				 stk.push(c);				 
			 }
			 
			 if(c == '}' || c == ']' || c == ')') {
				 if(stk.isEmpty())
					 return false;
				 if (closing.get((char) stk.pop()) != c)
					 return false;
			 }
		 }
		 if(stk.isEmpty())
			 return true;
		 else 
			 return false;
	}
	 
	 public static void main(String args[]) {
	    	String s = "";
	    	s = "()";
	    	s = "{[]}";
	    	s = "([)]";
	    	s = "()[]{}";
	    	s = "((";
	    	s = "){";
	    	
	    	
	    	System.out.println(new MatchingParenthesis().isValid(s));
	    }
	 
}
