package interview.prep.leetcode.aug20;
/*
 * Rotting Oranges

Solution
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 */
import java.util.HashSet;

public class RottenOranges {
	public int orangesRotting(int[][] grid) {
		HashSet<String> fresh = new HashSet<>();
		HashSet<String> rotten = new HashSet<>();
		
		for(int i=0; i< grid.length;i++) {
			for(int j=0; j<grid[i].length;j++) {
				if(grid[i][j] ==1)
					fresh.add(""+i+j);
				if(grid[i][j] ==2)
					rotten.add(""+i+j);
			}
		}
		
		int min = 0;
		int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
		while(fresh.size()>0) {
			HashSet<String> infected = new HashSet<>();
			
			for(String rot: rotten) {
				int i= Character.getNumericValue(rot.charAt(0));
				int j= Character.getNumericValue(rot.charAt(1));
				for(int[] direction: directions) {
					int nextI = i+ direction[0]; 
					int nextJ = j+ direction[1];
					String coordinate = ""+nextI+nextJ;
					if(fresh.contains(coordinate)) {
						fresh.remove(coordinate);
						infected.add(coordinate);
					}
				}				
			}
			if(infected.size() ==0) 
				return -1;
			
			rotten = infected;
			min++;
		}
		
		return min; 
	}
    
    public static void main(String[] args) {
    	int[][] grid = {{2,1,1}, 
    					{0,1,1},
    					{1,0,1}, 
    					};
    	RottenOranges ro = new RottenOranges(); 
    	ro.orangesRotting(grid);
    }
}
