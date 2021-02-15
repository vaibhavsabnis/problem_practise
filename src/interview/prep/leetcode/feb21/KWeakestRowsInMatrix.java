package interview.prep.leetcode.feb21;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class KWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {

        TreeMap<Integer, List<Integer>> freq = new TreeMap<>();
        for(int i=0; i< mat.length; i++){
            int rCnt = 0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1)
                    rCnt++;
            }
            List<Integer> rowList = freq.getOrDefault(rCnt,new ArrayList<>());
            rowList.add(i);
            freq.put(rCnt,rowList);
        }
        // System.out.println("Sorted Keys (soldier cnt -> rows): " + freq);

        int[] res = new int[k];
        int i=0;
        while(i<k){
            List<Integer> lst = freq.pollFirstEntry().getValue();
            // System.out.println("Working on row values: " + lst);

            for(int x=0; x<lst.size(); x++){
                if(i>=k)
                    return res;

                res[i++] = lst.get(x);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        KWeakestRowsInMatrix weak = new KWeakestRowsInMatrix();
        int[][] arr = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        weak.kWeakestRows(arr,3);
    }
}
    /*
    [[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]
    3
    [[1,0,0,0],[1,1,1,1],[1,0,0,0], [1,0,0,0]]
    2
    */

