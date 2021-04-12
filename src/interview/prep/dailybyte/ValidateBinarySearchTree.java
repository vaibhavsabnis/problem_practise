package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;
/*
98. Validate Binary Search Tree
Medium

5830

674

Add to List

Share
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree {
    public boolean _isValidBST(TreeNode root) {
        if(root == null)
            return true;

        TreeNode left = root.left;
        TreeNode right = root.right;

        return ((left!=null)?(left.val < root.val): true) && ((right!=null)?(right.val > root.val): true) && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        if(root ==null)
            return true;

        return isValidBSTNode(root, null, null);
    }

    private boolean isValidBSTNode(TreeNode node, Integer lwm, Integer hwm){
        if(node == null) return true;
        if((hwm!= null && node.val >= hwm) ||
                (lwm !=null && node.val <= lwm) ){
            return false;
        }
        return isValidBSTNode(node.left, lwm, node.val) && isValidBSTNode(node.right,node.val, hwm);
    }
}
/*
[2,1,3]
[5,1,4,null,null,3,6]
[1,1,3]
[1]
[5,1,6,null,null,3,7]
[5,1,6,null,null,6,7]
*/