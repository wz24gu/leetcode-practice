package edu.wz.cs.leetcode.model;

public class ListNode {
    
    public int val;
    public ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode node = this; node != null; node = node.next) {
            sb.append(node.val + " -> ");
        }
        return sb.substring(0, sb.length() - 4);
    }

}
