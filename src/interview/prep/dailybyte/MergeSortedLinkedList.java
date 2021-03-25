package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.ListNode;
/*
21. Merge Two Sorted Lists
Easy

6377

746

Add to List

Share
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.



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
===
This question is asked by Apple. Given two sorted linked lists, merge them together in ascending order and return a reference to the merged list

Ex: Given the following lists...

list1 = 1->2->3, list2 = 4->5->6->null, return 1->2->3->4->5->6->null
list1 = 1->3->5, list2 = 2->4->6->null, return 1->2->3->4->5->6->null
list1 = 4->4->7, list2 = 1->5->6->null, return 1->4->4->5->6->7->null


*/

public class MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 ==null && l2 ==null)
        return null;
    if(l1 ==null)
        return l2;
    if(l2 ==null)
        return l1;

    ListNode dummy = new ListNode(-1);
    ListNode head = dummy;
    while(l1!=null && l2!=null){
        if(l1.val <= l2.val){
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }else{
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }
    }

    if(l1!=null){
        head.next = l1;
    }
    if(l2 !=null){
        head.next = l2;
    }

    return dummy.next;
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