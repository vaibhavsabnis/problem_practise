package interview.prep.leetcode.google;

import java.util.Arrays;

/*
 * 4. Median of Two Sorted Arrays
Hard

8271

1287

Add to List

Share
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfArray {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        if(nums1 ==null && nums2== null)
	            return 0; 
	        
	        int[] merged = mergeArrays(nums1,nums2);
	        // System.out.println("MergedArray: " + Arrays.toString(merged)); 
	        
	        double median = 0; 
	        if(merged.length % 2 ==0){
	            // System.out.println("merged.length/2 : " + merged.length/2); 
	            // System.out.println(" Vals: " + merged[merged.length/2] + " : next: " + merged[merged.length/2 -1]); 
	            
	            median = ((double)merged[merged.length/2] + merged[(merged.length/2) - 1]) / 2; 
	        }else{
	            median = merged[merged.length/2]; 
	        }
	        return median; 
	        
	    }
	    private int[] mergeArrays(int[] a, int[] b){
	        int aLen = (a==null)?0:a.length; 
	        int bLen = (b==null)?0:b.length;         
	        
	        int[] res = new int[aLen+bLen]; 
	        System.arraycopy(a,0,res,0,aLen); 
	        System.arraycopy(b,0,res,aLen,bLen); 
	        
	        Arrays.sort(res);    
	        
	        return res; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
