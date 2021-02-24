package interview.prep.leetcode.facebook;

import java.util.Arrays;
/*
70. Climbing Stairs
Easy

5966

188

Add to List

Share
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] visited = new int[n+1];
        Arrays.fill(visited,-1);
        visited[0] = 0;
        visited[1] = 1;
        visited[2] = 2;
        climb(n, visited);
        return visited[n];
    }


    private int climb(int n, int[] visited ){
        if(n <=0)
            return 0;
        if(n ==1)
            return 1;
        if(n == 2)
            return 2;

        if(visited[n] != -1)
            return visited[n];

        visited[n] = climb(n-1, visited) + climb(n-2, visited);
        return visited[n];

    }
}
/*
5
10
25
37
45
 */
