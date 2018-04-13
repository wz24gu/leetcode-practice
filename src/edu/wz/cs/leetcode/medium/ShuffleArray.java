package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array<br>
 * https://leetcode.com/problems/shuffle-an-array<br><br>
 * 
 * Shuffle a set of numbers without duplicates.
 */
public class ShuffleArray {
    
    private int[] nums;
    private int[] copy;
    private Random random;
    
    public ShuffleArray(int[] nums) {
        this.nums = nums;
        
        int n = nums.length;
        copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = copy[i];
        }
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = nums.length;
        for (int i = 0; i < n; i++) {            
            int j = random.nextInt(i + 1);  // random [0, i]
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }
        return nums;
    }
    
    public int[] shuffleAlt() {        
        int n = nums.length;
        for (int i = 0; i < n; i++) {            
            int j = random.nextInt(n - i) + i;  // random [i, n-1]
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray shuffleArray = new ShuffleArray(nums);
        System.out.println(Arrays.toString(shuffleArray.shuffle()));
        System.out.println(Arrays.toString(shuffleArray.shuffleAlt()));
        System.out.println(Arrays.toString(shuffleArray.reset()));
    }

}
