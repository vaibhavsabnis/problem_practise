package interview.prep.leetcode.july20;
/*
 * Add Digits

Solution
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
	public int addDigits(int num) {
        if(num<10)
            return num;         
        int res = helper(num);
        System.out.println(res);
        return res;
    }
    
    private int helper(int num){
        if(num<10)
            return num; 
        
        char[] cNum = (num+"").toCharArray();
        int temp = 0; 
        for(char c: cNum)
        	temp += Character.getNumericValue(c);
        
        return helper(temp);
    }
}
