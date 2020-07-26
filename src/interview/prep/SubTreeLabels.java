package interview.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
	int num;
	char val;
	List<TreeNode> children= new ArrayList<>();


	TreeNode(){
		super();
	}
	
	TreeNode(int num, char val){
		this();
		this.num = num;
		this.val = val;
	}
	
	void addChild(TreeNode child) {
		children.add(child);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TreeNode && ((TreeNode) obj).num == this.num) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
}

public class SubTreeLabels {
		
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        
    	
    	Map<Integer,TreeNode> nodes = formTree(edges,labels);
    	nodes.forEach((key,val) -> populateAnswer(key,val,labels.charAt(key),ans));
    	
    	return ans;
    }
    
    void populateAnswer(int nodeNum, TreeNode node,char label, int[] ans){
    	ans[nodeNum] = dfs(node, 0, label);    	
    }
    private int dfs(TreeNode curr, int occurence, char label) {
    	
    	if(curr ==null)
    		return occurence; 
    	if(label == curr.val)
    		occurence++; 
    	
    	for(TreeNode child: curr.children)
    		occurence = dfs(child,occurence,label);    	
    	
    	return occurence;
    }
    
    private Map<Integer,TreeNode> formTree(int[][] edges, String labels){
        Map<Integer,TreeNode> nodeLookup = new HashMap<>();  
        
    	for(int[] edge: edges) {
    		int from = edge[0];
    		int to = edge[1];
    		
			TreeNode curr = nodeLookup.getOrDefault(from, new TreeNode(from,labels.charAt(from)));
			curr.addChild(nodeLookup.getOrDefault(to, new TreeNode(to,labels.charAt(to))));
			
			nodeLookup.putIfAbsent(from, curr);
        }
    	return nodeLookup; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
