package interview.prep.leetcode.jan21;

import interview.prep.leetcode.easy.mustdo.DeleteDupeSortedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class DupeInSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        while(curr!=null && curr.next!=null){

            boolean dupe = false;
            while(curr!=null && curr.next!=null && curr.val == curr.next.val){
                dupe  = true;
                curr = curr.next;
            }

            if(!dupe){
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }

            curr = curr.next;
        }
        return dummy.next;
    }

    //1->2->2->3->4->4->5
    public static void main(String[] args) {
        DupeInSortedListII dp = new DupeInSortedListII();

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
