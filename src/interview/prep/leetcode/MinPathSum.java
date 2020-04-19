package interview.prep.leetcode;
/*
 * Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1->3->1->1->1 minimizes the sum.
 */

public class MinPathSum {
	
	public int minPathSum(int[][] grid) {
		if(grid.length==0)
			return 0;
		int[][] dp = new int[grid.length][grid[0].length];
		
		for(int rowi=0; rowi<dp.length;rowi++) {
			for(int col=0; col<dp[0].length; col++) {
				dp[rowi][col] = grid[rowi][col];
				if(rowi>0 && col>0) {
					dp[rowi][col] += Math.min(dp[rowi-1][col], dp[rowi][col-1]);
				}else if(rowi>0) {
					dp[rowi][col] += dp[rowi-1][col]; 
				}else if(col>0) {
					dp[rowi][col] += dp[rowi][col-1];
				}				
			}
		}
        
		return dp[dp.length-1][dp[0].length -1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
