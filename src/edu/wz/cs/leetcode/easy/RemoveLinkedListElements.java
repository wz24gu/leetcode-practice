package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 203. Remove Linked List Elements<br>
 * https://leetcode.com/problems/remove-linked-list-elements<br><br>
 * 
 * Remove all elements from a linked list of integers that have value val.<br>
 * 
 * Example<br>
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6<br>
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    
    public static ListNode solution(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }
    
    public static ListNode solutionX(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);        
        System.out.println(head);
        System.out.println(RemoveLinkedListElements.solution(head, 6));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next.next = new ListNode(6);
        System.out.println(head2);
        System.out.println(RemoveLinkedListElements.solution(head2, 6));
    }

}
