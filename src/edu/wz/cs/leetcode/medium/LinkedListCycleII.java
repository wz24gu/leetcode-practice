package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 142. Linked List Cycle II<br>
 * https://leetcode.com/problems/linked-list-cycle-ii<br><br>
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.<br>
 * 
 * Note: Do not modify the linked list.<br>
 * 
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    
    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        
        if (fast == null || fast.next == null) {
            return null;  // no cycle
        }
        
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(LinkedListCycleII.solution(head).val);
    }

}
