package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues<br>
 * https://leetcode.com/problems/implement-stack-using-queues<br><br>
 * 
 * Implement the following operations of a stack using queues.<br>
 * 1. push(x) -- Push element x onto stack.<br>
 * 2. pop() -- Removes the element on top of the stack.<br>
 * 3. top() -- Get the top element.<br>
 * 4. empty() -- Return whether the stack is empty.<br><br>
 * 
 * Notes:<br>
 * 1. You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and 
 * is empty operations are valid.<br>
 * 2. Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque 
 * (double-ended queue), as long as you use only standard operations of a queue.<br>
 * 3. You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues {
    
    private Queue<Integer> queue;
    private Queue<Integer> temp;
    
    public ImplementStackUsingQueues() {
       queue = new LinkedList<Integer>();
       temp = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (!queue.isEmpty()) {
            temp.offer(queue.poll());
        }
        queue.offer(x);
        while (!temp.isEmpty()) {
            queue.offer(temp.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        System.out.println(stack.empty());
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

}
