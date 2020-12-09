package interview.prep.dec20;
/*
 * Spiral Matrix II
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n]; 
        if(n == 1){
            res[0][0] = 1;
            return res; 
        }
        int primer=1; 
        int[] state = {primer,0,-1}; //primer, curri, currj
        while(true){
            if(state[0]>n*n) break; 
            state[2]++; //one right
            state = moveRight(state, res);
            
            state[1]++; //one down
            state = moveDown(state, res);
            
            state[2]--; //one left            
            state = moveLeft(state, res);
            
            state[1]--;
            state = moveUp(state, res); 
        }
        return res; 
    }
    
    private int[] moveRight(int[] state, int[][] res){
        int currVal = state[0]; 
        int i = state[1];//row
        int j = state[2]; //col
        if(  i<0 || i>res.length-1 || res[i][j] !=0 
          || j<0 || j>res[0].length-1  ){
            //reached bounds or am over-writing in current cell
            return state; 
        }
        for(int col=j; col<res[0].length; col++){
            if(res[i][col] !=0) {
                state[2] = col-1; 
                break; // all values to the right are already written
            }
            res[i][col] = currVal++; 
            state[2] = col; 
        }
        state[0] = currVal; 
//        state[1] = i; 
        
        return state; 
    }
    
    private int[] moveLeft(int[] state, int[][] res){
        int currVal = state[0]; 
        int i = state[1];//row
        int j = state[2]; //col
        if(  i<0 || i>res.length-1 || res[i][j] !=0 
          || j<0 || j>res[0].length-1  ){
            //reached bounds or am over-writing in current cell
            return state; 
        }
        
        
        for(int col=j; col>=0; col--){
            if(res[i][col] !=0 ) {
                state[2] = col+1; 
                break; // all values to the left are already written
            }
            res[i][col] = currVal++; 
            state[2] = col; 
        }
        state[0] = currVal; 
//        state[1] = i; 
        
        return state; 
    }
    
    private int[] moveDown(int[] state, int[][] res){
        int currVal = state[0]; 
        int i = state[1];//row
        int j = state[2]; //col
        if(  i<0 || i>res.length-1 || res[i][j] !=0 
          || j<0 || j>res[0].length-1  ){
            //reached bounds or am over-writing in current cell
            return state; 
        }
        
        for(int row =i; row <res.length; row++) {
        	if(res[row][j] !=0) {
        		state[1] = row-1; 
        		break; // everything down below is written
        	}
        	res[row][j] = currVal++; 
        	state[1] = row;
        }
        state[0] = currVal; 
        
        return state;
    }
    
    
    private int[] moveUp(int[] state, int[][] res){
        int currVal = state[0]; 
        int i = state[1];//row
        int j = state[2]; //col
        if(  i<0 || i>res.length-1 || res[i][j] !=0 
          || j<0 || j>res[0].length-1  ){
            //reached bounds or am over-writing in current cell
            return state; 
        }
        
        for(int row =i; row >=0; row--) {
        	if(res[row][j] !=0) {
        		state[1] = row+1; 
        		break; // everything down below is written
        	}
        	res[row][j] = currVal++; 
        	state[1] = row;
        }
        state[0] = currVal; 
        
        return state;
    }
    
    public static void main(String[] args) {
    	SpiralMatrixII sp = new SpiralMatrixII(); 
    	sp.generateMatrix(4);
    }
    /*
     4
     3
     1
     20 
     */
}
