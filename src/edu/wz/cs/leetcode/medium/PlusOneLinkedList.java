package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 369. Plus One Linked List<br>
 * https://leetcode.com/problems/plus-one-linked-list<br><br>
 * 
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.<br>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOneLinkedList {
    
    public static ListNode solution(ListNode head) {
        int carry = helper(head);
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        else {
            return head;
        }        
    }
    
    private static int helper(ListNode node) {
        if (node == null) {
            return 1;  // the same as add 1 to the tail node
        }
        
        int carry = helper(node.next);
        int sum = node.val + carry;
        node.val = sum % 10;
        return sum / 10;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        System.out.println(PlusOneLinkedList.solution(head));        
    }

}
