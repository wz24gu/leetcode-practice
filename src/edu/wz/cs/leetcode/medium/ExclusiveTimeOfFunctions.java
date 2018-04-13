package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions<br>
 * https://leetcode.com/problems/exclusive-time-of-functions<br><br>
 * 
 * Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU, find the exclusive 
 * time of these functions.<br>
 * 
 * Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.<br>
 * 
 * A log is a string has this format : function_id:start_or_end:timestamp. For example, "0:start:0" means function 0 
 * starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.<br>
 * 
 * Exclusive time of a function is defined as the time spent within this function, the time spent by calling other 
 * functions should not be considered as this function's exclusive time. You should return the exclusive time of each 
 * function sorted by their function id.<br><br>
 * 
 * Note:<br>
 * 1. Input logs will be sorted by timestamp, NOT log id.<br>
 * 2. Your output should be sorted by function id, which means the 0th element of your output corresponds to the 
 * exclusive time of function 0.<br>
 * 3. Two functions won't start or end at the same time.<br>
 * 4. Functions could be called recursively, and will always end.
 * 5. 1 <= n <= 100
 */
public class ExclusiveTimeOfFunctions {
    
    public static int[] solution(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int preTime = 0;
        
        for (String log : logs) {
            String[] fields = log.split(":");
            int index = Integer.parseInt(fields[0]);
            String type = fields[1];
            int time = Integer.parseInt(fields[2]);
            
            if (!stack.isEmpty()) {
                result[stack.peek()] += time - preTime;
            }
            preTime = time;
            
            if ("start".equals(type)) {
                stack.push(index);
            }
            else {
                int out = stack.pop();
                result[out]++;
                preTime++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] logs = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        System.out.println(Arrays.toString(ExclusiveTimeOfFunctions.solution(2, Arrays.asList(logs))));
    }

}
