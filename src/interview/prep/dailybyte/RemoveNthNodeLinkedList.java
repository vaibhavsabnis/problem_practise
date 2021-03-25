package interview.prep.dailybyte;

import interview.prep.leetcode.myutils.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
19. Remove Nth Node From End of List
Medium

4950

294

Add to List

Share
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
===
This question is asked by Facebook. Given a linked list and a value n, remove the nth to last node and return the resulting list.

Ex: Given the following linked lists...

1->2->3->null, n = 1, return 1->2->null
1->2->3->null, n = 2, return 1->3->null
1->2->3->null, n = 3, return 2->3->null
 */
public class RemoveNthNodeLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> positionMap = new HashMap<>();
        ListNode temp = head;
        int pos = 1;
        while(temp!=null){
            positionMap.put(pos++, temp);
            temp = temp.next;
        }

        int posToDelete = pos - n;

        // System.out.println("The node to be deleted "+ posToDelete);

        ListNode prior = positionMap.get(posToDelete-1);
        if(prior ==null)
            return head.next;

        // System.out.println("Got prior node -> " + prior.val);

        ListNode toDelete = (ListNode)positionMap.get(posToDelete);
        // System.out.println("Got prior node -> " + toDelete.val);
        prior.next = toDelete.next;

        return head;
    }
}
/*
[1,2,3,4,5]
2
[1]
1
[1,2]
1
*/
