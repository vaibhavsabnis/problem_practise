package interview.prep.dailybyte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of integers, return whether or not two numbers sum to a given target, k.
Note: you may not sum a number with itself.

Ex: Given the following...

[1, 3, 8, 2], k = 10, return true (8 + 2)
[3, 9, 13, 7], k = 8, return false
[4, 2, 6, 5, 2], k = 4, return true (2 + 2)
 */
public class TwoSum {

    //TC: O(N); SC - O(N)
    public int[] twoSum(int[] nums, int target) {
        int[] ret= {-1,-1};
        HashMap<Integer,Integer> posMap = new HashMap<>();
        for(int i=0;i<nums.length; i++){
            if(posMap.containsKey(target-nums[i])){
                ret[0] = posMap.get(target-nums[i]);
                ret[1] = i;
            }
            posMap.put(nums[i],i);
        }
        return ret;
    }
//    TC: O(N^2), SC:O(N)
    public int[] _twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums ==null || nums.length <2)
            return res;
        Map<Integer,List<Integer>> lookup = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            List<Integer> temp = lookup.get(nums[i]);
            if(temp ==null){
                temp = new ArrayList<>();
            }
            temp.add(i);

            lookup.put(nums[i],temp);
        }
        System.out.println("Lookup map "+lookup);

        for(int i=0; i< nums.length; i++){
            int remaining = target - nums[i];
            int otherId = find(lookup, remaining, i);

            System.out.println("got index for remainig: " + otherId);

            if(otherId!= -1){
                res[0] = i;
                res[1] = otherId;
                break;
            }
        }
        return res;
    }

    public int find(Map<Integer, List<Integer>> lookup, int target, int excludePos){
        System.out.println("Trying to find " + target + " excluding pos " + excludePos);
        int res = -1;

        List<Integer> posList = lookup.get(target);
        if(posList ==null)
            return res;
        for(int i=0; i<posList.size(); i++){
            int pos = posList.get(i);
            if(pos == excludePos)
                continue;
            else
                return pos;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum ts = new TwoSum();
        ts.twoSum(nums,9);
    }
}
