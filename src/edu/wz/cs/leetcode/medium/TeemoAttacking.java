package edu.wz.cs.leetcode.medium;

/**
 * 495. Teemo Attacking<br>
 * https://leetcode.com/problems/teemo-attacking<br><br>
 * 
 * In LLP world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now,
 * given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking,
 * you need to output the total time that Ashe is in poisoned condition.<br>
 * 
 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned
 * condition immediately.<br><br>
 * 
 * Note:<br>
 * 1. You may assume the length of given time series array won't exceed 10000.<br>
 * 2. You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are
 * non-negative integers, which won't exceed 10,000,000.
 */
public class TeemoAttacking {
    
    public static int solution(int[] times, int duration) {
        if (times == null || times.length == 0) {
            return 0;
        }
        
        int sum = duration;  // this is for the last attack
        for (int i = 1; i < times.length; i++) {
            if (times[i] - times[i-1] < duration) {
                sum += times[i] - times[i-1];
            }
            else {
                sum += duration;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] times = {1, 4};
        System.out.println(TeemoAttacking.solution(times, 2));
        
        int[] times2 = {1, 2};
        System.out.println(TeemoAttacking.solution(times2, 2));
    }

}
