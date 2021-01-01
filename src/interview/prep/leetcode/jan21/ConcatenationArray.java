package interview.prep.leetcode.jan21;

import java.util.HashMap;
import java.util.Map;

public class ConcatenationArray {
    //T-O(N), S- O(N) ; where N = length of arr under given constraints
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> position = new HashMap<>(); //S-O(N)
        for(int i=0; i<arr.length; i++){ //T-O(N), S - O(1)
            position.put(arr[i],i);
        }

        for(int[] piece: pieces){//T-O(N)
            int len = piece.length;
            if(len > arr.length || len == 0 || (position.get(piece[0])==null))
                return false;

            int stPos = position.get(piece[0]);
            for(int j=1; j<len ; j++){ //T-O(M)
                Integer origPos = position.get(piece[j]);
                if(origPos ==null)// number doesnt exist in orig arr
                    return false;
                if(origPos != j+stPos)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ConcatenationArray ca = new ConcatenationArray();
        var b = ca.canFormArray(
                new int[]{15,88}, new int[][]{{88},{15}}
        );
        System.out.println("canFormArray = " + b);
    }
}
/*
[85]
[[85]]
[15,88]
[[88],[15]]
[49,18,16]
[[16,18,49]]
[91,4,64,78]
[[78],[4,64],[91]]
[1,3,5,7]
[[2,4,6,8]]
*/
