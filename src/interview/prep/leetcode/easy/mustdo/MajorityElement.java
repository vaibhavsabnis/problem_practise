package interview.prep.leetcode.easy.mustdo;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int threshold = nums.length / 2;
        // System.out.println("Threshold: " + threshold);

        Map<Integer,Integer> freq= new HashMap<>();
        for(int i: nums)
            freq.put(i,freq.getOrDefault(i,0)+1);

        // System.out.println("Freq Map Size: " + freq.size());

        for(int key:freq.keySet()){
            // System.out.println("Working on key: " + key +" having value: "+ freq.get(key));
            if(freq.get(key)>threshold)
                return key;
        }
        return -1;
    }
}
/*
[3,2,3]
[2,2,1,1,1,2,2]
[1]
*/
