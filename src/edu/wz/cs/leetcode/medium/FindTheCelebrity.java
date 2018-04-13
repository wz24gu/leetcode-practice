package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 277. Find the Celebrity<br>
 * https://leetcode.com/problems/find-the-celebrity<br><br>
 * 
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The 
 * definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.<br>
 * 
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do 
 * is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the 
 * celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).<br>
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int 
 * findCelebrity(n), your function should minimize the number of calls to knows.<br>
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a 
 * celebrity in the party. If there is no celebrity, return -1.
 */
public class FindTheCelebrity {
    
    public static boolean knows(int a, int b) {
        return false;
    }
    
    public static int solution(int n) {
        boolean[] candidate = new boolean[n];
        Arrays.fill(candidate, true);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (candidate[i] && i != j) {
                    if (knows(i, j) || !knows(j, i)) {
                        candidate[i] = false;
                        break;
                    }
                    else {
                        candidate[j] = false;
                    }
                }
            }
            if (candidate[i]) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int solutionX(int n) {
        int result = 0;
        
        // first pass, 0 to result-1 knows some one, result knows no one between result-1 and n-1, so he is the candidate
        for (int i = 0; i < n; i++) {
            if (knows(result, i)) {
                result = i;
            }
        }
        
        // second pass, check if result is the real celebrity
        for (int i = 0; i < n; i++) {
            if (result != i && (knows(result, i) || !knows(i, result))) {
                return -1;
            }
        }
        
        return result;
    }

}
