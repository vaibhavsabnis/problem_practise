package interview.prep.leetcode.july20;
/*
 *  Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
   Hide Hint #1  
The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
   Hide Hint #2  
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
   Hide Hint #3  
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
   Hide Hint #4  
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */

import java.util.ArrayList;
import java.util.List;

import vaibhav.utils.Execution;

public class UglyNumberII {
	
	public int _nthUglyNumber(int n) {//gives TLE for large numbers
		int i=1;
		int cnt = 0;
		while(true) {
			if(isUgly(i)) {
				cnt++;
			}
			if(cnt ==n) 
				break;
			i++;
		}
		return i;
	}
	public int nthUglyNumber(int n) {
		List<Integer> ans = new ArrayList<>();
		ans.add(1);
		
		int i=0,j=0,k=0;
		
		while(ans.size()<n) {
			int tempI=ans.get(i)*2;
			int tempJ=ans.get(j)*3;
			int tempK=ans.get(k)*5;
			
			int nextUgly = Math.min(tempI, Math.min(tempJ, tempK));
			ans.add(nextUgly);
			
			if(nextUgly==tempI) i++; 
			if(nextUgly==tempJ) j++;
			if(nextUgly==tempK) k++;
		}
		return ans.get(n-1);
	}
    
    public boolean isUgly(int num) {
        if(num <= 0)return false;
        if (num ==1 ) return true; 

        while(num%5==0) num/=5;
        while(num%3==0) num/=3;
        while(num%2==0) num/=2;
        
        return num==1;
        
    }
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(new UglyNumberII()._nthUglyNumber(1690));
		long endTime = System.currentTimeMillis();
		Execution.printExecutionTime(startTime, endTime);

	}

}
