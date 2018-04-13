package edu.wz.cs.leetcode.medium;

/**
 * 670. Maximum Swap<br>
 * https://leetcode.com/problems/maximum-swap<br><br>
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the 
 * maximum valued number you could get.<br>
 * 
 * Note: The given number is in the range [0, 10^8]
 */
public class MaximumSwap {
    
    public static int solutionBruteForce(int num) {
        int result = num;
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                result = Math.max(result, Integer.parseInt(new String(arr)));
            }
        }
        return result;        
    }
    
    public static int solutionX(int num) {
        char[] res = String.valueOf(num).toCharArray();
        int n = res.length;
        
        char[] back = new char[n];
        int max = '0' - 1;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, res[i]);
            back[i] = (char) max;
        }
        
        for (int i = 0; i < n; i++) {
            if (res[i] == back[i]) {
                continue;
            }
            for (int j = n - 1; j > i; j--) {
                if (back[i] == res[j]) {
                    char c = res[i];
                    res[i] = res[j];
                    res[j] = c;
                    return Integer.parseInt(new String(res));
                }
            }
        }
        
        return Integer.parseInt(new String(res));
    }
    
    
    public static void main(String[] args) {
        System.out.println(MaximumSwap.solutionBruteForce(2736));
        System.out.println(MaximumSwap.solutionX(2736));
        
        System.out.println(MaximumSwap.solutionBruteForce(9973));
        System.out.println(MaximumSwap.solutionX(9973));
    }

}
