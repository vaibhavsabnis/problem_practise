package interview.prep.leetcode.july20;

/*
 This question is asked by Google. Given a linked list and a value, remove all nodes containing the provided value, and return the resulting list.

Ex: Given the following linked lists and values...

1->2->3->null, value = 3, return 1->2->null
8->1->1->4->12->null, value = 1, return 8->4->12->null
7->12->2->9->null, value = 7, return 12->2->9->null

===
* 203. Remove Linked List Elements
Easy

2535

123

Add to List

Share
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.



Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []


Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= k <= 50
 */

import interview.prep.leetcode.myutils.ListNode;

public class RemoveLinkedListElement {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		if (head.next == null && head.val == val)
			return null;
		// to takecare of val at the begining
		while (head != null && head.val == val)
			head = head.next;

		if (head == null) // if head reached end of list
			return head;

		// take care of value in the middle
		ListNode left = head;
		ListNode right = head.next;

		while (right != null && left != null) {
			if (right.val == val) {
				right = right.next;
			} else {
				left.next = right;
				left = left.next;
				right = right.next;
			}
		}

		// to take care values at the end
		if (left != right && left != null)
			left.next = right;

		return head;
	}
}
