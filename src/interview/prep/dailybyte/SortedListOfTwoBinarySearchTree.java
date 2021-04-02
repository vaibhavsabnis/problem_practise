package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*


    // TC: O(N*M * log(NM))
    // SC: O(N + M )
    //N: is the number of nodes of the Tree root1,
    //M: is the number of nodes of the Tree root2
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> result = new ArrayList<>();

        List<Integer> one = new ArrayList<>();  //SC: O(N)
        inOrder(root1,one); //TC: O(N), SC: O(1)

        List<Integer> two = new ArrayList<>(); //SC: O(M)
        inOrder(root2, two); //TC: O(M), SC: O(1)

        result.addAll(one);
        result.addAll(two);

        Collections.sort(result); // TC: O(N*M * log(NM))

        return result;
    }

    //TC: O(N), SC = O(N) - where N is the number of nodes of the Tree
    private void inOrder(TreeNode node, List<Integer> result){
        if(node == null)
            return;

        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right,result);
    }
}
/*
[2,1,4]
[1,0,3]
[0,-10,10]
[5,1,7,0,2]
[]
[5,1,7,0,2]
[5,1,7,0,2]
[]
[1,null,8]
[8,1]
*/

public class SortedListOfTwoBinarySearchTree {

    // TC: O(N*M * log(NM))
    // SC: O(N + M )
    //N: is the number of nodes of the Tree root1,
    //M: is the number of nodes of the Tree root2
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> result = new ArrayList<>();

        List<Integer> one = new ArrayList<>();  //SC: O(N)
        inOrder(root1,one); //TC: O(N), SC: O(1)

        List<Integer> two = new ArrayList<>(); //SC: O(M)
        inOrder(root2, two); //TC: O(M), SC: O(1)

        result.addAll(one);
        result.addAll(two);

        Collections.sort(result); // TC: O(N*M * log(NM))

        return result;
    }

    //TC: O(N), SC = O(N) - where N is the number of nodes of the Tree
    private void inOrder(TreeNode node, List<Integer> result){
        if(node == null)
            return;

        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right,result);
    }
}
/*
[2,1,4]
[1,0,3]
[0,-10,10]
[5,1,7,0,2]
[]
[5,1,7,0,2]
[5,1,7,0,2]
[]
[1,null,8]
[8,1]
*/