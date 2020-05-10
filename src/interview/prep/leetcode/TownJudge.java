package interview.prep.leetcode;

import java.util.Arrays;

/*
 * Find the Town Judge
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N


4
[[1,2],[1,3],[2,1],[2,3],[1,4],[4,3],[4,1]]
2
[[1,2]]
3
[[1,3],[2,3]]
3
[[1,3],[2,3],[3,1]]
3
[[1,2],[2,3]]
4
[[1,3],[1,4],[2,3],[2,4],[4,3]]
1
[]
 */
public class TownJudge {

	public int findJudge(int N, int[][] trust) {
        
        if (trust.length <1)
            return N; 
        if (trust.length == 1)
            return trust[0][1];
       
        int[] judgeTrustCount = new int[N+1];
                
        for(int row=0;row<trust.length; row++){
            int person = trust[row][0];
            int trustsWho = trust[row][1];

            if(judgeTrustCount[person] > 0 ){//Someone else trusted this person but this person is present in trust array, so person can't be judge as this violates condition 1
                judgeTrustCount[person] = -1;    
                continue; //Ignore this trust vote
            }
            if(judgeTrustCount[trustsWho] !=-1){
                judgeTrustCount[trustsWho]++; 
            }
        }
        
        Arrays.stream(judgeTrustCount).forEach(System.out::print);
        
        int judge = -1; 
        
        for(int i=1; i<judgeTrustCount.length; i++){
            if(judgeTrustCount[i]>0){ //Someone trusts this person. 
                if (judge == -1){ //First judge
                    judge = i;
                }else{
                    return -1;
                }
            }
        }
        
        return judge; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
