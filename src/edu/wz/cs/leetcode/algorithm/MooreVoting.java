package edu.wz.cs.leetcode.algorithm;

public class MooreVoting {
    
    public int majority(int[] nums) {
        int result = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int count = 0;
        for (int num : nums) {
            if (num == result) {
                count++;
            }
            else if (count == 0) {
                result = num;
                count = 1;
            }
            else {
                count--;
            }
        }
        
        int sum = 0;
        for (int num : nums) {
            if (num == result) {
                sum++;
            }
        }
        if (sum > nums.length / 2) {
            return result;
        }
        return -1;        
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 6, 6};
        MooreVoting moore = new MooreVoting();
        System.out.println(moore.majority(nums));
    }

}
