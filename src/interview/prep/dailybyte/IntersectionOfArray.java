package interview.prep.dailybyte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
349. Intersection of Two Arrays
Easy

1308

1506

Add to List

Share
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

===
Given two integer arrays, return their intersection.
Note: the intersection is the set of elements that are common to both arrays.

Ex: Given the following arrays...

nums1 = [2, 4, 4, 2], nums2 = [2, 4], return [2, 4]
nums1 = [1, 2, 3, 3], nums2 = [3, 3], return [3]
nums1 = [2, 4, 6, 8], nums2 = [1, 3, 5, 7], return []
 */
public class IntersectionOfArray {
    //TC: O(N), SC: O(N) - N is max(nums1.length || nums2.length)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        if(nums1 ==null || nums2 ==null || nums1.length ==0 || nums2.length == 0)
            return new int[] {};

        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums1){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }

        for(int i: nums2){
            if(freq.get(i) != null && !res.contains(i))
                res.add(i);
        }

        int[] answer = new int[res.size()];
        int id=0;
        for(int i: res){
            answer[id++] = i;
        }

        return answer;
    }
}
