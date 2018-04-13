package edu.wz.cs.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 604. Design Compressed String Iterator<br>
 * https://leetcode.com/problems/design-compressed-string-iterator<br><br>
 * 
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: 
 * next and hasNext.<br>
 * 
 * The given compressed string will be in the form of each letter followed by a positive integer representing the 
 * number of this letter existing in the original uncompressed string.<br>
 * 
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white 
 * space.<br>
 * hasNext() - Judge whether there is any letter needs to be uncompressed.<br>
 * 
 * Note:<br>
 * Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted 
 * across multiple test cases. Please see here for more details.
 */
public class DesignCompressedStringIterator {
    
    private Queue<int[]> queue;
    
    public DesignCompressedStringIterator(String compressedString) {
        queue = new LinkedList<int[]>();
        int n = compressedString.length();
        int i = 0;
        while (i < n) {
            char c = compressedString.charAt(i);
            int j = ++i;
            while (j < n && compressedString.charAt(j) >= '0' && compressedString.charAt(j) <= '9') {
                j++;
            }
            int num = Integer.parseInt(compressedString.substring(i, j));
            queue.add(new int[] {c, num});
            i = j;
        }
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public char next() {
        if (hasNext()) {
            int[] top = queue.peek();
            if (--top[1] == 0) {
                queue.poll();
            }
            return (char) top[0];
        }
        else {
            return ' ';
        }
    }
    
    public static void main(String[] args) {
        DesignCompressedStringIterator iterator = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }

}
