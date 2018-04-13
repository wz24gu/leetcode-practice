package edu.wz.cs.leetcode.hard;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 25. Reverse Nodes in k-Group<br>
 * https://leetcode.com/problems/reverse-nodes-in-k-group<br><br>
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.<br>
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a 
 * multiple of k then left-out nodes in the end should remain as it is.<br>
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.<br>
 * 
 * Only constant memory is allowed.<br><br>
 * 
 * For example, Given this linked list: 1->2->3->4->5<br>
 * For k = 2, you should return: 2->1->4->3->5<br>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {
    
    public static ListNode solution(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        int i = 0;
        while (curr != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            }
            else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
    
    private static ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(ReverseNodesInKGroup.solution(head, 2));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        System.out.println(ReverseNodesInKGroup.solution(head2, 3));
    }

}
