package interview.prep.leetcode;

import lombok.Data;

/*
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Note:

The number of nodes in the given list will be between 1 and 100.
 */

/**
 * Definition for singly-linked list.
 */
@Data
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	public void next(ListNode _nest) {
		this.next= _nest;
	}
}

public class MiddleLinkedList {

		public ListNode middleNode(ListNode head) {
			
			if (head == null)
				return null;

			ListNode node = head;
			int size = 1;
			
			while(node.next!=null) {
				node = node.next;
				size++;
			}			
			
			int countDown = 0;
			if (size%2==1) {//odd number
//				countDown = (int)Math.ceil(size/2);
				countDown = (size/2)+1;
			}else {
				countDown = (size/2)+1;
			}					
			
			while(countDown >1) {
				head = head.next;
				countDown--;
			}
			
			return head;

		}
		
	public static void main(String args[]) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		
		one.next(two);
		two.next(three);
		three.next(four);
		four.next(five);
		five.next(six);
		
		
		
//		System.out.println(new MiddleLinkedList().middleNode(one).getVal());
		
//		System.out.println(new MiddleLinkedList().middleNode(two).getVal());
	}
}
