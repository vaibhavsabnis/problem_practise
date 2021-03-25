package interview.prep.leetcode.mar21;

import java.util.*;

public class PacificAtlanticWaterFlow {
    //TC: O(m^2 * n^2)
    //SC:
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix ==null || matrix.length ==0)
            return res;

        for(int r=0; r< matrix.length; r++){ //TC: O(m*n), SC: // O(m*n)
            for(int c=0; c<matrix[r].length; c++){
                if(canReachPacific(matrix, r, c, matrix[r][c], new HashMap<String,Boolean>()) && canReachAtlantic(matrix, r, c, matrix[r][c], new HashMap<String,Boolean>())){
                    List<Integer> found = new ArrayList(Arrays.asList(new Integer[] {r,c}));
                    // found.addAll({r,c});
                    res.add(found);
                }
            }
        }

        return res;
    }

    //TC: O(m*n), SC: // O(m*n)
    private boolean canReachPacific(int[][] matrix, int r, int c, int fromValue, Map<String,Boolean> seen){
        if(r < 0 || c < 0 )
            return true;
        if (r >= matrix.length ||  c >= matrix[0].length || matrix[r][c] == -1 || matrix[r][c] > fromValue)
            return false;

        if(seen.get(r+""+c) !=null){
            if(seen.get(r+""+c))
                return true;
            else
                return false;
        }

        int temp = matrix[r][c];
        matrix[r][c] = -1;
        boolean canReach =
                canReachPacific(matrix, r+1, c, temp,seen) ||
                        canReachPacific(matrix, r-1, c, temp,seen) ||
                        canReachPacific(matrix, r, c+1, temp,seen) ||
                        canReachPacific(matrix, r, c-1, temp,seen);
        matrix[r][c] = temp;

        seen.put(r+""+c, canReach);


        return canReach;
    }

    //TC: O(m*n), SC: // O(m*n)
    private boolean canReachAtlantic(int[][] matrix, int r, int c, int fromValue, Map<String,Boolean> seen){
        if(r >= matrix.length ||  c >= matrix[0].length)
            return true;

        if (r < 0 || c < 0 || matrix[r][c] == -1 || matrix[r][c] > fromValue)
            return false;

        if(seen.get(r+""+c) !=null){
            if(seen.get(r+""+c))
                return true;
            else
                return false;
        }

        int temp = matrix[r][c];
        matrix[r][c] = -1;
        boolean canReach =
                canReachAtlantic(matrix, r+1, c, temp,seen) ||
                        canReachAtlantic(matrix, r-1, c, temp,seen) ||
                        canReachAtlantic(matrix, r, c+1, temp,seen) ||
                        canReachAtlantic(matrix, r, c-1, temp,seen);
        matrix[r][c] = temp;

        seen.put(r+""+c, canReach);

        return canReach;
    }
}
