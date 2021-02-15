package interview.prep.leetcode.easy.mustdo;

import java.util.ArrayList;
import java.util.List;

public class SlidingMaximumWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;

        List<Integer> res = new ArrayList<>();
        int st = 0;
        int en = k - 1;

        int prevMax = nums[st];
        while (en < nums.length) {

            int currMax = prevMax;

            if (st == 0) {//first time always find
                currMax = findMax(st, en, nums);
            } else {
                if (nums[en] >= prevMax)
                    currMax = nums[en];
                else {
                    if (nums[st - 1] == prevMax) { // only do this if the slide caused priorMax to fall off
                        currMax = findMax(st, en, nums);
                    }
                }
            }
            res.add(currMax);
            st++;
            en++;
            prevMax = currMax;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private int findMax(int st, int en, int[] nums) {
        int currMax = nums[st];

        for (int i = st; i <= en; i++) {
            currMax = Math.max(currMax, nums[i]);
        }

        return currMax;
    }

}

/*
[1,3,1,2,0,5]
3
[1,3,-1,-3,5,3,6,7]
3
[1]
1
[1,-1]
1
[9,11]
2
[4,-2]
2
*/
