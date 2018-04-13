package edu.wz.cs.leetcode.easy;

import java.util.Stack;

/**
 * 155. Min Stack<br>
 * https://leetcode.com/problems/min-stack<br><br>
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.<br>
 * push(x) -- Push element x onto stack.<br>
 * pop() -- Removes the element on top of the stack.<br>
 * top() -- Get the top element.<br>
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    
    private Stack<int[]> stack;
    private int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<int[]>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x < min) {
            min = x;
        }
        stack.push(new int[] {x, min});
    }
    
    public void pop() {
        stack.pop();
        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        }
        else {
            min = stack.peek()[1];
        }
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(-2);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

}
