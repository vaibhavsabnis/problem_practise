package interview.prep.leetcode;
/*
 * Single Element in a Sorted Array
You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once. Find this single element that appears only once.

 

Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10
 

Note: Your solution should run in O(log n) time and O(1) space.
 */

public class SingleNonDuplicate {

	public int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		
		int left = 0;
		int right = nums.length-1;
				
		while(left<=right) {
			int mid = left + (right-left)/2; 
			if(mid==0 || mid == nums.length-1) {
				return nums[mid];
			}
			
			if(nums[mid] != nums[mid-1] && nums[mid] !=nums[mid+1]) {//mid is our number
				return nums[mid];				
			}
			if(mid ==left) {
				return nums[right];
			}
			if (mid ==right) {
				return nums[left];
			}
			if(mid%2 ==0) {//mid is an even number. 
				if(nums[mid] == nums[mid+1] ) {//search space to right as all are pairs to the left 
					left = mid;
				}else {//search space to left
					right = mid; 
				}				
			}else {
				if(nums[mid]==nums[mid-1]) {//search space to the right as pair ends on odd number (0 index in array)
					left= mid;
				}else {
					right = mid; 
				}				
			}
		}
		return -1;
	}
	private void myWrapper(int[] a) {
		System.out.println(singleNonDuplicate(a));
	}
	
	public static void main(String[] args) {
		
		new SingleNonDuplicate().myWrapper(new int[]{1,1,2,3,3,4,4,8,8});
		new SingleNonDuplicate().myWrapper(new int[]{3,3,7,7,10,11,11});
		new SingleNonDuplicate().myWrapper(new int[]{1,1,2,2,3,4,4,8,8});
		new SingleNonDuplicate().myWrapper(new int[]{1,1,2,2,3,3,4,8,8});
		new SingleNonDuplicate().myWrapper(new int[]{1,1,2});
		
	}

}
