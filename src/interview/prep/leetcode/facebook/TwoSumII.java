package interview.prep.leetcode.facebook;

import java.util.*;

/*
167. Two Sum II - Input array is sorted
Easy

2381

690

Add to List

Share
Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]


Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in increasing order.
-1000 <= target <= 1000
 */
public class TwoSumII {
    //TC: O(N log(N)) SC: O(N) for the hashset
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers==null || numbers.length < 2)
            return res;

        Set<Integer> set = new HashSet<>();
        for(int i:numbers){
            set.add(i);
        }
        for(int i=0; i<numbers.length; i++){
            int newTarget = target-numbers[i];
            if(!set.contains(newTarget))
                continue;

            int found = binarySearch(numbers,newTarget , i+1);

            if(found !=-1){
                res[0]= i+1;
                res[1] = found+1;
                return res;
            }
        }
        return res;
    }

    //TC: O(logN); N =left -> nums.length-1
    private int binarySearch(int[] num,int target, int left){

        int right = num.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(num[mid] == target)
                return mid;
            if(num[mid]> target)
                right = mid-1;
            if(num[mid] < target)
                left = mid+1;
        }

        return -1;
    }

    public int[] _twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers==null || numbers.length < 2)
            return res;

        Map<Integer,Integer> location = new HashMap<>();

        for(int i=0; i<numbers.length; i++){
            int first = numbers[i];
            int diff = target-first;
            if(location.get(diff)!=null){
                int secondPos = location.get(diff);
                if(secondPos == i) continue; // cant use same position twice
                res[0] = i+1;
                res[1] = secondPos;
                return res;
            }
            location.put(first,i+1);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums ={2,3,4} ;
        int[] nums = {3,3};
        int target = 6;
        TwoSumII _2Sum = new TwoSumII();
        System.out.println(Arrays.toString(_2Sum.twoSum(nums, target)));
    }
}
