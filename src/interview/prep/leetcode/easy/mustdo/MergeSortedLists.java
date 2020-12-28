package interview.prep.leetcode.easy.mustdo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Merge Two Sorted Lists
Easy

5617

689

Add to List

Share
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.



Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 */
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null)
            return null;

        List<ListNode> arr = getList(l1);
        arr.addAll(getList(l2));
        arr.sort(Comparator.comparingInt(a -> a.val));
        convertToListNode(arr);
        return arr.get(0);
    }

    private void convertToListNode(List<ListNode> arr){
        if(arr.size() <=1)
            return;

        for(int i=1; i<arr.size(); i++){
            ListNode curr = arr.get(i);
            ListNode prev = arr.get(i-1);
            prev.next = curr;
            if(i == arr.size() -1)
                curr.next = null;
        }
    }

    private List<ListNode> getList(ListNode node){
        List<ListNode> res = new ArrayList<>();
        while(node!=null){
            res.add(node);
            node = node.next;
        }
        return res;
    }
}
/*
[1,2,4]
[1,3,4]
[]
[]
[]
[0]
*/