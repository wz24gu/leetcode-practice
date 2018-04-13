package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import edu.wz.cs.leetcode.model.RandomListNode;

/**
 * 138. Copy List with Random Pointer<br>
 * https://leetcode.com/problems/copy-list-with-random-pointer<br><br>
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in 
 * the list or null.<br>
 * 
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    
    public static RandomListNode solution(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // loop 1: copy all nodes
        RandomListNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        
        // loop 2: assign next and random
        curr = head;
        while (curr != null) {
            RandomListNode node = map.get(curr);
            if (curr.next != null) {
                node.next = map.get(curr.next);
            }
            if (curr.random != null) {
                node.random = map.get(curr.random);
            }
            curr = curr.next;
        }
        
        return map.get(head);
    }
    
    public static RandomListNode solutionX(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        RandomListNode curr = head;
        RandomListNode next = null;
        
        // loop 1: make copy of each node and insert them between current and next
        while (curr != null) {
            next = curr.next;
            
            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        
        // loop 2: assign random node
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random;
            }
            curr = curr.next.next;
        }
        
        // loop 3: restore the original list and extract the copy list
        curr = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode copy;
        RandomListNode copyCurr = dummy;
        while (curr != null) {
            next = curr.next.next;
            
            // extract the copy
            copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;
            
            // restore the original list
            curr.next = next;
            
            curr = next;
        }
        
        return dummy.next;
    }

}
