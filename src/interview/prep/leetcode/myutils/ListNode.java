package interview.prep.leetcode.myutils;

import lombok.Data;

/*
    Definition for singly-linked list.
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}