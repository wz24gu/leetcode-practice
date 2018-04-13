package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 147. Insertion Sort List<br>
 * https://leetcode.com/problems/insertion-sort-list<br><br>
 * 
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    
    public static ListNode solution(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;        
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }
            
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
            prev = dummy;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(InsertionSortList.solution(head));
    }

}
