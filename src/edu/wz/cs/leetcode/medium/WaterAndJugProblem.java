package edu.wz.cs.leetcode.medium;

/**
 * 365. Water and Jug Problem<br>
 * https://leetcode.com/problems/water-and-jug-problem<br><br>
 * 
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need 
 * to determine whether it is possible to measure exactly z litres using these two jugs.<br>
 * 
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.<br>
 * 
 * Operations allowed:<br>
 * 1. Fill any of the jugs completely with water.<br>
 * 2. Empty any of the jugs.<br>
 * 3. Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 */
public class WaterAndJugProblem {
    
    public static boolean solution(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (z > x + y) {
            return false;
        }
        
        return z % gcd(x, y) == 0;   
    }
    
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println(WaterAndJugProblem.solution(5, 3, 4));
    }

}
