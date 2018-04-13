package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 487. Max Consecutive Ones II<br>
 * https://leetcode.com/problems/max-consecutive-ones-ii<br><br>
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.<br>
 * 
 * Example 1: Input: [1,0,1,1,0]; Output: 4<br>
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s. After flipping, the maximum 
 * number of consecutive 1s is 4.<br><br>
 * 
 * Note:<br>
 * 1. The input array will only contain 0 and 1.<br>
 * 2. The length of input array is a positive integer and will not exceed 10,000<br>
 * 
 * Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all 
 * numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */
public class MaxConsecutiveOnesII {
    
    public static int solution(int[] nums) {
        int result = 0;
        int prev = 0;
        int curr = 0;
        for (int num : nums) {
            curr++;
            if (num == 0) {
                prev = curr;
                curr = 0;
            }
            result = Math.max(result, prev + curr);
        }
        return result;
    }
    
    public static int solutionX(int[] nums) {
        int result = 0;
        int k = 1;
        
        int left = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                queue.offer(right);
            }
            if (queue.size() > k) {
                left = queue.poll() + 1;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0};
        System.out.println(MaxConsecutiveOnesII.solution(nums));
        System.out.println(MaxConsecutiveOnesII.solutionX(nums));
    }

}
