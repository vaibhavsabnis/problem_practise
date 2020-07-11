package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given the array nums consisting of n positive integers. You computed the sum of all non-empty continous subarrays from the array and then sort them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 10^9 + 7.

 

Example 1:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13 
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13. 
Example 2:

Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
Example 3:

Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50
 */
public class RangeSumOfSubArray {
	public static void main(String ar[]) {
		RangeSumOfSubArray rs = new RangeSumOfSubArray();
		
		rs.rangeSum(new int[] {1,2,3,4}, 4, 1, 5);
	}
	public int rangeSum(int[] nums, int n, int left, int right) {
		
		int res =0;
		List<Integer> subArrSum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	int sum = nums[i];
        	subArrSum.add(sum);
			for (int j = i+1; j < nums.length; j++) {
				sum += nums[j];
				subArrSum.add(sum);
			}
			
		}
//        System.out.println("Sub-Array-Sum:" + subArrSum);
        Collections.sort(subArrSum);
//        System.out.println("Sub-Array-Sum:" + subArrSum);
        for(int i=left-1; i<=right-1; i++) {
        	res += subArrSum.get(i);
        }
//        System.out.println(res);
        int modulo = (int)Math.pow(10,9) + 7;
        
        return res%modulo; 
        
    }
}
