package interview.prep.leetcode;

public class ArrayToTreeMaker {
    public static TreeNode makeTree(int[] arr){
        if(arr ==null || arr.length == 0)
            throw new IllegalArgumentException("Tree cant be created as input array is blank");

        TreeNode root = makeTreeHelper(null,0,arr);

        return root;
    }
    //left child= 2i+1, right child = 2i+2
    public static TreeNode makeTreeHelper(TreeNode node, int i, int[] arr){
        if(i>arr.length-1)
            return node;

        TreeNode temp = new TreeNode(arr[i]);
        node = temp;

        int lId = 2*i+1;
        int rId = 2*i+2;

        node.left =  makeTreeHelper(node.left, lId,arr);
        node.right = makeTreeHelper(node.right, rId,arr);

        return node;
    }

    public static void printInOrder(TreeNode root){
        if(root ==null)
            return;

        System.out.println(root.val);
        printInOrder(root.left);
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        TreeNode root = makeTree(arr);
        printInOrder(root);
    }
}
