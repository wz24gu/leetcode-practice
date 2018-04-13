package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. Asteroid Collision<br>
 * https://leetcode.com/problems/asteroid-collision<br><br>
 * 
 * We are given an array asteroids of integers representing asteroids in a row.<br>
 * 
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning 
 * right, negative meaning left). Each asteroid moves at the same speed.<br>
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both 
 * are the same size, both will explode. Two asteroids moving in the same direction will never meet.<br><br>
 * 
 * Note:<br>
 * 1. The length of asteroids will be at most 10000.<br>
 * 2. Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class AsteroidCollision {
    
    public static int[] solution(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            int a = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(a);
                continue;
            }
            
            int last = stack.peek();
            if (last > 0 && a > 0 || last < 0 && a < 0 || last < 0 && a > 0) {
                stack.push(a);
            }
            else if (Math.abs(last) > Math.abs(a)) {
                continue;
            }
            else if (Math.abs(last) < Math.abs(a)) {
                stack.pop();
                i--;
            }
            else {
                stack.pop();
            }
        }
        
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(AsteroidCollision.solution(asteroids)));
        
        int[] asteroids2 = {8, -8};
        System.out.println(Arrays.toString(AsteroidCollision.solution(asteroids2)));
        
        int[] asteroids3 = {10, 2, -5};
        System.out.println(Arrays.toString(AsteroidCollision.solution(asteroids3)));
        
        int[] asteroids4 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(AsteroidCollision.solution(asteroids4)));
    }

}
