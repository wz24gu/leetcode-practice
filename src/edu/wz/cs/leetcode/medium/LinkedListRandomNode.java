package edu.wz.cs.leetcode.medium;

import java.util.Random;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 382. Linked List Random Node<br>
 * https://leetcode.com/problems/linked-list-random-node<br><br>
 * 
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same
 * probability of being chosen.<br>
 * 
 * Follow up:<br>
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently 
 * without using extra space?
 */
public class LinkedListRandomNode {
    
    public static int solution(ListNode head) {        
        int total = 0;
        for (ListNode node = head; node != null; node = node.next) {
            total++;
        }
        
        int r = new Random().nextInt(total) + 1;
        ListNode current = head;
        while (r > 1) {
            current = current.next;
            r--;
        }
        return current.val;
    }
    
    // reservior sampling
    public static int solutionX(ListNode head) {        
        Random random = new Random();
        
        ListNode current = head;
        ListNode result = head;
        for (int i = 1; current != null; i++) {
            if (random.nextInt(i) == 0) {
                result = current;
            }
            current = current.next;
        }
        return result.val;
    }
    
    public static int solutionX2(ListNode head) {
        Random random = new Random();
        
        ListNode curr = head;
        ListNode result = head;
        int count = 1;
        
        while (curr != null) {
            if (random.nextInt(count) == 0) {
                result = curr;
            }
            curr = curr.next;
            count++;
        }
        return result.val;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(LinkedListRandomNode.solution(head));
        System.out.println(LinkedListRandomNode.solutionX(head));
        System.out.println(LinkedListRandomNode.solutionX2(head));
    }

}
