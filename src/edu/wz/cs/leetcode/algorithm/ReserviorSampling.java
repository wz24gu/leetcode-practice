package edu.wz.cs.leetcode.algorithm;

import java.util.Random;

public class ReserviorSampling {
    
    public int sample(int[] nums) {
        int index = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }
        
        Random rand = new Random();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (rand.nextInt(i + 1) == 0) {  // random in [0, i]
                index = i;
            }
        }        
        return index;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ReserviorSampling reservior = new ReserviorSampling();
        for (int i = 0; i < 100; i++) {
            System.out.println(reservior.sample(nums));
        }
    }

}
