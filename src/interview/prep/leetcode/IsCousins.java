package interview.prep.leetcode;

/**
 * Definition for a binary tree node.
 */
class BTreeNode {
     int val;
     BTreeNode left;
     BTreeNode right;
     BTreeNode() {}
     BTreeNode(int val) { this.val = val; }
     BTreeNode(int val, BTreeNode left, BTreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


public class IsCousins {
	
	class NodeDetails{
		BTreeNode parent; 
		int level;
		public NodeDetails(BTreeNode node, int level) {
			this.parent = node;
			this.level = level; 
		}
	}
	
    public boolean isCousins(BTreeNode root, int x, int y) {
    	NodeDetails xDetails = searchNode(root, x, null, 0);
    	NodeDetails yDetails = searchNode(root, y, null, 0);
    	
    	if (xDetails ==null || yDetails == null) 
    			return false; 
    	
    	if(xDetails.parent != yDetails.parent && xDetails.level == yDetails.level)
    		return true;
    	
    	return false; 
    }
    
    public NodeDetails searchNode(BTreeNode curr, int valToSearch, BTreeNode parent, int level) {
    	if(curr == null)
    		return null; 
    	
    	if(curr.val == valToSearch)
    		return new NodeDetails(parent, level); 
    	
    	NodeDetails lSearch = searchNode(curr.left, valToSearch, curr, level+1);
    	if(lSearch !=null )
    		return lSearch; 
    	
    	NodeDetails rSearch = searchNode(curr.right, valToSearch, curr, level+1);
    	
    	return rSearch;   	
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
