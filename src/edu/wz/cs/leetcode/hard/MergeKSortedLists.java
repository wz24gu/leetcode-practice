package edu.wz.cs.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 23. Merge k Sorted Lists<br>
 * https://leetcode.com/problems/merge-k-sorted-lists<br><br>
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    
    public static ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists[i] = merge(lists[i], lists[i+k]);
            }
            n = k;
        }
        
        return lists[0];
    }
    
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    public static ListNode solutionX(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }        
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            ListNode next = node.next;
            curr.next = node;
            curr = curr.next;
            curr.next = null;
            
            if (next != null) {
                pq.offer(next);
            }
        }
        
        return head.next;
    }

}
