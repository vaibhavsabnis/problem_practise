package interview.prep.leetcode;

/*
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

 

Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 

Constraints:

1 <= mat.length, mat[i].length <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in a non-decreasing way.
   Hide Hint #1  
1. (Binary Search) For each row do a binary search to find the leftmost one on that row and update the answer.
   Hide Hint #2  
2. (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner. p can only move left or down. If the value at p is 0, move down. If the value at p is 1, move left. 
Try to figure out the correctness and time complexity of this algorithm.

 */

import java.util.List;

// This is the BinaryMatrix's API interface.
// You should not implement it, or speculate about its implementation
interface BinaryMatrix {
	public int get(int x, int y);

	public List<Integer> dimensions();
}

public class LeftmostColumnWithOne {

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int rows = dimensions.get(0);
		int cols = dimensions.get(1);
		int leftmost = cols+1;
		//System.out.println("rows:" + rows + " cols:" + cols);

		for (int i = 0; i < rows; i++) {
			int currPos = -1;
			if ((binaryMatrix.get(i, cols - 1)) == 0) { // since matrix is sorted
				//System.out.println("This row doesn't have any 1");
				continue;
			} else {
				currPos = performBinarySearch(binaryMatrix, i, cols);//only search until pos as we need leftmost
                if (currPos ==0)
                    return 0; //return the first col. Abort further searches
			}

			if (currPos < leftmost)
				leftmost = currPos;
		}

        
		return leftmost>cols?-1:leftmost;
	}

	private int performBinarySearch(BinaryMatrix binMat, int rowId, int colId) {
		int _1pos = -1;
		
		int left = 0;
		int right = colId-1; 
        
        if (binMat.get(rowId,0)==1)
            return 0;
		
        //perform binary search otherwise
		while(left<=right) {
			int mid = left+((right-left)/2);
			int val = binMat.get(rowId, mid);
			
			if( val== 1) {
				_1pos = mid;
				right = mid-1;
			}
			else if(val==0) {
				left =mid+1;
			}
		}
        //System.out.println("Searching .. RowId:"+rowId+" leftmost 1 position:"+_1pos);
		return _1pos;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
