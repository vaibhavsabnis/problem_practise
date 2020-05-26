package interview.prep.hired.com;
/*
 * Given a n x n matrix. O indicates pass, 1 indicates block. Find a path from (0,0) to (n,n). If a path exists, return true - else false. 
 * where, n > 2
 */
public class PathThroughMaze {
	public boolean pathPresent(long[][] maze, int n) {
		// Type your solution here
		
		if(maze[0][0] ==1 || maze[n-1][n-1] ==1) //either entry or exit is blocked. 
			return false; 

		return isPathPresent(maze, 0, 0, n - 1);

	}
	private boolean reachedLeaf= false; 
	private boolean isPathPresent(long[][] maze, int row, int col, long boundary) {
		if(row == boundary && col == boundary ) {//reached the last cell
			if (maze[row][col]==0) {
				reachedLeaf = true; 
				return true; 
			}
			else 
				return false; 
		}
		
		if(maze[row][col] ==1) {//This cell blocks movement
			return false; 
		}else {
			boolean pathPresent = true;
			boolean colPath = false; 
			boolean rowPath = false; 
			//check if we can move right - if so, move right
			if (col<boundary &&!reachedLeaf) {
				colPath = isPathPresent(maze, row,col+1,boundary);
			}
			//check if we can move bottom - if so, move bottom 
			if(row<boundary&&!reachedLeaf) {
				rowPath =  isPathPresent(maze,row+1,col,boundary);
			}
			return pathPresent && (colPath||rowPath); 
		}
	}

	public static void main(String[] args) {
		long[][] maze = {
				{0,1,1}, 
				{0,0,1},
				{1,0,0}
				}; 
		long[][] maze1= {
				{0,1},
				{0,0}
				};
		PathThroughMaze myMaze = new PathThroughMaze(); 

		System.out.println(myMaze.pathPresent(maze, 3));
		//System.out.println(myMaze.pathPresent(maze1, 2));

	}

	/*
	private static boolean _isPathPresent(long[][] maze, int row, int col, long bound) {
		if (row == (bound) && col == (bound) && (maze[row][col] == 0))
			return true;
		if (maze[row][col] == 1) { // cant pass through this cell
			return false;
		} else { // can passthrough this cell

			if (row == bound)
				row += 1;
			if (col == bound)
				col += 1;
			boolean res = true;
			// find path to the right//find path through the bottom
			res = isPathPresent(maze, row, col + 1, bound) && isPathPresent(maze, row + 1, col, bound);
			return res;
		}
	}
	*/
	
}
