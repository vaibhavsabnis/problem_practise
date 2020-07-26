package interview.prep.leetcode.july20;
/*
 * Add Binary

Solution
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
 */
import java.math.BigInteger;

public class AddBinary {
	public String addBinary(String a, String b) {
		return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
	}
}
