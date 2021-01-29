package interview.prep.leetcode.jan21;

import java.util.*;

public class MaxKSumPairs {
    public int _maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> used = new HashSet<>();
        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(used.contains(i))//already paired up
                continue;

            used.add(i);
            int pos = bSearch(k-nums[i],nums, used);
            if(pos != -1){
                System.out.println("For position: "+ i + " val: " + nums[0] + ", found a pair at position: " + pos + " val: "+ nums[pos]);
                used.add(pos);
                res++;
            }
        }
        return res;
    }

    private int bSearch(int x, int[] arr, Set<Integer> used){
        System.out.println("Trying to find : " + x);
        if(arr ==null || arr.length <1)
            return -1;
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == x ) {
                return mid;
            }
            if(arr[mid]<x)
                l = mid+1;
            if(arr[mid] > x)
                r = mid-1;
        }
        return -1;
    }
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int i: nums)
            count.put(i,count.getOrDefault(i,0)+1);

        int pairs = 0;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(count.get(x)==null || count.get(k-x)==null) //pair doesnt exist
                continue;

            if(k/2 == x && k%2 ==0){
                pairs += count.get(x)/2;
                count.remove(x);
            }else{
                if(count.get(k-x)!=null){
                    pairs += Math.min(count.get(x), count.get(k-x));
                    count.remove(x);
                    count.remove(k-x);
                }
            }
        }
        return pairs;
    }
    public static void main(String[] args) {
        System.out.println(17/3);
        MaxKSumPairs m = new MaxKSumPairs();
        int[] nums = {1,2,3,4};
        int sum = 5;
        m.maxOperations(nums,sum);
    }
}
