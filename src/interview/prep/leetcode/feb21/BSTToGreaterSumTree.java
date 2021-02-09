package interview.prep.leetcode.feb21;

import interview.prep.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSTToGreaterSumTree {
    //T:O(n) S:(n) - where n = #of nodes in the BST
    public TreeNode convertBST(TreeNode root) {
        List<Integer> order = new ArrayList<>(); //S: O(n)
        inorderHelper(root, order); //T:O(n)

        System.out.println("Sorted List : " + order);

        Map<Integer,Integer> newVals = new HashMap<>(); //S: O(n)
        int runningSum = 0;

        for(int i=order.size()-1; i>=0; i--){//T:O(n)
            runningSum += order.get(i);
            newVals.put(order.get(i),runningSum);
        }
        System.out.println("Map for new Values : " + newVals);

        dfsSetter(root,newVals);
        return root;
    }

    //T: O(n)
    private void inorderHelper(TreeNode node, List<Integer> lst){
        if(node ==null)
            return;

        inorderHelper(node.left, lst);
        lst.add(node.val);
        inorderHelper(node.right,lst);
    }

    //T:O(n)
    private void dfsSetter(TreeNode node, Map<Integer,Integer> newVals){
        if(node == null)
            return;
        dfsSetter(node.left, newVals);
        dfsSetter(node.right, newVals);
        node.val = newVals.get(node.val);
    }

}
/*
[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
[0,null,1]
[1,0,2]
[3,2,4,1]
*/
