package interview.prep.leetcode.aug20;
/*
 * Sort Array By Parity

Solution
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

 */
public class ArrayByParity {
	 public int[] sortArrayByParity(int[] A) {
	        if(A ==null || A.length ==0)
	            return A; 
	        
	        int[] ans = new int[A.length];
	        int left = 0; 
	        int right = A.length-1; 
	        
	        for(int i=0; i<A.length; i++){
	            if(A[i]%2==0)
	                ans[left++] = A[i];
	            else 
	                ans[right--] = A[i]; 
	        }
	        return ans;
	    }
}
