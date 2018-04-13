package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 582. Kill Process<br>
 * https://leetcode.com/problems/kill-process<br><br>
 * 
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).<br>
 * 
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree 
 * structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will 
 * be distinct positive integers.<br>
 * 
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and 
 * the second list contains the corresponding PPID.<br>
 * 
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that 
 * will be killed in the end. You should assume that when a process is killed, all its children processes will be 
 * killed. No order is required for the final answer.<br><br>
 * 
 * Note:<br>
 * 1. The given kill id is guaranteed to be one of the given PIDs.<br>
 * 2. n >= 1.
 */
public class KillProcess {

    public static List<Integer> solution(int[] pid, int[] ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.length; i++) {
            if (!map.containsKey(ppid[i])) {
                map.put(ppid[i], new ArrayList<Integer>());
            }
            map.get(ppid[i]).add(pid[i]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            result.add(n);
            if (map.containsKey(n)) {
                queue.addAll(map.get(n));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] pid = {1, 3, 10, 5};
        int[] ppid = {3, 0, 5, 3};
        System.out.println(KillProcess.solution(pid, ppid, 5));
        System.out.println(KillProcess.solution(pid, ppid, 3));
    }

}
