package interview.prep.leetcode.mar21;

import java.util.HashSet;
import java.util.Set;
/*
Missing Number

Solution
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:

Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.


Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 */
public class MissingNumber {
    //SC:O(N) TC: O(N)
    public int _missingNumber(int[] nums) {
        int n=nums.length;
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums){
            numSet.add(num);
        }

        for(int i=0; i<=n; i++){
            if(!numSet.contains(i))
                return i;
        }
        return -1;
    }

    //SC:O(1) TC: O(N)
    public int __missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    //SC:O(1) TC: O(N)
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
/*
[3,0,1]
[9,6,4,2,3,5,7,0,1]
[0,1]
[0]
[1]
*/
