package interview.prep.dec20;

import interview.prep.leetcode.june20.CountTreeNodes.TreeNode;
/*
 * Maximum Depth of Binary Tree

Solution
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
public class MaxDepthBinaryTree {
	 public int maxDepth(TreeNode root) {
	        if(root ==null )
	            return 0; 
	        return findDepth(root, 0,1); 
	    }
	    
	    public int findDepth(TreeNode node, int currDepth, int maxDepth){
	        if(node == null)
	            return maxDepth;
	        
	        currDepth++; 
	        maxDepth = Math.max(currDepth, maxDepth); 
	        
	        maxDepth = Math.max(findDepth(node.left, currDepth,maxDepth),
	                            findDepth(node.right, currDepth,maxDepth)); 
	        return maxDepth; 
	    }
	    /*
	[3,9,20,null,null,15,7]
	[1,null,2,3,null, 4]
	[]
	[0]
	*/
}
