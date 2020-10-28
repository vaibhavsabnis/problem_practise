package interview.prep.leetcode.oct20;

import java.util.ArrayList;
import java.util.List;

/*
 * 228. Summary Ranges
Easy

783

590

Add to List

Share
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Example 3:

Input: nums = []
Output: []
Example 4:

Input: nums = [-1]
Output: ["-1"]
Example 5:

Input: nums = [0]
Output: ["0"]
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.

 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>(); 
        if(nums ==null || nums.length ==0)
            return res; 
        
        if(nums.length == 1){
            res.add(nums[0]+""); 
            return res; 
        }
        
        int st= nums[0]; 
        int en = st; 
        for(int i=1; i<nums.length;i++){
            // System.out.println("Evaluating : " + nums[i]); 
            if(Math.abs(Math.abs(nums[i]) - Math.abs(nums[i-1])) == 1){
                en = nums[i]; 
            }else{
                populateRange(res, st, en);
                st = nums[i]; en = st; 
            }
        }
        // System.out.println("Value of st: " + st +" , en:" + en); 
        populateRange(res,st,en); 
        return res; 
    }
    
    private void populateRange(List<String> res, int st, int en){
        // System.out.println("Populating st: " + st +" , en:" + en); 
        String str= ""; 
        
        if(st==en)
            str = st+""; 
        else
            str = st +"->" + en; 
        
        res.add(str); 
    }
}
/*
[0,1,2,4,5,7]
[0,2,3,4,6,8,9]
[]
[-1]
[-2,-1,0,1]
[0]
*/
