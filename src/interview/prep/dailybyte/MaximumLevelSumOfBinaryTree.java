package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
1161. Maximum Level Sum of a Binary Tree
Medium

735

40

Add to List

Share
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.



Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2


Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
 */
public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int answer = 0;
        int currLevel = 0;

        while(!q.isEmpty()){
            currLevel++;
            int levelSum = 0;
            int size = q.size();
            while(size-- > 0){
                TreeNode temp = q.poll();
                levelSum += temp.val;

                if(temp.left !=null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            if(maxSum<levelSum){
                maxSum = Math.max(maxSum, levelSum);
                answer = currLevel;
            }
        }

        return answer;
    }
}
