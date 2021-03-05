package interview.prep.leetcode.mar21;

import interview.prep.AddTwoNumbers;
import interview.prep.leetcode.myutils.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
ntersection of Two Linked Lists

Solution
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.



Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.


Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.


Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.

 */
public class ListIntersection {
    //TC:O(N^2) SC: O(1)
    public ListNode _getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB ==null)
            return null;

        ListNode tempA = headA;

        while(tempA !=null){
            ListNode tempB = headB;
            while(tempB!=null){
                if(tempA == tempB)
                    return tempA;

                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }

    //TC: O(N+M) where N = len of ListNode_A, M = len of ListNode_B
    //SC: O(N)
    public ListNode __getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB ==null)
            return null;

        Set<ListNode> setA = new HashSet<>();

        while(headA !=null){
            setA.add(headA);
            headA = headA.next;
        }

        while(headB!=null){
            if(setA.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB ==null)
            return null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        int lenA = 0;
        while(tempA!=null){
            lenA++;
            tempA = tempA.next;
        }

        int lenB = 0;
        while(tempB!=null){
            lenB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;
        if(lenA > lenB){
            //move tempA until then become same
            while(lenA == lenB){
                tempA = tempA.next;
                lenA--;
            }
        }
        else if(lenA < lenB){
            //move tempA until then become same
            while(lenA == lenB){
                tempB = tempB.next;
                lenB--;
            }
        }

        while(tempA!=null && tempB !=null){
            if(tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}
