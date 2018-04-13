package edu.wz.cs.leetcode.medium;

/**
 * 481. Magical String<br>
 * https://leetcode.com/problems/magical-string<br><br>
 * 
 * A magical string S consists of only '1' and '2' and obeys the following rules:<br>
 * The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' 
 * generates the string S itself.<br>
 * 
 * The first few elements of string S is the following: S = "1221121221221121122 ..."<br>
 * If we group the consecutive '1's and '2's in S, it will be:<br>
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......<br>
 * and the occurrences of '1's or '2's in each group are:<br>
 * 1 2 2 1 1 2 1 2 2 1 2 2 ......<br>
 * You can see that the occurrence sequence above is the S itself.<br>
 * 
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.<br>
 * 
 * Note: N will not exceed 100,000.
 */
public class MagicalString {
    
    public static int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        
        int head = 2;
        int tail = 3;
        int num = 1;
        int result = 1;
        while (tail < n) {
            for (int i = 0; i < array[head]; i++) {
                array[tail] = num;
                if (num == 1 && tail < n) {
                    result++;
                }
                tail++;
            }
            num = num ^ 3;  // 1 ^ 3 = 2, 2 ^ 3 = 1
            head++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(MagicalString.solution(6));
    }

}
