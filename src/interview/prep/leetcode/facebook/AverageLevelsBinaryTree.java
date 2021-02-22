package interview.prep.leetcode.facebook;

import interview.prep.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
637. Average of Levels in Binary Tree
Easy

1689

180

Add to List

Share
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */

public class AverageLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            double sum =0;
            int cnt = size;
            while(size-- > 0){
                TreeNode node = q.poll();
                sum +=node.val;
                //add children
                if(node.left !=null) q.offer(node.left);
                if(node.right !=null) q.offer(node.right);
            }
            res.add((double)sum/cnt);
        }

        return res;
    }
}
/*
[3,9,20,15,7]
[2147483647,2147483647,2147483647]
*/
