package interview.prep.leetcode;

/*
 * 
 * Diameter of Binary Tree
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

 */

//Definition for a binary tree node.

public class DiameterBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int totald; 
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) 
            return 0;
        
        totald = 1;
        diameter(root);
        return totald-1; //count the edges
    }
    
    private int diameter(TreeNode node){
        if (node==null)
            return 0;
        
        int ldiameter = diameter(node.left);
        int rdiameter = diameter(node.right);
        
        totald = Math.max(totald, ldiameter+rdiameter+1);
        
        return Math.max(ldiameter, rdiameter)+1;
    }
}
