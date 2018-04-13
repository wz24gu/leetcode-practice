package edu.wz.cs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 141. Linked List Cycle<br>
 * https://leetcode.com/problems/linked-list-cycle<br><br>
 * 
 * Given a linked list, determine if it has a cycle in it.<br>
 * 
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycle {
    
    public static boolean solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        Set<ListNode> set = new HashSet<>();        
        for (ListNode node = head; node != null; node = node.next) {
            if (set.contains(node)) {
                return true;
            }
            else {
                set.add(node);
            }
        }
        return false;        
    }
    
    public static boolean solutionX(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = head;
        System.out.println(LinkedListCycle.solution(head));
        System.out.println(LinkedListCycle.solutionX(head));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(LinkedListCycle.solution(head2));
        System.out.println(LinkedListCycle.solutionX(head2));
    }

}
