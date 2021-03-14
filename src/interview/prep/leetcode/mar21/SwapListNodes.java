package interview.prep.leetcode.mar21;

import interview.prep.leetcode.myutils.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
Swapping Nodes in a Linked List
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
   Hide Hint #1
We can transform the linked list to an array this should ease things up
   Hide Hint #2
After transforming the linked list to an array it becomes as easy as swapping two integers in an array then rebuilding the linked list

 */
public class SwapListNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        SwapListNodes s = new SwapListNodes();
        s.swapNodes(head,1);
    }

    //Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next ==null)
            return head;

        List<ListNode> lst = new ArrayList<>();
        lst.add(null); //0th ele

        ListNode temp = head;
        while(temp !=null){
            lst.add(temp);
            temp = temp.next;
        }

        ListNode beg = lst.get(k);
        ListNode en = lst.get(lst.size() - k);

        if(beg ==en)
            return head;

        System.out.println("begEle:  " + beg.val + " endEle="+en.val);


        lst.set(k,en);
        lst.set(lst.size()-k , beg);

        System.out.println("Value of k from begin = "+k + " value of k from end :" + (lst.size()-k));

        for(int i=1; i<lst.size(); i++){
            ListNode prior = lst.get(i-1);
            if(prior == null) continue;
            prior.next = lst.get(i);
        }


        ListNode last = lst.get(lst.size()-1);
        last.next = null;


        return head;
    }
}
/*
[1,2,3,4,5]
2
[7,9,6,6,7,8,3,0,9,5]
5
[1]
1
[1,2]
1
[1,2,3]
2
*/