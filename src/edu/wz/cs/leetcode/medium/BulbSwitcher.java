package edu.wz.cs.leetcode.medium;

/**
 * 319. Bulb Switcher<br>
 * https://leetcode.com/problems/bulb-switcher<br><br>
 * 
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. 
 * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith 
 * round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after 
 * n rounds.
 */
public class BulbSwitcher {
    
    public static int solution(int n) {
        int count = 0;
        int i = 1;
        while (i * i <= n) {
            count++;
            i++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(BulbSwitcher.solution(5));
    }

}
