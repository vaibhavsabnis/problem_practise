package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.ListNode;

import java.util.Stack;

/*
This question is asked by Facebook. Given a linked list, containing unique values, reverse it, and return the result.

Ex: Given the following linked lists...

1->2->3->null, return a reference to the node that contains 3 which points to a list that looks like the following: 3->2->1->null
7->15->9->2->null, return a reference to the node that contains 2 which points to a list that looks like the following: 2->9->15->7->null
1->null, return a reference to the node that contains 1 which points to a list that looks like the following: 1->null

==
206. Reverse Linked List
Easy

6596

125

Add to List

Share
Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    //recursive - using a stack
    //TC: O(N), SC: O(N) - N = number of nodes in the linked list
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        Stack<ListNode> stk = new Stack<>();
        while(head !=null){
            stk.push(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        head = dummy;
        while(!stk.isEmpty()){
            head.next = stk.pop();
            head =head.next;
        }

        head.next = null;

        return dummy.next;
    }

    //iterative without using a stack but 2 pointers
    //TC: O(N), SC: O(1) - N = number of nodes in the linked list
    public ListNode _reverseList(ListNode head) {
        if (head == null || head.next ==null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
