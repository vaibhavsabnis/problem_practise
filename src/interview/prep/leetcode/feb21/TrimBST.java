package interview.prep.leetcode.feb21;

import interview.prep.leetcode.ArrayToTreeMaker;
import interview.prep.leetcode.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,1,3};
        TreeNode root = ArrayToTreeMaker.makeTree(arr);
        new TrimBST().trimBST(root,3,5);
    }


}
/*
[4,2,5,1,3]
3
5
[3,2,4,1]
2
4
[3,0,4,null,2,null,null,1]
1
3
[3,1,4,null,2]
3
4
[1,0,2]
1
2
[3,2,null,1]
1
3
[1]
1
2
[1,null,2]
1
3
[1,null,2]
2
4
*/
/*
[3,2,4,1]
2
4
[3,0,4,null,2,null,null,1]
1
3
[3,1,4,null,2]
3
4
[1,0,2]
1
2
[3,2,null,1]
1
3
[1]
1
2
[1,null,2]
1
3
[1,null,2]
2
4
*/
