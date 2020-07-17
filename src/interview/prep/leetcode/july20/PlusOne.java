package interview.prep.leetcode.july20;

import java.util.concurrent.atomic.AtomicReference;

/*
 * Plus One

Solution
Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
        AtomicReference<StringBuffer> buff = new AtomicReference<>(new StringBuffer());
        for(int i:digits)
            buff.get().append(i);

//        long plusOne = Long.parseLong(buff.toString())+1;
        java.math.BigInteger plusOne = new java.math.BigInteger(buff.toString()); 
        plusOne = plusOne.add(java.math.BigInteger.ONE);
        
        String str = plusOne.toString();
        int[] ans = new int[str.length()];
        for(int i=0; i< str.length(); i++){
            ans[i] = Integer.parseInt(str.charAt(i)+"");
        }

        // System.out.println(Arrays.toString(ans));
        return ans;
    }
}
