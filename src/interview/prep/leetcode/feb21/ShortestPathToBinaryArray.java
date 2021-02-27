package interview.prep.leetcode.feb21;

public class ShortestPathToBinaryArray {
    public static void main(String[] args) {
        ShortestPathToBinaryArray s = new ShortestPathToBinaryArray();
        int[][] arr =   {
                {0,0,0},{1,1,0},{1,1,0}
//                        {0,1},
//                        {1,0}
                        };
        System.out.println(s.shortestPathBinaryMatrix(arr));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1)
            return 0; //entry exit are blocked

        int[][] dp = new int[grid.length][grid[0].length];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] =-1;
            }
        }
//        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        dp[0][0] = 1;
        //first col
        for(int i=1; i<grid.length; i++){
            if(grid[i][0] == 0 && grid[i-1][0]!= -1){
                dp[i][0] = dp[i-1][0] + 1;
            }
        }
        //first row
        for(int i=1; i<grid[0].length; i++){
            if(grid[0][i] == 0 && grid[0][i-1]!= -1){
                dp[0][i] = dp[0][i-1] + 1;
            }
        }

        System.out.println("Populated Array first row/col");
        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                dp[i][j] = fetchMin(i,j,grid,dp);
            }
        }

        return dp[grid.length-1][grid[0].length-1];

    }

    private int fetchMin(int i, int j, int[][] grid, int[][] dp){
        if(grid[i][j] ==1)
            return -1; //blocked

        int min = -1;

        int uRBound=0;
        int lRBound=grid.length-1;

        int lCBound = 0;
        int rCBound = grid[0].length-1;

        //north
        if(! ((i-1) < uRBound)){
            int val=(dp[i-1][j] == -1) ?-1:dp[i-1][j]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        //east
        if(! ((j+1) > rCBound)){
            int val = (dp[i][j+1] == -1) ? -1 : dp[i][j+1]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        //west
        if(! ((j-1) < lCBound)){
            int val = (dp[i][j-1] == -1) ? -1 : dp[i][j-1]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        //south
        if(! ((i+1) > lRBound)){
            int val = (dp[i+1][j] == -1) ? -1 : dp[i+1][j]+1;
            min = (min==-1)? val:Math.min(min,val);
        }

        //northeast
        if(!(i-1 < uRBound || j+1 > rCBound)){
            int val = (dp[i-1][j+1] == -1) ? -1 : dp[i-1][j+1]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        //northwest
        if(!(i-1 <uRBound || j-1 < lCBound)){
            int val = (dp[i-1][j-1] == -1) ? -1 : dp[i-1][j-1]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        //southeast
        if(!(i+1 >lRBound || j+1 > rCBound)){
            int val = (dp[i+1][j+1] == -1) ? -1 : dp[i+1][j+1]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        //southwest
        if(!(i+1 >lRBound || j-1 < lCBound)){
            int val = (dp[i+1][j-1] == -1) ? -1 : dp[i+1][j-1]+1;
            min = (min==-1)? val:Math.min(min,val);
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
