package edu.wz.cs.leetcode.hard;

/**
 * 765. Couples Holding Hands<br>
 * https://leetcode.com/problems/couples-holding-hands<br><br>
 * 
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so 
 * that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch 
 * seats.<br>
 * 
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple 
 * being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).<br>
 * 
 * The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.<br><br>
 * 
 * Note:<br>
 * 1. len(row) is even and in the range of [4, 60].<br>
 * 2. row is guaranteed to be a permutation of 0...len(row)-1.
 */
public class CouplesHoldingHands {
    
    public static int solution(int[] row) {
        int res = 0;
        
        int n = row.length;
        int[] ptn = new int[n];
        int[] pos = new int[n];
        
        for (int i = 0; i < n; i++) {
            ptn[i] = i % 2 == 0 ? i + 1 : i - 1;
            pos[row[i]] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                res++;
            }
        }
        return res;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        System.out.println(CouplesHoldingHands.solution(row));
        
        int[] row2 = {3, 2, 0, 1};
        System.out.println(CouplesHoldingHands.solution(row2));
    }

}
