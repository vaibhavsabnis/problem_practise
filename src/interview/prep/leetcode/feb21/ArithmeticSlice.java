package interview.prep.leetcode.feb21;
/*
413. Arithmetic Slices
Medium

1466

193

Add to List

Share
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
import java.util.Arrays;

public class ArithmeticSlice {

    //T: O(n^3) S:O(1)
    public int _numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int slices = 0;

        for(int i=0; i<A.length; i++){
            for(int j=i+2; j<A.length; j++){
                //if(isArithmetic(Arrays.copyOfRange(A,i,j+1)))
                if(isArithmetic(A,i,j))
                    slices++;
            }
        }

        return slices;
    }

    //T:O(n), S:O(1)
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int slices = 0;
        int ctr = 1;
        for(int i=2; i<A.length; i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                slices = slices + ctr;
                ctr++;
            }else{
                ctr = 1;
            }
        }
        return slices;
    }

    private boolean isArithmetic(int[] arr, int left, int right){
        System.out.println("Got Array to check: "+ Arrays.toString(arr) + "between id: " + left +"," + right);
        if(arr.length < 3 || (right <left +2))
            return false;

        int diff = arr[left+1]-arr[left];

        for(int i=left+2; i<=right; i++){
            if(arr[i]-arr[i-1] != diff){
                return false;
            }
        }
        return true;
    }
}
/*
[1,2,3,4]
[1, 3, 5, 7, 9]
[7, 7, 7, 7]
[3, -1, -5, -9]
[1, 1, 2, 5, 7]
*/
