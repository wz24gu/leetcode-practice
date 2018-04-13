package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 564. Find the Closest Palindrome<br>
 * https://leetcode.com/problems/find-the-closest-palindrome<br><br>
 * 
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.<br>
 * 
 * The 'closest' is defined as absolute difference minimized between two integers.<br><br>
 * 
 * Note:<br>
 * 1. The input n is a positive integer represented by string, whose length will not exceed 18.<br>
 * 2. If there is a tie, return the smaller one as answer.
 */
public class FindClosestPalindrome {
    
    public static String solution(String n) {
        long number = Long.parseLong(n);
        long big = findHigherPalindrome(number + 1);
        long small = findLowerPalindrome(number - 1);
        return Math.abs(number - small) < Math.abs(big - number) ? String.valueOf(small) : String.valueOf(big);
    }
    
    private static long findHigherPalindrome(long limit) {
        char[] arr = String.valueOf(limit).toCharArray();
        int n = arr.length;
        
        char[] target = Arrays.copyOf(arr, n);
        for (int i = 0; i < n / 2; i++) {
            target[n-1-i] = target[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] < target[i]) {
                return Long.parseLong(new String(target));
            }
            else if (arr[i] > target[i]) {
                for (int j = (n - 1) / 2; j >= 0; j--) {
                    if (target[j] + 1 > '9') {
                        target[j] = 0;
                    }
                    else {
                        target[j]++;
                        break;
                    }
                }
                for (int k = 0; k < n / 2; k++) {
                    target[n-1-k] = target[k];
                }
                return Long.parseLong(new String(target));
            }
        }
        
        return Long.parseLong(new String(target));
    }
    
    private static long findLowerPalindrome(long limit) {
        char[] arr = String.valueOf(limit).toCharArray();
        int n = arr.length;
        
        char[] target = Arrays.copyOf(arr, n);
        for (int i = 0; i < n / 2; i++) {
            target[n-1-i] = target[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > target[i]) {
                return Long.parseLong(new String(target));
            }
            else if (arr[i] < target[i]) {
                for (int j = (n - 1) / 2; j >= 0; j--) {
                    if (target[j] - 1 < '0') {
                        target[j] = '9';
                    }
                    else {
                        target[j]--;
                        break;
                    }                    
                }
                if (target[0] == '0') {
                    char[] t = new char[n - 1];
                    Arrays.fill(t, '9');
                    return Long.parseLong(new String(t));
                }
                for (int k = 0; k < n / 2; k++) {
                    target[n-1-k] = target[k];
                }
                return Long.parseLong(new String(target));
            }
        }
        
        return Long.parseLong(new String(target));
    }
    
    public static String solutionX(String n) {
        int len = n.length();
        if (len == 1) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }
        
        List<Long> candidates = new ArrayList<>();
        candidates.add(getAllNine(len));
        candidates.add(getAllNine(len - 1));
        candidates.add(getOneZero(len));
        candidates.add(getOneZero(len + 1));        
        
        long half = Long.parseLong(n.substring(0, (len + 1) / 2));
        addCandidates(candidates, half, len);
        addCandidates(candidates, half - 1, len);
        addCandidates(candidates, half + 1, len);
        
        long num = Long.parseLong(n);
        long diff = Long.MAX_VALUE;
        long res = num;
        Collections.sort(candidates);
        for (long candidate : candidates) {
            if (num == candidate) {
                continue;
            }
            if (Math.abs(candidate - num) < diff) {
                diff = Math.abs(candidate - num);
                res = candidate;
            }
        }
        
        return String.valueOf(res);        
    }
    
    private static void addCandidates(List<Long> candidates, long half, int len) {
        String left = String.valueOf(half);
        if (len % 2 == 0) {            
            left += new StringBuilder(left).reverse().toString();            
        }
        else {
            StringBuilder sb = new StringBuilder(left.substring(0, left.length() - 1));
            left += sb.reverse().toString();
        }
        candidates.add(Long.parseLong(left));
    }
    
    private static Long getAllNine(int n) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = res * 10 + 9;
        }
        return res;
    }
    
    private static Long getOneZero(int n) {
        return (long) (Math.pow(10, n - 1) + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(FindClosestPalindrome.solution("123"));
        System.out.println(FindClosestPalindrome.solution("101"));
        System.out.println(FindClosestPalindrome.solution("98"));
        System.out.println(FindClosestPalindrome.solution("99"));
        System.out.println(FindClosestPalindrome.solution("102"));
        
        System.out.println(FindClosestPalindrome.solutionX("123"));
        System.out.println(FindClosestPalindrome.solutionX("101"));
        System.out.println(FindClosestPalindrome.solutionX("98"));
        System.out.println(FindClosestPalindrome.solutionX("99"));
        System.out.println(FindClosestPalindrome.solutionX("102"));
    }

}
