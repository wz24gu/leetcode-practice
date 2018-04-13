package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

import edu.wz.cs.leetcode.model.ListNode;

/**
 * 725. Split Linked List in Parts<br>
 * https://leetcode.com/problems/split-linked-list-in-parts<br><br>
 * 
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked 
 * list "parts".<br>
 * 
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. 
 * This may lead to some parts being null.<br>
 * 
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size 
 * greater than or equal parts occurring later.<br>
 * 
 * Return a List of ListNode's representing the linked list parts that are formed.<br><br>
 * 
 * Note:<br>
 * 1. The length of root will be in the range [0, 1000].<br>
 * 2. Each value of a node in the input will be an integer in the range [0, 999].<br>
 * 3. k will be an integer in the range [1, 50].
 */
public class SplitLinkedListInParts {
    
    public static ListNode[] solution(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (root == null) {
            return res;
        }
        
        int len = 0;
        ListNode curr = root;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        int avg = len / k;
        int ext = len % k;        
        curr = root;
        
        for (int i = 0; i < k && curr != null; i++) {
            res[i] = curr;
            
            ListNode prev = null;
            int limit = avg + (ext > 0 ? 1 : 0);
            for (int j = 0; j < limit && curr != null; j++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            ext--;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        System.out.println(Arrays.toString(SplitLinkedListInParts.solution(root, 5)));
        
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(3);
        root2.next.next.next = new ListNode(4);
        root2.next.next.next.next = new ListNode(5);
        root2.next.next.next.next.next = new ListNode(6);
        root2.next.next.next.next.next.next = new ListNode(7);
        root2.next.next.next.next.next.next.next = new ListNode(8);
        root2.next.next.next.next.next.next.next.next = new ListNode(9);
        root2.next.next.next.next.next.next.next.next.next = new ListNode(10);
        System.out.println(Arrays.toString(SplitLinkedListInParts.solution(root2, 3)));
    }

}
