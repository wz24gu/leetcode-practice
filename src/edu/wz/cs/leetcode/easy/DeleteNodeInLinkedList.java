package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 237. Delete Node in a Linked List<br>
 * https://leetcode.com/problems/delete-node-in-a-linked-list<br>
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. Supposed
 * the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become
 * 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeInLinkedList {
    
    public static void solution(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next.next = node3;
        head.next.next.next = new ListNode(4);
        
        System.out.println(head);
        DeleteNodeInLinkedList.solution(node3);
        System.out.println(head);
    }

}
