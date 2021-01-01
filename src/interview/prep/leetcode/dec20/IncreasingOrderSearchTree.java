package interview.prep.leetcode.dec20;

import java.util.ArrayList;
import java.util.List;

import interview.prep.leetcode.june20.CountTreeNodes.TreeNode;

/*
 * Increasing Order Search Tree

Solution
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

 

Example 1:


Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
Example 2:


Input: root = [5,1,7]
Output: [1,null,5,null,7]
 

Constraints:

The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000

 */

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> lst = new ArrayList<>(); 
        dfsHelper(root,lst); 
        formLink(lst);
        return lst.get(0); 
    }
    private void formLink(List<TreeNode> lst){
        if(lst.size() <=1)
            return; 
        
        for(int i=1;i<lst.size(); i++){
            ((TreeNode)lst.get(i-1)).right = lst.get(i); 
            ((TreeNode)lst.get(i-1)).left = null; 
        }
        
        ((TreeNode)lst.get(lst.size()-1)).right = null;
        ((TreeNode)lst.get(lst.size()-1)).left = null;
    }
    private void dfsHelper(TreeNode node, List<TreeNode> lst){
        if(node == null)
            return; 
        //In-order traversal
        dfsHelper(node.left, lst); 
        lst.add(node); 
        dfsHelper(node.right,lst);         
    }
}
