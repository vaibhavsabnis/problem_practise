package interview.prep.leetcode.july20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Maximum Width of Binary Tree

Solution
Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 

Constraints:

The given binary tree will have between 1 and 3000 nodes.
 */
public class MaxWidthOfBinaryTree {
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

	public int widthOfBinaryTree(TreeNode root) {
		// sanitize
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		// define datastructure -- queue
		Queue<TreeNode> q = new LinkedList<>();

		// add root to ds
		q.add(root);

		// work on ds
		// add children
		int maxWidth = Integer.MIN_VALUE;
		Map<Integer, List<TreeNode>> hm = new HashMap<>();

		while (!q.isEmpty()) {
			int size = q.size();
			int minId = 0;
			int maxId = 0;

			for (int i = 0; i < size; i++) {
				root = q.poll();
				if (i == 0) {
					minId = root.val;
				}
				if (i == size - 1) {
					maxId = root.val;
				}
				if (root.left != null) {
					root.left.val = root.val * 2 + 1;
					q.add(root.left);
				}
				if (root.right != null) {
					root.right.val = root.val * 2 + 2;
					q.add(root.right);
				}
			}

			maxWidth = Math.max(maxWidth, maxId - minId + 1);
		}
		// return 1<<height;
		return maxWidth;
	}
}
