package edu.wz.cs.leetcode.easy;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks<br>
 * https://leetcode.com/problems/implement-queue-using-stacks<br><br>
 * 
 * Implement the following operations of a queue using stacks.<br>
 * push(x) -- Push element x to the back of queue.<br>
 * pop() -- Removes the element from in front of queue.<br>
 * peek() -- Get the front element.<br>
 * empty() -- Return whether the queue is empty.<br><br>
 * 
 * Notes:<br>
 * 1. You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is 
 * empty operations are valid.<br>
 * 2. Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or 
 * deque (double-ended queue), as long as you use only standard operations of a stack.<br>
 * 3. You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty 
 * queue).
 */
public class ImplementQueueUsingStacks {
    
    private Stack<Integer> stack;
    private Stack<Integer> temp;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack = new Stack<Integer>();
        temp = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
