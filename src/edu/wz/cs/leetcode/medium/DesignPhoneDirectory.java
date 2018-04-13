package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 379. Design Phone Directory<br>
 * https://leetcode.com/problems/design-phone-directory<br><br>
 * 
 * Design a Phone Directory which supports the following operations:<br>
 * get: Provide a number which is not assigned to anyone.<br>
 * check: Check if a number is available or not.<br>
 * release: Recycle or release a number.
 */
public class DesignPhoneDirectory {
    
    private Set<Integer> used;
    private Queue<Integer> available;
    private int max;
    
    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        used = new HashSet<Integer>();
        available = new LinkedList<Integer>();
        max = maxNumbers;
        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!available.isEmpty()) {
            int result = available.poll();
            used.add(result);
            return result;
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= max) {
            return false;
        }
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) {
            available.offer(number);
        }
    }

}
