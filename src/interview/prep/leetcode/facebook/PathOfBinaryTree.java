package interview.prep.leetcode.facebook;

import interview.prep.leetcode.myutils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
257. Binary Tree Paths
Easy

2377

125

Add to List

Share
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class PathOfBinaryTree {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root == null)
            return paths;

        dfsHelper(root,paths, "");
        return paths;
    }

    private void dfsHelper(TreeNode node, List<String> paths, String currPath){
        currPath += String.valueOf(node.val);
        if(node.left ==null && node.right == null){
            paths.add(currPath);
            return;
        }

        if(node.left !=null){
            dfsHelper(node.left, paths, currPath +"->");
        }
        if(node.right != null){
            dfsHelper(node.right, paths, currPath + "->");
        }
    }
}
