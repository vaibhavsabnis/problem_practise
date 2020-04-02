package interview.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1^2 + 9^2 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class HappyNumber {

    public boolean isHappy(int n) {   
    	if (n<=0) return false;
    	if (n==1) return true; 
    	
    	System.out.println(n );
    	Map<Integer, Integer> ctrlMap = new HashMap<Integer, Integer>();
    	ctrlMap.put(n, 0);//first time
    	return findSqSum(n,ctrlMap)==1?true:false;
    }
    
    public int findSqSum(int num, Map<Integer, Integer> hmSumCalc) {//to help memoization 
//    	System.out.println("Incoming number on the stack frame: "+num);
    	
    	if(hmSumCalc.get(num)!=null && hmSumCalc.get(num)==0) {    		
    		hmSumCalc.put(num, hmSumCalc.get(num)+1);//Increment so next time recursion will terminate 
    	}else {
    		System.out.println("Cycle graph identified at : " + num);
    		return 0;//already calculated, a cycle identified
    	}

    	char[] nums = String.valueOf(num).toCharArray();
    	
    	if(nums.length == 1 && (num ==1 ||num ==0)) {
    		return num==1?1:0;
    	}else {
    		int sqSum =0;
    		
    		for(char c:nums) { //O(n)
    			System.out.print(c+"^2 + ");
    			int i = Integer.parseInt(String.valueOf(c));
    			sqSum += i*i;
    		}
    		System.out.println("="+sqSum);  
    		
    		if(hmSumCalc.get(sqSum) == null)  
    			hmSumCalc.put(sqSum,0);//first time
    		
    		return findSqSum(sqSum,hmSumCalc);
    	}
    }
    
    public static void main(String a[]) {
    	System.out.println(new HappyNumber().isHappy(19));
    }
    
    public boolean _isHappy(int n) {
        n = (int) Math.abs(n);
        Set<Integer> exist = new HashSet<>();
        while (n != 1) {
            if (!exist.add(n)) {
                return false;
            }
            
            int tmp = 0;
            while (n > 0) {
                tmp += Math.pow((n % 10), 2);
                n /= 10;
            }
            n = tmp;
        }
        return true;
    }
}
