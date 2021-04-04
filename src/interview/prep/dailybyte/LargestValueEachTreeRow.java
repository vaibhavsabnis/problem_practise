package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
515. Find Largest Value in Each Tree Row
Medium

1278

72

Add to List

Share
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).





Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,null,2]
Output: [1,2]
Example 5:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1
 */
public class LargestValueEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int lvlMax = Integer.MIN_VALUE;
            while(size-- >0){
                TreeNode temp = q.poll();
                lvlMax = Math.max(lvlMax, temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }

            result.add(lvlMax);
        }

        return result;
    }
}
/*
[1,3,2,5,3,null,9]
[1]
[1,null,2]
[]
*/