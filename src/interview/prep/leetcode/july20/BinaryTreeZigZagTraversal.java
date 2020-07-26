package interview.prep.leetcode.july20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * inary Tree Zigzag Level Order Traversal

Solution
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigZagTraversal {
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();

		// sanitize
		if (root == null)
			return res;

		// define queue & visited set
		Deque<TreeNode> q = new LinkedList<>();

		// add root to queue
		q.add(root);
		boolean l2r = true;
		// remove from queue.mark visited. do work
		while (!q.isEmpty()) {
			int nodeCount = q.size();
			List<Integer> level = new ArrayList<>();

			while (nodeCount-- > 0) {
				TreeNode t = q.poll();

				level.add(t.val);

				// add children
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
			if (!l2r)
				Collections.reverse(level);

			l2r = !l2r;
			res.add(level);
		}
		return res;
	}
}
