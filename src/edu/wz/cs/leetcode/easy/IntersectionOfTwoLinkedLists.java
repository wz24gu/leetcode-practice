package edu.wz.cs.leetcode.easy;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 160. Intersection of Two Linked Lists<br>
 * https://leetcode.com/problems/intersection-of-two-linked-lists<br><br>
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.<br><br>
 * 
 * Notes:<br>
 * 1. If the two linked lists have no intersection at all, return null.<br>
 * 2. The linked lists must retain their original structure after the function returns.<br>
 * 3. You may assume there are no cycles anywhere in the entire linked structure.<br>
 * 4. Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {
    
    public static ListNode solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lenA = length(headA);
        int lenB = length(headB);
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        }
        else if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public static ListNode solutionX(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
    
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        ListNode headB = new ListNode(11);
        headB.next = new ListNode(12);
        headB.next.next = new ListNode(13);
        headB.next.next.next = headA.next.next;
        System.out.println(IntersectionOfTwoLinkedLists.solution(headA, headB));
        System.out.println(IntersectionOfTwoLinkedLists.solutionX(headA, headB));
    }

}
