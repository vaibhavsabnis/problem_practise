package interview.prep.leetcode;
/*
 * Q101: 
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
Bonus points if you could solve it both recursively and iteratively.
*/

/**
 * Definition for a binary tree node.
*/


 
public class SymmetricBinaryTree {
	    public boolean isSymmetric(TreeNode root) {
	        return isMirrorImage(root,root);        
	    }
	    
	    private boolean isMirrorImage(TreeNode n1, TreeNode n2){
	        if (n1 ==null && n2 == null) 
	            return true;
	        if(n1 == null || n2 == null)
	            return false;
	        
	        return (n1.val == n2.val)
	            && isMirrorImage(n1.right,n2.left)
	            && isMirrorImage(n1.left,n2.right);
	    }
	}
