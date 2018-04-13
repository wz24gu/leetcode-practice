package edu.wz.cs.leetcode.medium;

import java.util.Stack;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 445. Add Two Numbers II<br>
 * https://leetcode.com/problems/add-two-numbers-ii<br><br>
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes 
 * first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.<br>
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.<br>
 * 
 * Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbersII {
    
    // this will easily overflow
    public static ListNode solution(ListNode l1, ListNode l2) {
        long a = 0;
        while (l1 != null) {
            a = a * 10 + l1.val;
            l1 = l1.next;
        }
        long b = 0;
        while (l2 != null) {            
            b = b * 10 + l2.val;
            l2 = l2.next;
        }
        
        long sum = a + b;
        if (sum == 0) {
            return new ListNode(0);
        }
        
        ListNode head = null;
        while (sum != 0) {
            ListNode node = new ListNode((int) (sum % 10));
            node.next = head;
            head = node;
            sum /= 10;
        }
        return head;
    }
    
    public static ListNode solutionAlt(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }        
        
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(AddTwoNumbersII.solution(l1, l2));
        System.out.println(AddTwoNumbersII.solutionAlt(l1, l2));
    }

}
