package interview.prep.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Q08: 

 Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-2^31, 2^31-1]. If the numerical value is out of the range of representable values, INT_MAX (2^31-1) or INT_MIN (-2^31) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (-2^31) is returned.
 */

public class Q8StringToInteger {

	public int myAtoi(String str) {

		if (str == null)
			return 0;
		
		Set<Integer> lookupSet = createDigitsLookupSet(10);

		String s = str.trim();
		if(s.length() <1)
			return 0;

//		char[] c = s.toCharArray();
		
		int start=0,end = 0;
		
		for(int i=0; i<s.length();i++) {
			if (str.charAt(i) == '-') {
				start ++;
				continue; //first -ve sign is fine
			}
			
			if(!lookupSet.contains(str.charAt(i))) {
				end = i-1;
				break;
			}
		}
		
		if(start<end) {//this is valid number to be extracted from the string
			String sInt = s.substring(start, end);
			return Integer.parseInt(sInt);
		}
		
		return 0;//no valid int found
	}
	
    private Set<Integer> createDigitsLookupSet(int range){
    	Set<Integer> s = new HashSet<>();
    	for(int i=0; i<range;i++) {
    		s.add(i);
    	}
    	return s;
    }
    
    public static void main(String args[]) {
    	
    	System.out.println(new Q8StringToInteger().myAtoi("42")); 
    	System.out.println(new Q8StringToInteger().myAtoi("   -42"));
    	System.out.println(new Q8StringToInteger().myAtoi("4193 with words"));
    	System.out.println(new Q8StringToInteger().myAtoi("words and 987"));
    	System.out.println(new Q8StringToInteger().myAtoi("-91283472332"));
    }
}
