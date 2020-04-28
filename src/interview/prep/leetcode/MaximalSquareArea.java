package interview.prep.leetcode;
/*
 * Maximal Square
Given a 2D binary matrix filled with 0's and '1''s, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */

public class MaximalSquareArea {

	
	public int maximalSquare(char[][] matrix) {
		if(matrix.length ==0)
            return 0;
		
        int [][] dp = new int[matrix.length][matrix[0].length];
        
        int sideLen = 0;
        
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                int currEle = Character.getNumericValue(matrix[row][col]);
                if(currEle==0){
                    dp[row][col] =0;
                }else{
                	int a=0,b=0,c=0;
                	
                    if(row==0 || col==0){
                        dp[row][col] = 0;
                    }else{
                        a = dp[row][col-1];
                        b = dp[row-1][col];
                        c = dp[row-1][col-1];  
                    }
                    
                    int min =Math.min(Math.min(a,b),c);
                    
                    dp[row][col] = min+currEle;
                    sideLen = Math.max(sideLen,min+currEle);

                }
            }
        }
        
        return sideLen*sideLen;
    }
	
	public static void main(String[] args) {
		char[][] matrix = {
				{'1','0','1','1','1'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}				
		};
//		char[][] matrix = {{}};
//		char[][] matrix = {{'1'}};
		System.out.println(new MaximalSquareArea().maximalSquare(matrix));
	}

}
