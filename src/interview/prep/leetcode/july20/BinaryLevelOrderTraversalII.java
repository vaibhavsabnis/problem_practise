package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * Binary Tree Level Order Traversal II

Solution
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryLevelOrderTraversalII {
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

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();

		// sanitize
		if (root == null)
			return res;

		// define queue & visited set
		Queue<TreeNode> q = new LinkedList<>();

		// add root to queue
		q.add(root);

		// remove from queue.mark visited. do work
		while (!q.isEmpty()) {
			int nodeCount = q.size();
			List<Integer> level = new ArrayList<>();

			while (nodeCount > 0) {
				TreeNode t = q.poll();

				level.add(t.val);

				// add children
				if (t.left != null)
					q.add(t.left);
				if (t.right != null)
					q.add(t.right);

				nodeCount--;
			}
			res.addFirst(level);
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
