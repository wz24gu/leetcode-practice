package edu.wz.cs.leetcode.medium;

/**
 * 738. Monotone Increasing Digits<br>
 * https://leetcode.com/problems/monotone-increasing-digits<br><br>
 * 
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.<br>
 * 
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)<br>
 * 
 * N is an integer in the range [0, 10^9].
 */
public class MonotoneIncreasingDigits {
    
    public static int solution(int N) {
        char[] arr = String.valueOf(N).toCharArray();
        int n = arr.length;
        int j = n;        
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] < arr[i-1]) {
                arr[i-1]--;
                j = i;
            }
        }
        while (j < n) {
            arr[j++] = '9';
        }
        
        return Integer.parseInt(new String(arr));
    }
    
    public static void main(String[] args) {
        System.out.println(MonotoneIncreasingDigits.solution(10));
        System.out.println(MonotoneIncreasingDigits.solution(1234));
        System.out.println(MonotoneIncreasingDigits.solution(332));
    }

}
