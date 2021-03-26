package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;

/*
700. Search in a Binary Search Tree
Easy

1334

130

Add to List

Share
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.



Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []


Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
===


This question is asked by Google. Given the reference to the root of a binary search tree and a search value, return the reference to the node that contains the value if it exists and null otherwise.
Note: all values in the binary search tree will be unique.

Ex: Given the tree...

        3
       / \
      1   4
and the search value 1 return a reference to the node containing 1.
Ex: Given the tree

        7
       / \
      5   9
         / \
        8   10
and the search value 9 return a reference to the node containing 9.
Ex: Given the tree

        8
       / \
      6   9
and the search value 7 return null.
 */
public class SearchBST_FindValue {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        return helpFind(root, val);
    }
    public TreeNode helpFind(TreeNode node, int val){
        if (node==null || node.val == val)
            return node;

        if(val<node.val){//search left side
            return helpFind(node.left,val);
        }else{//search right
            return helpFind(node.right,val);
        }
    }
}
