package interview.prep.leetcode.aug20;
/*
 *   Power of Four

Solution
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?

 */
public class PowerOfFour {
	public boolean _isPowerOfFour(int num) {
        if(num ==1)
            return true; 
        if (num<4)
            return false;
        
        while(num>=4){
            if(num%4 != 0)
                return false; 
            num = num/4;
        }
        return (num == 1) ? true:false; 
    }
    
    public boolean isPowerOfFour(int num){
        double ans = customLog(4,num);
        return (ans ==(int)ans);
    }
    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
}
