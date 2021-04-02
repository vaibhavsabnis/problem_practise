package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
102. Binary Tree Level Order Traversal
Medium

4457

104

Add to List

Share
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {
    //TC: O(N)
    //SC: O(N)
    //N = Number of nodes in the tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root ==null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> thisLevel = new ArrayList();
            while(size-- > 0){
                TreeNode temp = q.poll();
                thisLevel.add(temp.val);

                if(temp.left != null)
                    q.offer(temp.left);

                if(temp.right !=null)
                    q.offer(temp.right);

            }
            result.add(thisLevel);
        }

        return result;
    }
}
/*
[3,9,20,null,null,15,7]
[]
[1]
*/
