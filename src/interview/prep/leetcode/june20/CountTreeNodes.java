package interview.prep.leetcode.june20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Count Complete Tree Nodes

Solution
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 */


public class CountTreeNodes {
	
	public class TreeNode {
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

	public int countNodes(TreeNode root) {

		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		Set<TreeNode> visited = new HashSet<>();

		int nodeCnt = 0;

		queue.add(root);
//		nodeCnt++;

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll(); // Get the item
			if (curr ==null)
				return nodeCnt;

			if (!visited.contains(curr)) {
				visited.add(curr);
				nodeCnt++;// the actual work
				//doWorkonNode(curr, nodeCnt); // Actual Work;
			}

			for (TreeNode child : getChildNodes(curr)) {
				if (child != null && !visited.contains(child)) {
					queue.add(child);
				}
			}
		}

		return nodeCnt;
	}

	private List<TreeNode> getChildNodes(TreeNode node) {
		List<TreeNode> child = new ArrayList<>();
		if (node == null)
			return child;

		child.add(node.left);
		child.add(node.right);

		return child;
	}

	private void doWorkonNode(TreeNode node, int currCount) {
		if (node != null)
			currCount += 1;
	}

	public static void main(String[] args) {
		CountTreeNodes ct = new CountTreeNodes(); 
		TreeNode root = ct.buildTree();
		System.out.println("Counting Nodes");
		int cnt = ct.countNodes(root);
		System.out.println("No of nodes = " + cnt);
	}

	private TreeNode buildTree(){
		
		TreeNode root = new TreeNode('A');
		TreeNode b = 	new TreeNode('B');
		TreeNode c = 	new TreeNode('C');
		TreeNode d= 	new TreeNode('D');
		TreeNode e= 	new TreeNode('E');
		TreeNode f= 	new TreeNode('F');
		TreeNode g= 	new TreeNode('G');
		TreeNode h= 	new TreeNode('H');
		TreeNode i = 	new TreeNode('I');
		TreeNode j= 	new TreeNode('J');
		TreeNode k= 	new TreeNode('K');
		TreeNode l= 	new TreeNode('L');
		
		root.left = b;
		root.right = c;
		
		b.left = d;
		b.right = e;
		
		d.left = h;
		d.right = i;
		
		c.left =f;
		c.right = g;
		
		f.left = j;
		j.left = k;
		
		g.right = l;
		
		return root;
	}
}
