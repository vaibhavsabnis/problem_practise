package interview.prep.leetcode.jan21;

import lombok.val;

import java.util.*;

/*
Vertical Order Traversal of a Binary Tree
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (x, y), its left and right children will be at positions (x - 1, y - 1) and (x + 1, y - 1) respectively.

The vertical order traversal of a binary tree is a list of non-empty reports for each unique x-coordinate from left to right. Each report is a list of all nodes at a given x-coordinate. The report should be primarily sorted by y-coordinate from highest y-coordinate to lowest. If any two nodes have the same y-coordinate in the report, the node with the smaller value should appear earlier.

Return the vertical order traversal of the binary tree.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: Without loss of generality, we can assume the root node is at position (0, 0):
The node with value 9 occurs at position (-1, -1).
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2).
The node with value 20 occurs at position (1, -1).
The node with value 7 occurs at position (2, -2).
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report [1,5,6], the node with value 5 comes first since 5 is smaller than 6.


Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
*/
public class VerticalOrderTraversalReportBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Position{
        public int x;
        public int y;
        public TreeNode node;
        public Position(int x, int y, TreeNode node){
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer,List<Position>> hm = new TreeMap<>();

        dfsHelper(root, 0,0,hm);

        for(Integer x: hm.keySet()){
            List<Position> p = hm.get(x);


            p.sort((a, b) -> (a.y == b.y) ? a.node.val - b.node.val : b.y - a.y);

            List<Integer> lst = new ArrayList<>();
            for(Position pos: p){
                lst.add(pos.node.val);
            }
            res.add(lst);
        }
        return res;
    }

    private void dfsHelper(TreeNode node, int x, int y, Map<Integer,List<Position>> treeMap){
        if (node==null)
            return;

        dfsHelper(node.left, x-1, y-1,treeMap);
        dfsHelper(node.right, x+1, y-1, treeMap);
        System.out.println("Visiting: "+node.val + " has position (x,y): ("+x+","+y+")");


        List<Position> p = treeMap.getOrDefault(x, new ArrayList<>());
        p.add(new Position(x,y,node));
        treeMap.put(x,p);
    }
}
