package interview.prep.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 1380. Lucky Numbers in a Matrix
Easy

201

21

Add to List

Share
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.
 */
public class LuckyNumbers {
	 public List<Integer> luckyNumbers (int[][] matrix) {
	        // if(matrix.length==1)
	        //     return Arrays.asList(matrix); 
	        
	        int[] rowMin= new int[matrix.length]; 
	        int[] colMax = new int[matrix[0].length];
	        
	        for(int r =0; r<matrix.length;r++){
	            int currRowMin = matrix[r][0];
	            for(int c=1;c<matrix[r].length;c++){
	                currRowMin = Math.min(currRowMin,matrix[r][c]);
	            }
	            rowMin[r] = currRowMin;
	        }
	        
	        
	        for(int c =0; c<matrix[0].length;c++){
	            int currColMax = matrix[0][c];
	            for(int r=1;r<matrix.length;r++){
	                currColMax = Math.max(currColMax,matrix[r][c]);
	            }
	            colMax[c] = currColMax;
	        }
	        
	        List<Integer> lucky = new ArrayList<>();
	        
	        // System.out.println(Arrays.toString(rowMin));
	        // System.out.println(Arrays.toString(colMax));
	        
	        for(int r =0; r<matrix.length;r++){
	            int min = rowMin[r];
	            for(int c=0;c<matrix[r].length;c++){
	                int max = colMax[c];
	                if(min==matrix[r][c] && max==matrix[r][c])
	                    lucky.add(matrix[r][c]); 
	            }
	         }
	        
	        return lucky;
	    }
}
