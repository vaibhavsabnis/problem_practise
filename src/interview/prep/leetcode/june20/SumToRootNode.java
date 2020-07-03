package interview.prep.leetcode.june20;

/*
 * Sum Root to Leaf Numbers

Solution
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
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
	
public class SumToRootNode {

	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode node, int currSum) {
		if (node == null)
			return 0;

		currSum *= 10;
		currSum += node.val;

		if (node.left == null && node.right == null) {// this is leaf node
			return currSum;
		} else {
			int leftSum = dfs(node.left, currSum); 
			int rightSum = dfs(node.right, currSum);
			return leftSum +rightSum;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(0);
		TreeNode right = new TreeNode(2);
		

		root.left = left;
		root.right = right;
		
		int ans = new SumToRootNode().sumNumbers(root);
		System.out.println(ans);

	}
}
