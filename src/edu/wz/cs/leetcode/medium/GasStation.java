package edu.wz.cs.leetcode.medium;

/**
 * 134. Gas Station<br>
 * https://leetcode.com/problems/gas-station<br><br>
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].<br>
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.<br>
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.<br>
 * 
 * Note: The solution is guaranteed to be unique.
 */
public class GasStation {
    
    public static int solution(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int total = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = (i + 1) % n;
                sum = 0;
            }
        }
        
        if (total < 0) {
            return -1;
        }
        else {
            return start;
        }
    }
    
    public static void main(String[] args) {
        int[] gas = {1, 2, 5, 1, 0, 1};
        int[] cost = {1, 1, 1, 5, 1, 1};
        System.out.println(GasStation.solution(gas, cost));
    }

}
