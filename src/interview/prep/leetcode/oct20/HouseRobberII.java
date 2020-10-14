package interview.prep.leetcode.oct20;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums ==null || nums.length <1)
            return 0; 
        if(nums.length ==1)
            return nums[0]; 
        
        int round1 = robHelper(Arrays.copyOfRange(nums,0,nums.length-1)); 
        int round2 = robHelper(Arrays.copyOfRange(nums,1,nums.length)); 
        return Math.max( round1,round2 ); 

    }
    private int robHelper(int[] nums){
        // System.out.println("Incoming array:" + Arrays.toString(nums));
        if(nums ==null || nums.length <1)
            return 0; 
        if(nums.length ==1)
            return nums[0]; 
        
        int[] dp = new int[nums.length]; 
        dp[0] = nums[0]; 
        dp[1] = Math.max(dp[0],nums[1]); 
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]); 
        }
        // System.out.println("Returning : " + dp[nums.length-1]);
        return dp[nums.length-1]; 
    }
}
