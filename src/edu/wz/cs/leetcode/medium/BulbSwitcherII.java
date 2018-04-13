package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 672. Bulb Switcher II<br>
 * https://leetcode.com/problems/bulb-switcher-ii<br><br>
 * 
 * There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m 
 * unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.<br>
 * 
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:<br>
 * 1. Flip all the lights.<br>
 * 2. Flip lights with even numbers.<br>
 * 3. Flip lights with odd numbers.<br>
 * 4. Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...<br>
 * 
 * Note: n and m both fit in range [0, 1000].
 */
public class BulbSwitcherII {
    
    public static int solution(int n, int m) {
        if (n > 6) {
            n = (n % 6) + 6;
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        int start = (1 << n) - 1;  // n is definitely smaller than 32
        queue.offer(start);
        
        for (int i = 0; i < m; i++) {
            int size = queue.size();
            visited.clear();
            for (int j = 0; j < size; j++) {
                int s = queue.poll();
                int[] next = new int[] { flipAll(s, n), flipEven(s, n), flipOdd(s, n), flip3k1(s, n) };
                for (int s1 : next) {
                    if (!visited.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                }                
            }
        }
        
        return queue.size();        
    }
    
    private static int flipAll(int s, int n) {
        int x = (1 << n) - 1;
        return s ^ x;
    }
    
    private static int flipEven(int s, int n) {
        for (int i = 1; i < n; i += 2) {
            s ^= (1 << i);
        }
        return s;
    }
    
    private static int flipOdd(int s, int n) {
        for (int i = 0; i < n; i += 2) {
            s ^= (1 << i);
        }
        return s;
    }
    
    private static int flip3k1(int s, int n) {
        for (int i = 0; i < n; i += 3) {
            s ^= (1 << i);
        }
        return s;
    }
    
    /**
     * we have following cases (1 + 2 = 3, 1 + 3 = 2, 2 + 3 = 1)
     * 1, 2, 3, 4
     * 1 + 4, 2 + 4, 3 + 4
     * all on (total 8)
     */
    public static int solutionX(int n, int m) {
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            if (m == 1) {
                return 3;
            }
            else {
                return 4;
            }
        }
        if (m == 1) {
            return 4;
        }
        if (m == 2) {
            return 7;
        }
        return 8;   
    }
    
    public static void main(String[] args) {
        System.out.println(BulbSwitcherII.solution(1, 1));
        System.out.println(BulbSwitcherII.solution(2, 1));
        System.out.println(BulbSwitcherII.solution(3, 1));
    }
    

}
