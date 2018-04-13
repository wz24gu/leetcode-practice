package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 556. Next Greater Element III<br>
 * https://leetcode.com/problems/next-greater-element-iii<br><br>
 * 
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits 
 * existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to 
 * return -1.
 */
public class NextGreaterElementIII {
    
    public static int solution(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;
        int i;
        for (i = len - 1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                break;
            }
        }
        
        if (i == 0) {
            return -1;
        }
        
        for (int j = len - 1; j >= i; j--) {
            if (arr[j] > arr[i-1]) {
                char swap = arr[j];
                arr[j] = arr[i-1];
                arr[i-1] = swap;
                break;
            }
        }
        
        Arrays.sort(arr, i, arr.length);
        long result = Long.parseLong(new String(arr));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
    
    public static void main(String[] args) {
        System.out.println(NextGreaterElementIII.solution(12));
        System.out.println(NextGreaterElementIII.solution(21));
        System.out.println(NextGreaterElementIII.solution(12443322));
    }

}
