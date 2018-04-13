package edu.wz.cs.leetcode.medium;

import java.util.List;
import java.util.Stack;

import edu.wz.cs.leetcode.model.NestedInteger;

/**
 * 341. Flatten Nested List Iterator<br>
 * https://leetcode.com/problems/flatten-nested-list-iterator<br><br>
 * 
 * Given a nested list of integers, implement an iterator to flatten it.<br>
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class FlattenNestedListIterator {
    
    private Stack<NestedInteger> stack;
    
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        int n = nestedList.size();
        for (int i = n - 1; i >= 0; i++) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next() {
        NestedInteger ni = stack.pop();
        return ni.getInteger();
    }

    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) {
                return true;
            }
            
            ni = stack.pop();
            int n = ni.getList().size();
            for (int i = n - 1; i >= 0; i--) {
                stack.push(ni.getList().get(i));
            }
        }
        
        return false;
    }

}
