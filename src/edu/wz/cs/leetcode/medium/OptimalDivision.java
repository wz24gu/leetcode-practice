package edu.wz.cs.leetcode.medium;

/**
 * 553. Optimal Division<br>
 * https://leetcode.com/problems/optimal-division<br><br>
 * 
 * Given a list of positive integers, the adjacent integers will perform the float division. For example,
 * [2,3,4] -> 2 / 3 / 4. However, you can add any number of parenthesis at any position to change the priority of
 * operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding
 * expression in string format. Your expression should NOT contain redundant parenthesis.<br><br>
 * 
 * Note:<br>
 * 1. The length of the input array is [1, 10].<br>
 * 2. Elements in the given array will be in range [2, 1000].<br>
 * 3. There is only one optimal division for each test case.
 */
public class OptimalDivision {
    
    // x1/(x2/x3/x4 ...) will always be the largest
    public static String solutionX(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return nums[0] + "";
        }
        else if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]).append("/(");
            for (int i = 1; i < n - 1; i++) {
                sb.append(nums[i]).append("/");
            }
            sb.append(nums[n-1]).append(")");
            
            return sb.toString();
        }
    }
    
    private static class Result {
        public String str;
        public double val;
    }
    
    public static String solution(int[] nums) {
        Result result = getMax(nums, 0, nums.length - 1);
        return result.str;
    }
    
    private static Result getMax(int[] nums, int lo, int hi) {
        Result result = new Result();
        result.val = Double.NEGATIVE_INFINITY;
        
        if (hi == lo) {
            result.str = nums[lo] + "";
            result.val = (double) nums[lo];
        }
        else if (hi - lo == 1) {
            result.str = nums[lo] + "/" + nums[hi];
            result.val = (double) nums[lo] / (double) nums[hi];
        }
        else {
            for (int i = lo; i < hi; i++) {
                Result r1 = getMax(nums, lo, i);
                Result r2 = getMin(nums, i + 1, hi);
                double val = r1.val / r2.val;
                if (result.val < val) {
                    if (hi - i > 1) {
                        result.str = r1.str + "/(" + r2.str + ")";
                    }
                    else {
                        result.str = r1.str + "/" + r2.str;
                    }
                    result.val = val;
                }
            }
        }
        
        return result;
    }
    
    public static Result getMin(int[] nums, int lo, int hi) {
        Result result = new Result();
        result.val = Double.POSITIVE_INFINITY;
        
        if (hi == lo) {
            result.str = nums[lo] + "";
            result.val = (double) nums[lo];
        }
        else if (hi - lo == 1) {
            result.str = nums[lo] + "/" + nums[hi];
            result.val = (double) nums[lo] / (double) nums[hi];
        }
        else {
            for (int i = lo; i < hi; i++) {
                Result r1 = getMin(nums, lo, i);
                Result r2 = getMax(nums, i + 1, hi);
                double val = r1.val / r2.val;
                if (result.val > val) {
                    if (hi - i > 1) {
                        result.str = r1.str + "/(" + r2.str + ")";
                    }
                    else {
                        result.str = r1.str + "/" + r2.str;
                    }
                    result.val = val;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1000, 100, 10, 2};
        System.out.println(OptimalDivision.solutionX(nums));
        System.out.println(OptimalDivision.solution(nums));
    }

}
