package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.ListNode;
import interview.prep.leetcode.myutils.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
109. Convert Sorted List to Binary Search Tree
Medium

2789

93

Add to List

Share
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Example 1:


Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [0]
Output: [0]
Example 4:

Input: head = [1,3]
Output: [3,1]


Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-10^5 <= Node.val <= 10^5
 */
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