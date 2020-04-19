package interview.prep.leetcode;
/*
 * Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class Q530NumberIslands {

	public int numIslands(char[][] grid) {
        if(grid.length == 0) {
        	return 0;
        }
        int islands = 0;
        for(int i=0; i<grid.length;i++) {
        	for(int j =0; j<grid[0].length;j++) {
        		if(grid[i][j]== '1') {
        			islands++;
        			sinkContiguousIslands(grid, i, j);
        		}
        	}
        }
        return islands;
    }
	private void sinkContiguousIslands(char[][] grid, int i, int j) {
		if(grid.length==0 || i<0 || i>=grid.length ||j<0 || j>=grid[i].length|| grid[i][j] == '0') {
			return;
		}
		grid[i][j] ='0';
		sinkContiguousIslands(grid, i-1, j);
		sinkContiguousIslands(grid, i+1, j);
		sinkContiguousIslands(grid, i, j-1);
		sinkContiguousIslands(grid, i, j+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
