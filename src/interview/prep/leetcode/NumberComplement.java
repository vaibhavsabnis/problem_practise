package interview.prep.leetcode;
/*
 * Number Complement
Solution
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 

Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Note:

The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */

public class NumberComplement {

    public int findComplement(int num) {
        int totalBits = (int)Math.floor(Math.log(num)/Math.log(2)) +1; // log(num)/log(base) +1 --> gives you total bits in a number.  
        return Math.abs((int)(Math.pow(2,totalBits)-1) ^ num); // (2 pow totalBits) - 1 --> gives max value of number forthose bits. XOR this with incoming number to produce result.  
    }
    
	public static void main(String[] args) {
		System.out.println(new NumberComplement().findComplement(7));

	}

}
