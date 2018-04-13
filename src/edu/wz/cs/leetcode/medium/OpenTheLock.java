package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock<br>
 * https://leetcode.com/problems/open-the-lock<br><br>
 * 
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', 
 * '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
 * Each move consists of turning one wheel one slot.<br>
 * 
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.<br>
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock 
 * will stop turning and you will be unable to open it.<br>
 * 
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of 
 * turns required to open the lock, or -1 if it is impossible.<br><br>
 * 
 * Note:<br>
 * 1. The length of deadends will be in the range [1, 500].<br>
 * 2. target will not be in the list deadends.<br>
 * 3. Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 */
public class OpenTheLock {
    
    public static int solution(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        
        Set<String> visited = new HashSet<>();        
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int res = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (dead.contains(s)) {
                    continue;
                }
                
                if (s.equals(target)) {
                    return res;
                }
                
                StringBuilder sb = new StringBuilder(s);
                for (int j = 0; j < 4; j++) {
                    char c = sb.charAt(j);
                    String s1 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
                    String s2 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
                    
                    if (!visited.contains(s1) && !dead.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !dead.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }                
            }
            res++;            
        }
        
        return -1;
    }
    
    public static int solutionX(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        
        begin.add("0000");
        end.add(target);
        int res = 0;
        
        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) {
                    return res;
                }
                if (deads.contains(s)) {
                    continue;
                }
                deads.add(s);
                
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!deads.contains(s1)) {
                        tmp.add(s1);
                    }
                    if (!deads.contains(s2)) {
                        tmp.add(s2);
                    }                    
                }
            }
            res++;
            begin = end;
            end = tmp;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(OpenTheLock.solution(deadends, "0202"));
        System.out.println(OpenTheLock.solutionX(deadends, "0202"));
        
        String[] deadends2 = {"8888"};
        System.out.println(OpenTheLock.solution(deadends2, "0009"));
        System.out.println(OpenTheLock.solutionX(deadends2, "0009"));
        
        String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(OpenTheLock.solution(deadends3, "8888"));
        System.out.println(OpenTheLock.solutionX(deadends3, "8888"));
        
        String[] deadends4 = {"0000"};
        System.out.println(OpenTheLock.solution(deadends4, "8888"));
        System.out.println(OpenTheLock.solutionX(deadends4, "8888"));
    }

}
