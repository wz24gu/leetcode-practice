package edu.wz.cs.leetcode.hard;

import java.util.TreeSet;

/**
 * 683. K Empty Slots<br/>
 * 
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.<br/>
 * 
 * Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower
 * will open in that day. For example, flowers[i] = x means that the unique flower that blooms at day i will be at
 * position x, where i and x will be in the range from 1 to N.<br/>
 * 
 * Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also
 * the number of flowers between them is k and these flowers are not blooming. If there isn't such day, output -1.<br/>
 * 
 * Note: The given array will be in the range [1, 20000].
 */
public class KEmptySlots {
    
    public static int solution(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int current = flowers[i];
            
            Integer next = set.higher(current);
            if (next != null && next - current == k + 1) {
                return i + 1;
            }
            
            Integer prev = set.lower(current);
            if (prev != null && current - prev == k + 1) {
                return i + 1;
            }
            
            set.add(current);
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] flowers = {1, 3, 2};
        System.out.println(KEmptySlots.solution(flowers, 1));
        
        int[] flowers2 = {1, 2, 3};
        System.out.println(KEmptySlots.solution(flowers2, 1));
    }

}
