package interview.prep.leetcode.feb21;

import interview.prep.leetcode.ArrayToTreeMaker;
import interview.prep.leetcode.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root ==null)
            return root;

        dfsHelper(root, low, high);
        if(root.val < low || root.val > high){
            root = (root.left ==null) ? root.right: root.left;
        }

        return root;
    }

    private void dfsHelper(TreeNode node, int low, int high) {
        if(node == null)
            return;

        TreeNode left = node.left;
        System.out.println("Left: "+ left);
        while(left !=null && (left.val <low || left.val > high )) {
            System.out.println("Left value: " + left.val);
            node.left = (left.left ==null) ?left.right:left.left;
            left = node.left;
        }
        node.left = left;

        TreeNode right = node.right;
        System.out.println("Right: "+ right);

        while(right !=null && (right.val <low || right.val > high )) {
            System.out.println("Right value: " + right.val);
            node.right = (right.right ==null) ?right.left:right.right;
            right =node.right;
        }
        node.right = right;

        dfsHelper(node.left, low, high);
        dfsHelper(node.right, low, high);
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
