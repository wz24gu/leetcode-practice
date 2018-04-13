package edu.wz.cs.leetcode.hard;

import java.util.Stack;

/**
 * 716. Max Stack<br>
 * https://leetcode.com/problems/max-stack<br><br>
 * 
 * Design a max stack that supports push, pop, top, peekMax and popMax.<br>
 * push(x) -- Push element x onto stack.<br>
 * pop() -- Remove the element on top of the stack and return it.<br>
 * top() -- Get the element on the top.<br>
 * peekMax() -- Retrieve the maximum element in the stack.<br>
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, 
 * only remove the top-most one.<br><br>
 * 
 * Note:<br>
 * 1. -1e7 <= x <= 1e7<br>
 * 2. Number of operations won't exceed 10000.<br>
 * 3. The last four operations won't be called when stack is empty.
 */
public class MaxStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> max;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        max = new Stack<Integer>();
    }
    
    public void push(int x) {
        int m = max.isEmpty() ? Integer.MIN_VALUE : max.peek();
        m = Math.max(m, x);
        stack.push(x);
        max.push(m);
    }
    
    public int pop() {
        max.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max.peek();
    }
    
    public int popMax() {
        int m = max.peek();
        
        Stack<Integer> tmp = new Stack<>();
        while (stack.peek() != m) {
            tmp.push(stack.pop());
            max.pop();
        }
        stack.pop();
        max.pop();
        
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return m;
    }
    
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5); 
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}
