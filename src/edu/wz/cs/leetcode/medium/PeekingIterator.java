package edu.wz.cs.leetcode.medium;

import java.util.Iterator;

/**
 * 284. Peeking Iterator<br>
 * https://leetcode.com/problems/peeking-iterator<br><br>
 * 
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that 
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().<br>
 * 
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].<br>
 * Call next() gets you 1, the first element in the list.<br>
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.<br>
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.<br>
 * 
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?s
 */
public class PeekingIterator implements Iterator<Integer> {
    
    private Integer next;
    private Iterator<Integer> iterator;
    private boolean end;
    
    // initialize any member here.
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
            end = false;
        }
        else {
            end = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
        else {
            next = null;
            end = true;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return !end;
    }

}
