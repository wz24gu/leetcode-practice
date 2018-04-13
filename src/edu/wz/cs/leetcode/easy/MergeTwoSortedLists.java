package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 21. Merge Two Sorted Lists<br>
 * https://leetcode.com/problems/merge-two-sorted-lists<br><br>
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the 
 * nodes of the first two lists.<br><br>
 * 
 * Example:<br>
 * Input: 1->2->4, 1->3->4<br>
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                break;
            }
            if (l2 == null) {
                current.next = l1;
                break;
            }
            
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;                
            }
            else {
                current.next = l2;
                l2 = l2.next;                
            }
            current = current.next;
        }
        
        return head.next;
    }
    
    public static ListNode solutionAlt(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 != null) {
            curr.next = l1;
        }
        else if (l2 != null) {
            curr.next = l2;
        }
        
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(MergeTwoSortedLists.solution(l1, l2));
        
        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(4);
        ListNode l4 = new ListNode(1);
        l4.next = new ListNode(3);
        l4.next.next = new ListNode(4);
        System.out.println(MergeTwoSortedLists.solution(l3, l4));
    }

}
