package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 267. Palindrome Permutation II<br>
 * https://leetcode.com/problems/palindrome-permutation-ii<br><br>
 * 
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no 
 * palindromic permutation could be form.<br>
 * 
 * For example:<br>
 * Given s = "aabb", return ["abba", "baab"].<br>
 * Given s = "abc", return [].
 */
public class PalindromePermutationII {
    
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder t = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        for (char c : map.keySet()) {
            if (map.get(c) % 2== 0) {
                int freq = map.get(c) / 2;
                for (int i = 0; i < freq; i++) {
                    t.append(c);
                }
            }
            else {
                mid.append(c);
            }
        }
        
        if (mid.length() > 1) {
            return result;
        }
        
        generate(t.toString().toCharArray(), 0, mid.toString(), result);
        return result;
    }
    
    private static void generate(char[] arr, int start, String mid, List<String> result) {
        int n = arr.length;
        
        if (start >= n) {
            String s = new String(arr);
            result.add(s + mid + new StringBuilder(s).reverse().toString());
        }
        
        for (int i = start; i < n; i++) {
            if (i != start && arr[i] == arr[start]) {
                continue;
            }
            exchange(arr, i, start);
            generate(arr, start + 1, mid, result);
            exchange(arr, i, start);
        }
    }
    
    private static void exchange(char[] arr, int i, int j) {
        char swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
    
    public static void main(String[] args) {
        System.out.println(PalindromePermutationII.solution("aabb"));
        System.out.println(PalindromePermutationII.solution("abc"));
    }
    
}
