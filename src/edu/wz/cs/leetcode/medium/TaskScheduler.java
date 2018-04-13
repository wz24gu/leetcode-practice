package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 621. Task Scheduler<br>
 * https://leetcode.com/problems/task-scheduler<br><br>
 * 
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters 
 * represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For 
 * each interval, CPU could finish one task or just be idle.<br>
 * 
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n 
 * intervals that CPU are doing different tasks or just be idle.<br>
 * 
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.<br><br>
 * 
 * Note:<br>
 * 1. The number of tasks is in the range [1, 10000].<br>
 * 2. The integer n is in the range [0, 100].
 */
public class TaskScheduler {
    
    public static int solution(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        Arrays.sort(count);
        
        int max = count[25];
        int i = 25;
        while (i >= 0 && count[i] == max) {
            i--;
        }
        
        return Math.max(tasks.length, (max - 1) * (n + 1) + 25 - i);
    }
    
    public static int solutionAlt(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.offer(new int[] {c, map.get(c)});
        }
        
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<int[]> tmp = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                int[] arr = pq.poll();
                arr[1]--;
                tmp.add(arr);
                k--;
                count++;
            }
            
            for (int[] t : tmp) {
                if (t[1] > 0) {
                    pq.offer(t);
                }
            }
            
            if (pq.isEmpty()) {
                break;
            }
            count += k;
        }
        
        return count;
    }
    
    
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(TaskScheduler.solution(tasks, 2));
        System.out.println(TaskScheduler.solutionAlt(tasks, 2));
    }

}
