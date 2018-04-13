package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 328. Odd Even Linked List<br>
 * https://leetcode.com/problems/odd-even-linked-list<br><br>
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking 
 * about the node number and not the value in the nodes. You should try to do it in place. The program should run in 
 * O(1) space complexity and O(nodes) time complexity.<br>
 * 
 * Example:<br>
 * Given 1->2->3->4->5->NULL, Return 1->3->5->2->4->NULL.<br><br>
 * 
 * Note:<br>
 * 1. The relative order inside both the even and odd groups should remain as it was in the input.<br>
 * 2. The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

    public static ListNode solution(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        System.out.println(OddEvenLinkedList.solution(head));
    }

}
