package interview.prep.leetcode.june20;
/*
 * Power of Two

Solution
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
 */
public class PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
    //basic checks
		if (n ==2 || n ==1)
            return true; 
        if (n < 1)
            return false;
        
        
        while(n>=2){            
            if(n%2 == 1)//if an odd number
                return false;
            
            n = n >> 1; // divide by 2 --bitwise shift to right.
        }
        
        return true; 
    }
	
	public static void main(String[] args) {
		System.out.println(new PowerOfTwo().isPowerOfTwo(257));

	}

}
