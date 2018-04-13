package edu.wz.cs.leetcode.medium;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 148. Sort List<br>
 * https://leetcode.com/problems/sort-list<br><br>
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return merge(solution(head), solution(slow));
    }
    
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(SortList.solution(head));
    }

}
