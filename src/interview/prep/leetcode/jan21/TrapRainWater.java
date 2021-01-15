package interview.prep.leetcode.jan21;

import java.util.Arrays;

/*
42. Trapping Rain Water
Hard

9489

145

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
 */
public class TrapRainWater {
    //TC - O(N), SC - O(1)
    public int _trap(int[] height) {
        if(height == null || height.length==0)
            return 0;

        int left =0, right = height.length-1, elevation = 0, res = 0;

        while(left<right){

            int ground = height[ height[left]<height[right] ? left++ : right-- ];


            elevation = Math.max(elevation, ground);
            res += elevation-ground;
        }

        return res;
    }
    //TC- O(n), SC - O(n)
    public int trap(int[] height){
        //minimum of local maxima
        if(height == null || height.length==0)
            return 0;

        int res =0, leftMax =0, rightMax = 0;

        int[] lMax = new int[height.length];
        lMax[0] = height[0];
        int[] rMax = new int[height.length];
        rMax[height.length-1] = height[height.length-1];
//        System.out.println("Incoming Array: "+ Arrays.toString(height));

        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i-1],height[i]);
        }
//        System.out.println("Left Max Array: "+ Arrays.toString(lMax));

        for (int i = height.length-2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1],height[i]);
        }
//        System.out.println("Right Max Array: "+ Arrays.toString(rMax));

        for(int i=0; i<height.length; i++){
            leftMax = lMax[i];//leftMax(height, i);
            rightMax = rMax[i];//rightMax(height,i);

            res += Math.min(rightMax,leftMax) - height[i];
        }

        return res;

    }




    //TC - O(N^2), SC - O(1)
    public int __trap(int[] height){
        //minimum of local maxima
        if(height == null || height.length==0)
            return 0;

        int res =0, leftMax =0, rightMax = 0;

        for(int i=1; i<height.length; i++){
            leftMax = leftMax(height, i);
            rightMax = rightMax(height,i);

            res += Math.min(rightMax,leftMax) - height[i];
        }

        return res;
    }

    private int leftMax(int[] height, int pos){
        int lmax=0;
        for(int i=0; i<=pos; i++){
            lmax = Math.max(lmax, height[i]);
        }
        return lmax;
    }

    private int rightMax(int[] height, int pos){
        int max=0;
        for(int i=pos; i<height.length; i++){
            max = Math.max(max, height[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        TrapRainWater tr = new TrapRainWater();
        System.out.println(tr.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(tr.trap(new int[] {4,2,0,3,2,5}));
    }
}
