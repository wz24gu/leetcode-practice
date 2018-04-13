package edu.wz.cs.leetcode.easy;

import java.util.Random;

/**
 * 278. First Bad Version<br>
 * https://leetcode.com/problems/first-bad-version<br><br>
 * 
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version 
 * of your product fails the quality check. Since each version is developed based on the previous version, all the 
 * versions after a bad version are also bad.<br>
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the 
 * following ones to be bad.<br>
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to 
 * find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
    
    private static boolean isBadVersion(int version) {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static int solution(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
