package interview.prep.leetcode.dec20;
/*
Diagonal Traverse

Solution
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.



Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:



Note:

The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {

//        int[] res = new int[matrix.length * matrix[0].length];

        int[] res = new int[20];

        int row = 0;
        int col = 0;
        int dir = 1; //1 up -1 down
        int i=0;
        while(true){
            if(row == matrix.length &&  col == matrix[0].length ){
                res[i++] = matrix[row][col];
                break;
            }
            res[i++] = matrix[row][col];
            System.out.print("Adding: "+res[i-1]);

            if(row >= matrix.length-1 || row <= 0 || col >= matrix[0].length -1 || col <= 0) {
                dir = -dir; //change direction

                if(row > matrix.length-1) row--;
                if(row <0) row++;
                if(col > matrix[0].length-1) col--;
                if(col<0) col++;
            }

            if(dir == 1){
                row -=1;
                col +=1;
            }else if( dir == -1){
                row +=1;
                col -=1;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        DiagonalTraverse dt = new DiagonalTraverse();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        dt.findDiagonalOrder(a);
    }
}
