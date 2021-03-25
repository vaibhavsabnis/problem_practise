package interview.prep.dailybyte;

import java.util.Arrays;

/*
Print all subsequences of a given array
 */
public class AllSubsequenceOfArray {
    public static void main(String[] arg){
        AllSubsequenceOfArray find = new AllSubsequenceOfArray();
        int[] nums = {1,2,3};
        int[] subSeq = new int[nums.length];
        find.findSubSequencesRecursively(nums,0,subSeq,0);
    }

    private void findSubSequencesRecursively(int[] orig, int origId, int[] subSeq, int seqId){
        if(origId >= orig.length){//base case
            printArray(subSeq,seqId);
            return;
        }
        //exclude existing ele
        findSubSequencesRecursively(orig,origId+1, subSeq,seqId);

        //include existing ele
        subSeq[seqId] = orig[origId];
        findSubSequencesRecursively(orig,origId+1, subSeq, seqId+1);
    }

    private void printArray(int[] arr, int en){
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,en)));
    }

}
