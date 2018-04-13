package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 539. Minimum Time Difference<br>
 * https://leetcode.com/problems/minimum-time-difference<br><br>
 * 
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any 
 * two time points in the list.<br><br>
 * 
 * Note:<br>
 * 1. The number of time points in the given list is at least 2 and won't exceed 20000.<br>
 * 2. The input time is legal and ranges from 00:00 to 23:59.
 */
public class MinimumTimeDifference {
    
    public static int solution(List<String> times) {
        Collections.sort(times);
        
        int result = Integer.MAX_VALUE;
        int diff = 0;
        int n = times.size();
        for (int i = 0; i < n; i++) {
            String t1 = times.get(i);
            String t2 = times.get((i + 1) % n);
            
            String[] fields1 = t1.split(":");
            int h1 = Integer.parseInt(fields1[0]);
            int m1 = Integer.parseInt(fields1[1]);
            String[] fields2 = t2.split(":");
            int h2 = Integer.parseInt(fields2[0]);
            int m2 = Integer.parseInt(fields2[1]);
            
            diff = (h2 - h1) * 60 + (m2 - m1);
            if (i == n - 1) {
                diff += 24 * 60;
            }
            result = Math.min(result, diff);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<String> times = new ArrayList<>();
        times.add("23:59");
        times.add("00:00");
        System.out.println(MinimumTimeDifference.solution(times));
    }

}
