package interview.prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/*
 * 
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

[1,3,1,-1,3]

 */
public class NumberCounter {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (numMap.get(nums[i]) != null) {
				numMap.put(nums[i], numMap.get(nums[i]) + 1);
			} else {
				numMap.put(nums[i], 1);
			}
		}

		Set<Integer> keys = numMap.keySet();
		
		for(Integer key:keys) {
			if(numMap.get(key) ==1)
				return key;
			else {
				continue;
			}
		}		
		return -1;
	}    
	
	
	public int singleNumberNoExtraSpace(int[] nums) {

		Arrays.parallelSort(nums);
		
		if (nums.length == 1) {
			return nums[0];
		}		
		
		if(nums[0] != nums[1]) {
			return nums[0];
		}
		int numberToReturn=0;
		
		for(int i =1;i<nums.length-1;i++) {	
				int prior = nums[i-1];
				int curr = nums[i];
				int next = nums[i+1];
				
				if(curr!=prior && curr==next) {
					numberToReturn = prior;
				}
				if(curr==prior && curr!=next) {
					numberToReturn= next;
				}
				if(curr!=prior && curr!=next) {
					return curr;
				}
		}
		return numberToReturn;
	
	}
}
