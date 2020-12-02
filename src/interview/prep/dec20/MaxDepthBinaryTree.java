package interview.prep.dec20;

import interview.prep.leetcode.june20.CountTreeNodes.TreeNode;

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
