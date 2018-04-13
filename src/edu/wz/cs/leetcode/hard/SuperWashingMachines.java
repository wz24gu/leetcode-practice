package edu.wz.cs.leetcode.hard;

/**
 * 517. Super Washing Machines<br>
 * 
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty. For each 
 * move, you could choose any m (1 <= m <= n) washing machines, and pass one dress of each washing machine to one of 
 * its adjacent washing machines at the same time.<br>
 * 
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, 
 * you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it 
 * is not possible to do it, return -1.<br><br>
 * 
 * Note:<br>
 * 1. The range of n is [1, 10000].<br>
 * 2. The range of dresses number in a super washing machine is [0, 1e5].
 */
public class SuperWashingMachines {
    
    public static int solution(int[] machines) {
        int n = machines.length;
        
        int total = 0;
        for (int m : machines) {
            total += m;
        }
        if (total == 0) {
            return 0;
        }
        if (total % n != 0) {
            return -1;
        }
        
        int res = 0;
        int avg = total / n;
        int[] move = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(machines[i] - avg);
            if (machines[i] > avg) {
                move[i] += diff;
                machines[i+1] += diff;
                machines[i] = avg;
                res = Math.max(res, move[i]);
            }
            else {
                move[i+1] = diff;
                machines[i+1] -= diff;
                machines[i] = avg;
                res = Math.max(res, move[i+1]);
            }
        }
        return res;
    }
    
    public static int solutionAlt(int[] machines) {
        if (machines == null) {
            throw new IllegalArgumentException();
        }
        
        int n = machines.length;
        int total = 0;
        for (int m : machines) {
            total += m;
        }
        if (total == 0) {
            return 0;
        }
        if (total % n != 0) {
            return -1;
        }
        
        int result = 0;
        int count = 0;
        int avg = total / n;
        for (int m : machines) {
            count += m - avg;
            result = Math.max(result, Math.max(Math.abs(count), m - avg));
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] machines = {0, 0, 11, 5};
        System.out.println(SuperWashingMachines.solution(machines));
        int[] machines2 = {0, 0, 11, 5};        
        System.out.println(SuperWashingMachines.solutionAlt(machines2));
    }

}
