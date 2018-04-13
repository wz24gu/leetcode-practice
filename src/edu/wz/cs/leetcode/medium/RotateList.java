package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 61. Rotate List<br>
 * https://leetcode.com/problems/rotate-list<br><br>
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 */
public class RotateList {
    
    public static ListNode solution(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        int count = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        
        k = k % count;
        if (k == 0) {
            return head;
        }
        
        curr.next = head;
        int m = count - k;
        for (int i = 0; i < m; i++) {
            curr = curr.next;
        }
        
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;   
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(RotateList.solution(head, 2));
    }

}
