package interview.prep.dailybyte;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Easy
 *
 * 3666
 *
 * 269
 *
 * Add to List
 *
 * Share
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 *
 * ====
 *
 * Given an array of numbers sorted in ascending order, return a height-balanced binary search tree using every number from the array.
 * Note: height-balanced meaning that the level of any node’s two subtrees should not differ by more than one.
 *
 * Ex: Given the following nums...
 *
 * nums = [1, 2, 3] return a reference to the following tree...
 *        2
 *       /  \
 *      1    3
 * Ex: Given the following nums...
 *
 * nums = [1, 2, 3, 4, 5, 6] return a reference to the following tree...
 *         3
 *        / \
 *       2   5
 *       \  / \
 *        1 4  6
 */
public class SortedArrayToBinarySearchTree {

    //recursive
    //TC: O(N), SC: O(N)    SC only if stack space is considered
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums ==null || nums.length ==0)
            return null;

        return recurse(nums, 0, nums.length-1);
    }

    private TreeNode recurse(int[] nums, int left, int right){
        if(left>right)
            return null;

        int mid = left+ (right-left)/2;

        TreeNode center = new TreeNode(nums[mid]);
        center.left = recurse(nums, left, mid-1);
        center.right = recurse(nums, mid+1, right);

        return center;
    }

    //Iterative
    //TC: O(N), SC: O(1)
    public TreeNode _sortedArrayToBST(int[] nums) {
        if(nums ==null)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);

        int st = nums.length/2; //assume even

        if(nums.length%2 ==1)//odd
            st = (nums.length/2) + 1;

        int ctr=0;

        TreeNode parent = new TreeNode(nums[st]);
        TreeNode root = parent;

        while((st+ctr) < nums.length) {
            parent.right = new TreeNode(nums[st+ctr]);
            ctr++;
            parent = parent.right;
        }

        ctr = 0;
        parent = root;
        while((st-ctr) >=0) {
            parent.left = new TreeNode(nums[st-ctr]);
            ctr++;
            parent = parent.left;
        }

        return root;
    }
}
/*
[-10,-3,0,5,9]
[1,3]
*/