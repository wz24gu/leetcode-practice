package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 86. Partition List<br>
 * https://leetcode.com/problems/partition-list<br><br>
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or 
 * equal to x.<br>
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.<br>
 * 
 * For example,<br>
 * Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class PartitionList {
    
    public static ListNode solution(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (prev.next != null && prev.next.val < x) {
            prev = prev.next;
        }
        curr = prev.next;
        
        while (curr.next != null) {
            if (curr.next.val < x) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
                prev = prev.next;
            }
            else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
    
    public static ListNode solutionAlt(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        ListNode orig = new ListNode(-1);
        ListNode small = new ListNode(-1);
        orig.next = head;
        ListNode curr = orig;
        ListNode p = small;
        
        while (curr.next != null) {
            if (curr.next.val < x) {
                p.next = curr.next;
                p = p.next;
                curr.next = curr.next.next;
                p.next = null;  // tricky
            }
            else {
                curr = curr.next;
            }
        }
        
        p.next = orig.next;
        return small.next;        
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(PartitionList.solution(head, 3));
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(2);
        System.out.println(PartitionList.solutionAlt(head2, 3));
    }
    

}
