package edu.wz.cs.leetcode.hard;

/**
 * 420. Strong Password Checker<br>
 * https://leetcode.com/problems/strong-password-checker<br><br>
 * 
 * A password is considered strong if below conditions are all met:<br>
 * 1. It has at least 6 characters and at most 20 characters.<br>
 * 2. It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.<br>
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming 
 * other conditions are met).<br>
 * 
 * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to 
 * make s a strong password. If s is already strong, return 0.<br>
 * 
 * Insertion, deletion or replace of any one character are all considered as one change.
 */
public class StrongPasswordChecker {
    
    public static int solution(String s) {
        int result = 0;
        int a = 1;
        int A = 1;
        int d = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];
        
        for (int i = 0; i < arr.length; ) {
            if (Character.isLowerCase(carr[i])) {
                a = 0;
            }
            if (Character.isUpperCase(carr[i])) {
                A = 0;
            }
            if (Character.isDigit(carr[i])) {
                d = 0;
            }
            
            int j = i;
            while (i < carr.length && carr[i] == carr[j]) {
                i++;  // this will always move since j = i originally
            }
            arr[j] = i - j;
        }
        
        int total_missing = a + A + d;
        
        if (arr.length < 6) {
            result += total_missing + Math.max(0, 6 - (arr.length + total_missing));
        }
        else {
            int over_len = Math.max(arr.length - 20, 0);
            int left_over = 0;
            result += over_len;
            
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && over_len > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != k - 1) {
                        continue;
                    }
                    arr[i] -= Math.min(over_len, k);
                    over_len -= k;
                }
            }
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && over_len > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over_len;
                    over_len -= need;
                }
                if (arr[i] >= 3) {
                    left_over += arr[i] / 3;
                }
            }
            
            result += Math.max(total_missing, left_over);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(StrongPasswordChecker.solution("aaa"));
        System.out.println(StrongPasswordChecker.solution("aaa1a"));
        System.out.println(StrongPasswordChecker.solution("abc"));
    }

}
