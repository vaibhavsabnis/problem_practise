package interview.prep.leetcode.aug20;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Reorder List

Solution
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

public class ReorderList {
	public void reorderList(ListNode head) {
        if(head ==null || head.next == null)
            return; 

        Deque<ListNode> q = new LinkedList<>(); 
        ListNode temp = head.next;
        while(temp !=null){
            q.add(temp); 
            temp = temp.next;
        }
        
        temp = head;
        boolean back = true; //true = from back, false = from front of q
        while(q.size()>0){
            if(back){
                temp.next = q.pollLast(); 
                back=false;                 
            }else{
                temp.next = q.pollFirst(); 
                back = true;
            } 
            temp = temp.next;                 
        }
        temp.next = null; 
    }
}
