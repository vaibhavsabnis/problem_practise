package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.ListNode;
import interview.prep.leetcode.myutils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConverSortedListToBST {
    //TC: O(N), SC: O(N) - N = number of listnodes in the incoming list
    public TreeNode sortedListToBST(ListNode head) {
        if(head ==null)
            return null;
        List<Integer> arr = new ArrayList<>();

        while(head !=null){
            arr.add(head.val);
            head = head.next;
        }

        return formTree(arr, 0, arr.size()-1);
    }

    private TreeNode formTree(List<Integer> arr, int left, int right){
        if(left>right)
            return null;

        int mid = left + (right-left)/2;

        TreeNode center = new TreeNode(arr.get(mid));
        center.left = formTree(arr, left, mid-1);
        center.right = formTree(arr,mid+1, right);

        return center;
    }
}
/*
[-10,-3,0,5,9]
[]
[0]
[1,3]
*/