package interview.prep.leetcode.july20;
/*
 * sland Perimeter

Solution
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:


 */
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					perimeter += getCellPerimeter(i, j, grid);
					grid[i][j] = -1;
				}
			}
		}
		return perimeter;
	}

	private int getCellPerimeter(int i, int j, int[][] grid) {
		int cellPerimeter = 0;
		boolean eastWater = false, westWater = false, northWater = false, southWater = false;

		if (i == 0)
			northWater = true;
		if (j == 0)
			eastWater = true;
		if (i == grid.length-1)
			southWater = true;
		if (j == grid[0].length-1)
			westWater = true;

		if (i != 0 && grid[i - 1][j] == 0 )
			northWater = true;
		if (i != (grid.length - 1)&& grid[i + 1][j] == 0 )
			southWater = true;
		if (j != 0 && grid[i][j - 1] == 0 )
			eastWater = true;
		if (j != (grid[0].length - 1) && grid[i][j + 1] == 0)
			westWater = true;

		if (northWater)
			cellPerimeter++;
		if (southWater)
			cellPerimeter++;
		if (eastWater)
			cellPerimeter++;
		if (westWater)
			cellPerimeter++;

		return cellPerimeter;
	}
}
