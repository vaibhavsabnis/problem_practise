package interview.prep.leetcode.july20;

/*
 * Remove Linked List Elements

Solution
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

 */

public class RemoveLinkedListElement {
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
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
