package edu.wz.cs.leetcode.hard;

/**
 * 466. Count The Repetitions<br>
 * https://leetcode.com/problems/count-the-repetitions<br><br>
 * 
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".<br>
 * 
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 
 * such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be 
 * obtained from “acbbe”.<br>
 * 
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 <= n1 <= 10^6 and 
 * 1 <= n2 <= 10^6. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such 
 * that [S2,M] can be obtained from S1.
 */
public class CountTheRepetitions {
    
    public static int solution(String s1, int n1, String s2, int n2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = 0;
        
        while (count1 < n1) {
            if (arr1[i] == arr2[j]) {
                j++;
                if (j == arr2.length) {
                    j = 0;
                    count2++;
                }
            }
            
            i++;
            if (i == arr1.length) {
                i = 0;
                count1++;
            }
        }
        
        return count2 / n2;
    }
    
    // TODO:
    // https://leetcode.com/problems/count-the-repetitions/discuss/95408
    
    public static void main(String[] args) {
        System.out.println(CountTheRepetitions.solution("acb", 4, "ab", 2));
    }

}
