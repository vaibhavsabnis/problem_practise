package interview.prep.leetcode.nov20;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxAncestor {
	public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        return Math.abs(dfsHelper(root, root.val, root.val)); 
    }
    
    private int dfsHelper(TreeNode node, int currMax, int currMin){
        if(node == null)
            return currMax - currMin; 
        currMax = Math.max(currMax, node.val); 
        currMin = Math.min(currMin, node.val); 
        int left = dfsHelper(node.left, currMax, currMin); 
        int right = dfsHelper(node.right, currMax, currMin); 
        
        return Math.max(left, right); 
    }
}
