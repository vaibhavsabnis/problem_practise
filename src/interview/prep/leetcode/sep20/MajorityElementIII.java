package interview.prep.leetcode.sep20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Majority Element II

Solution
Given an integer array of size n, find all elements that appear more than  n/3 times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class MajorityElementIII {
	public List<Integer> majorityElement(int[] nums) {
        Set<Integer> ans = new HashSet<>(); 
        
        if(nums == null || nums.length ==0){
            return new ArrayList<Integer>(); 
        }
        
        int bound = nums.length/3;         
        Map<Integer,Integer> freq = new HashMap<>(bound); // based on hint
        
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1); 
            
            // if(freq.size() > bound) // dont need to iterate any further
            //     return ans; 
            
            if(freq.get(nums[i]) > bound)
                // if(!ans.contains(nums[i]))
                    ans.add(nums[i]); 
        }
        
        return ans.parallelStream().collect(Collectors.toList()); 
    }
/*
[3,2,3]
[1,1,1,3,3,2,2,2]
[2,2]
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
