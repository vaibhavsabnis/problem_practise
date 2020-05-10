package interview.prep.leetcode;
/*
 * Valid Perfect Square
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
        if (num < 1)
            return false; 
        if (num == 1)
            return true; 
        
        int left = 1; 
        int right = (num/2)+1;
        
        while (left<=right){
            long mid = left + (int) Math.floor((right-left)/2); 
            
            long res = mid*mid;
            
            //System.out.println("result: "+ res+ " for Left: "+ left + ", Mid: "+ mid + ", Right: "+right );
            if (res < 1){//Integer overflow occured, number wraps itself
                right= (int) mid-1;
                continue; 
            }
            
            if (res == num){
                return true;
            }else if(res>num){
                right = (int)mid-1;
            }else if(res<num){
                left = (int)mid+1; 
            }
        }
        return false;  
        
        /*        
        for(int i=1;i<=num/2;i++){
            int res = i*i;
            if(res == num)
                return true; 
            else if(res>num)
                return false; 
            else
                continue; 
        }
        return false;        
        */
    }
	
	public static void main(String args[]) {
//		new ValidPerfectSquare().isPerfectSquare(16);
//		new ValidPerfectSquare().isPerfectSquare(14);
//		new ValidPerfectSquare().isPerfectSquare(100000);
		new ValidPerfectSquare().isPerfectSquare(2147395600);
		
		System.out.println(Math.sqrt(2147395600));
	}

}
