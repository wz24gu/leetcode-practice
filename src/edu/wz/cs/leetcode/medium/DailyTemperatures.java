package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures<br>
 * https://leetcode.com/problems/daily-temperatures<br><br>
 * 
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would 
 * have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.<br>
 * 
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].<br>
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
    
    public static int[] solutoin(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < t) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                res[i] = 0;                
            }
            else {
                res[i] = stack.peek()[1] - i;
            }
            stack.push(new int[] {t, i});
        }
        
        return res;   
    }
    
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(DailyTemperatures.solutoin(temperatures)));
    }

}
