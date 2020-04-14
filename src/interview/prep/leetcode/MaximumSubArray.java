package interview.prep.leetcode;
/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution 
using the divide and conquer approach, which is more subtle.
 */

public class MaximumSubArray {
	
	public int maxSubArray(int[] nums) {
		
		int size = nums.length; 
        int bestMax = Integer.MIN_VALUE, currentMax = 0;
//        int st=0,en=0;
  
        for (int i = 0; i < size; i++) 
        { 
            currentMax = currentMax + nums[i]; 
            
            if (bestMax < currentMax) {
                bestMax = currentMax;
//                en=i;
            }
            if (currentMax < 0) { 
                currentMax = 0;
//                st=i;
            }
        } 
//        System.out.println(st +" : "+en +" --> bestsum=" +bestMax);
        return bestMax; 
	}
	
	public static void main (String args[]) {
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new MaximumSubArray().maxSubArray(nums));
		
//		System.out.println(System.nanoTime());
	}
}
