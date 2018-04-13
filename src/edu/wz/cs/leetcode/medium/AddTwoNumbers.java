package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 2. Add Two Numbers<br>
 * https://leetcode.com/problems/add-two-numbers<br><br>
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse 
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.<br>
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(AddTwoNumbers.solution(l1, l2));
    }

}
