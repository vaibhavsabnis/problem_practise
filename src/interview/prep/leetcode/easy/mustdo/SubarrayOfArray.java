package interview.prep.leetcode.easy.mustdo;

import java.util.ArrayList;
import java.util.List;

public class SubarrayOfArray {

    public List<List<Integer>> populateSubListsIteratively(int[] arr){
        List<List<Integer>> subLists = new ArrayList<>();
        if(arr ==null || arr.length ==0)
            return subLists;

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                List<Integer> subArray = new ArrayList();
                for(int k =i; k<=j; k++){
                    subArray.add(arr[k]);
                }
                subLists.add(subArray);
            }
        }
        return subLists;
    }

    public static void main(String[] args) {
        SubarrayOfArray sub = new SubarrayOfArray();
        int[] arr = {1,2,3,4,5};

        List<List<Integer>>  res = sub.populateSubListsIteratively(arr);
        res.forEach(System.out::println);
    }

}
