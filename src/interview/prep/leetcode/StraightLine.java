package interview.prep.leetcode;

/*
 * Check If It Is a Straight Line
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 */
public class StraightLine {
	

    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length <=1 )
            return false; 
        if(coordinates.length == 2)
            return true; 
        
        double lineSlope = findSlope(coordinates[0][0], coordinates[0][1],coordinates[1][0], coordinates[1][1]); 
        
       // System.out.println("LineSlope: " + lineSlope);
        for(int row=1; row<coordinates.length-1; row++){
            // for (int col=0; col<coordinates[0].length; col++){                
            if (
                findSlope(coordinates[row][0], coordinates[row][1], coordinates[row+1][0], coordinates[row+1][1]) != lineSlope)
                return false; 
            // }
        }
        return true; 
    }
    
    private double findSlope(int x1, int y1, int x2, int y2){
       /* x1 = Math.abs(x1);
        x2 = Math.abs(x2);
        y1 = Math.abs(y1);
        y2 = Math.abs(y2);*/
        
        if((x2-x1) == 0)
            return (double) y2-y1; 
        
        double slope =  ((double)(y2-y1)/(x2-x1)); 
        //System.out.println("Slope being returned:" + slope);
        return slope; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
