package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II<br>
 * https://leetcode.com/problems/next-greater-element-ii<br><br>
 * 
 * Given a circular array (the next element of the last element is the first element of the array), print the Next 
 * Greater Number for every element. The Next Greater Number of a number x is the first greater number to its 
 * traversing-order next in the array, which means you could search circularly to find its next greater number. If it 
 * doesn't exist, output -1 for this number.<br>
 * 
 * Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementII {
    
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > nums[i]) {
                    result[i] = nums[j % n];
                    break;
                }
            }
        }
        
        return result;
    }
    
    // typical way to solve circular array, double its size
    public static int[] solutionAlt(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n * 2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i % n];
        }
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n * 2; j++) {
                if (temp[j] > nums[i]) {
                    result[i] = temp[j];
                    break;
                }
            }
        }
        
        return result;
    }
    
    // another typical way to solve circular array, use stack
    public static int[] solutionX(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(NextGreaterElementII.solution(nums)));
        System.out.println(Arrays.toString(NextGreaterElementII.solutionAlt(nums)));
        System.out.println(Arrays.toString(NextGreaterElementII.solutionX(nums)));
    }

}
