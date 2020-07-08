package interview.prep.leetcode.july20;

import java.util.Arrays;

/*
 * 1029. Two City Scheduling
Easy

1304

167

Add to List

Share
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TwoCityScheduling {
	 public int twoCitySchedCost(int[][] costs) {
	        int aCnt = 0;
	        int bCnt = 0; 
	        int N = costs.length; 
	        int ans = 0;
	        
	        Arrays.sort(costs,(a,b) -> Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1])); 
	        
	        for(int i=0; i<N; i++){
	            if(costs[i][0]< costs[i][1]){
	                if(aCnt!=N/2){
	                    aCnt++; 
	                    ans +=costs[i][0];
	                }
	                else{
	                    bCnt++;
	                    ans +=costs[i][1];
	                }                
	            }else{
	                if(bCnt !=N/2){
	                    bCnt++;
	                    ans +=costs[i][1];
	                }else{
	                    aCnt++; 
	                    ans +=costs[i][0];
	                }
	            }
	        }
	        return ans; 
	    }
}
