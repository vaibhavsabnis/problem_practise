package interview.prep.leetcode.june20;

/*
 * Single Number II

Solution
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
import java.util.*;
public class SingleNumberII {
	
	public int _singleNumber(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1); 
        }
        Set<Integer> keys = freq.keySet(); 
        Iterator<Integer> iter = keys.iterator(); 
        int n = Integer.MIN_VALUE; 
        while(iter.hasNext()){
            n = (int)iter.next(); 
            if (freq.get(n)!= 3)
                break;  
        }
        return n; 
    }
    
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i,freq.getOrDefault(i,0)+1); 
        }
        Set<Integer> keys = freq.keySet(); 
        Iterator<Integer> iter = keys.iterator(); 
        int n = Integer.MIN_VALUE; 
        while(iter.hasNext()){
            n = (int)iter.next(); 
            if (freq.get(n)!= 3)
                break;  
        }
        return n; 
    }

	public static void main(String[] args) {

		SingleNumberII sn = new SingleNumberII(); 
		System.out.println(sn.singleNumber(new int[]{2,2,3,2}));
		System.out.println(sn.singleNumber(new int[]{0,1,0,1,0,1,99}));
	}

}
