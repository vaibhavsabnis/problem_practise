package interview.prep.leetcode;
/*
 * Bitwise AND of Numbers Range
Solution
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 */


public class BitwiseANDOfRange {

	public int rangeBitwiseAnd(int m, int n) {

		while (m < n) {
			n -= (n & -n); // way to identify 2 compliment and flip LSB (Least Significant Bit)
		}
		return n;

		/*
		 * // Time limit exceeded issue for large ranges int res = m; for(int
		 * i=m+1;i<=n;i++){ res = res&i; } return res;
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
