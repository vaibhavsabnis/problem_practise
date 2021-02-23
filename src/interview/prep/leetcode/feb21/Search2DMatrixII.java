package interview.prep.leetcode.feb21;

public class Search2DMatrixII {
    //M = #rows, N = #cols.   TC: O(M * N) SC:O(M*N)
    public boolean _searchMatrix(int[][] matrix, int target) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        return dfsHelper(matrix, target, 0,0,visited);
    }

    //M = #rows, N = #cols.   TC: O(M * N) SC:O(M*N)
    private boolean dfsHelper(int[][] matrix, int target, int r, int c, int[][] visited){
        boolean found = false;
        if(r<0 || r>matrix.length-1|| c<0 || c>matrix[0].length-1 || matrix[r][c] > target || visited[r][c] == 1)
            return false;

        visited[r][c] = 1;

        if(matrix[r][c] == target)
            found = true;
        else
            found = dfsHelper(matrix, target, r+1, c,visited) || dfsHelper(matrix, target, r, c+1,visited);

        return found;
    }

    //M = #rows, N = #cols.   TC: O(M + logN) SC:O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int r=0; r<matrix.length; r++){
            if(matrix[r][0]> target || matrix[r][matrix[0].length-1] < target)
                continue;
            if(binarySearch(matrix[r], target))
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target){
        boolean found = false;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target)
                right = mid-1;
            else if(arr[mid] < target)
                left = mid+1;

        }
        return found;
    }

    public static void main(String[] args) {
        Search2DMatrixII sd = new Search2DMatrixII();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        sd.searchMatrix(matrix,5);
    }
}
