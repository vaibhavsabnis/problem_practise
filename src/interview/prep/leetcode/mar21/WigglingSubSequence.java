package interview.prep.leetcode.mar21;

import interview.prep.dailybyte.AllSubsequenceOfArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Wiggle Subsequence

Solution
Given an integer array nums, return the length of the longest wiggle sequence.

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are alternately positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.



Example 1:

Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: nums = [1,2,3,4,5,6,7,8,9]
Output: 2


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000


Follow up: Could you solve this in O(n) time?
 */
public class WigglingSubSequence {

    //TC: O(N)
    //SC: O(1)
    //Assumption:
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }

    //TC: O(N!)
    //SC: O(N)
    public int _wiggleMaxLength(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <=1)
            return nums.length;

        List<int[]> validSequences = new ArrayList<>();

        int[] ssa = new int[nums.length];
        findSubSequenceRecursively(nums, 0, ssa,0, validSequences);


        return validSequences.size();
    }

    private void findSubSequenceRecursively(int[] orig, int origId, int[] subSeq, int seqId, List<int[]> validSequences){
        if(origId >= orig.length){//base case
            int[] seq = Arrays.copyOfRange(subSeq,0,seqId);
            if(isSequenceWiggling(seq)) {
                printArray(subSeq,seqId);
                validSequences.add(seq);
            }
            return;
        }

        if(seqId>=2 && !isSequenceWiggling(Arrays.copyOfRange(subSeq,seqId-2,seqId))) {
            return;
        }

        //exclude existing ele
        findSubSequenceRecursively(orig,origId+1, subSeq,seqId,validSequences);

        //include existing ele
        subSeq[seqId] = orig[origId];
        findSubSequenceRecursively(orig,origId+1, subSeq, seqId+1,validSequences);
    }

    private void printArray(int[] arr, int en){
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,en)));
    }

    /*
    A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative.
    The first difference (if one exists) may be either positive or negative.
    A sequence with fewer than two elements is trivially a wiggle sequence.
    */
    private boolean isSequenceWiggling(int[] arr){
        if(arr.length<=1)
            return true;

        int prior = compareTo(arr[0], arr[1]);
        if(prior == 0)
            return false;

        for(int i=2; i<arr.length; i++){
            int curr = compareTo(arr[i-1],arr[i]);
            if(curr == prior || curr ==0)
                return false;
            prior = curr;
        }
        return true;
    }

    private int compareTo(int a, int b){
        if(a == b )
            return 0;
        if(a<b)
            return -1;
        if(a>b)
            return +1;

        return 0;
    }

    public static void main(String[] arg){
        WigglingSubSequence find = new WigglingSubSequence();
        int[] nums = {1,2,1,2,1};
        find.isSequenceWiggling(nums);

//        int size = find.wiggleMaxLength(nums);
//        System.out.println("Number of wiggling subsequences = " + size);

    }
}
/*
[1,7,4,9,2,5]
[1,17,5,10,13,15,10,5,16,8]
[1,2,3,4,5,6,7,8,9]
[0,0]
[33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15]
*/
