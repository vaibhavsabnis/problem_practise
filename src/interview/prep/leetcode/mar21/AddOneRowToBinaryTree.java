package interview.prep.leetcode.mar21;

import interview.prep.leetcode.myutils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
/*
Add One Row to Tree

Solution
Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input:
A binary tree as following:
       4
     /   \
    2     6
   / \   /
  3   1 5

v = 1

d = 2

Output:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5

Example 2:
Input:
A binary tree as following:
      4
     /
    2
   / \
  3   1

v = 1

d = 3

Output:
      4
     /
    2
   / \
  1   1
 /     \
3       1
Note:
The given d is in range [1, maximum depth of the given tree + 1].
The given binary tree has at least one tree node.
 */
public class AddOneRowToBinaryTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        //Perform BFS - work =  reach the desired level and add the node

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth =0;
        while(!q.isEmpty()){
            //reduce level
            depth++;
            int lvlCnt = q.size();
            // System.out.println("Current depth" + depth);

            while(lvlCnt-- > 0){
                TreeNode curr = q.poll();
                //do work
                if(d-1 == depth){
                    // System.out.println("Condition met ...depth=" + depth + ", d -1 = " + (d-1));
                    helper(curr,v);
                }
                //add children
                if(curr.left !=null) {
                    q.offer(curr.left);
                }
                if(curr.right !=null){
                    q.offer(curr.right);
                }
            }
            if(d-1==depth)
                return root;
        }
        return root;
    }

    private void helper(TreeNode curr, int v){
        // System.out.println("Trying to add a new row. Curr Val: " + curr.val );
        if(curr ==null)
            return;

        TreeNode newLeft = new TreeNode(v);
        newLeft.left = curr.left;
        curr.left = newLeft;

        TreeNode newRight = new TreeNode(v);
        newRight.right= curr.right;
        curr.right = newRight;
    }
}
/*
[4,2,6,3,1,5]
1
2
[1,2,3,4]
5
4
[4,2,6,3,1,5]
1
3
[4,2,6,3,1,5]
1
1
*/