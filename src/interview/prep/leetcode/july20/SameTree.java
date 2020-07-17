package interview.prep.leetcode.july20;
/*
 * Same Tree

Solution
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */

public class SameTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    private boolean dfs(TreeNode p, TreeNode q){
        if(p==null && q==null)
            return true; 
        if((p!=null && q==null)||(p==null && q!=null))
            return false; 
        
        if(p.val == q.val && dfs(p.left,q.left)&& dfs(p.right,q.right))
            return true; 
        else
            return false;
    }
}
