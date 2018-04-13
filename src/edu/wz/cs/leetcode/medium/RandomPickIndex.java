package edu.wz.cs.leetcode.medium;

import java.util.Random;

/**
 * 398. Random Pick Index<br>
 * https://leetcode.com/problems/random-pick-index<br><br>
 * 
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can 
 * assume that the given target number must exist in the array.<br>
 * 
 * Note: The array size can be very large. Solution that uses too much extra space will not pass the judge.
 */
public class RandomPickIndex {
    
    private int[] nums;
    private Random rand;
    
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    // reservior sampling
    public int pick(int target) {
        int res = -1;
        int count = 0;        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    res = i;
                }
            }
        }        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex randomPick = new RandomPickIndex(nums);
        System.out.println(randomPick.pick(3));
    }

}
