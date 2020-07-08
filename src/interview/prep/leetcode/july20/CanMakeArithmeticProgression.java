package interview.prep.leetcode.july20;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 1502. Can Make Arithmetic Progression From Sequence
Easy

64

4

Add to List

Share
Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.

 

Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Example 2:

Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
 

Constraints:

2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
 */
public class CanMakeArithmeticProgression {
	public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length <=2)
            return true; 
        
        Queue<Integer> pQ = new PriorityQueue<>(); 
        for(int i: arr){
            pQ.offer(i); 
        }
        
        int num1 = pQ.poll(); 
        int num2 = pQ.poll(); 
        int diff = Math.abs(num1-num2);
        
        while(!pQ.isEmpty()){
            num1 = pQ.poll(); 
            int tempDiff = Math.abs(num1-num2);  
            if(tempDiff != diff)
                return false; 
            num2=num1; 
        }
        return true; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
