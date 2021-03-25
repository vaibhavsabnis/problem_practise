package interview.prep.leetcode.facebook;
/*
56. Merge Intervals
Medium

6724

365

Add to List

Share
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    //TC: O(n log(n))
    //SC: O(n)
    //Assumptions/Variables: n = intervals array length.
    public int[][] merge(int[][] intervals) {
        if(intervals ==null || (intervals.length ==1))
            return intervals;

        List<int[]> ans = new ArrayList<>();

        //sort the invtervals array
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        } );


//         //convert the list to arr and return

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[] { start, end });
        return ans.toArray(new int[ans.size()][2]);
    }
}
