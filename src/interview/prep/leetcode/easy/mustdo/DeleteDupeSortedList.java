package interview.prep.leetcode.easy.mustdo;

/*
83. Remove Duplicates from Sorted List
Easy

2136

138

Add to List

Share
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
public class DeleteDupeSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null)
            return head;
        ListNode prior = head;
        ListNode curr= head.next;

        while(curr !=null){
            if(prior.val == curr.val){
                prior.next = curr.next;
                curr = curr.next;
            }else{
                // prior.next = curr;
                prior = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    //1->2->2->3->4->4->5
    public static void main(String[] args) {
        DeleteDupeSortedList dp = new DeleteDupeSortedList();

        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);

        head.next=b; b.next= c;c.next = d; d.next = e; e.next=f; f.next=g;

        dp.deleteDuplicates(head);
    }
}
