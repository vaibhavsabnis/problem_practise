package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;

/*
Given a binary tree, return the sum of all left leaves of the tree. Ex: Given the following tree…

    5
   / \
  2   12
     /  \
    3    8
return 5 (i.e. 2 + 3)
Ex: Given the following tree…

       2
      / \
    4    2
   / \
  3   9
return 3
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;

        int ans =0;
        if(root.left !=null){
            if(root.left.left ==null && root.left.right ==null)
                ans += root.left.val;
            else
                ans+= sumOfLeftLeaves(root.left);
        }

        ans += sumOfLeftLeaves(root.right);

        return ans;
    }

}
