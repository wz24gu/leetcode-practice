package edu.wz.cs.leetcode.easy;

/**
 * 717. 1-bit and 2-bit Characters<br>
 * https://leetcode.com/problems/1-bit-and-2-bit-characters<br><br>
 * 
 * We have two special characters. The first character can be represented by one bit 0. The second character can be 
 * represented by two bits (10 or 11).<br>
 * 
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or 
 * not. The given string will always end with a zero.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= len(bits) <= 1000.<br>
 * 2. bits[i] is always 0 or 1.
 */
public class OneBitAndTwoBitCharacters {
    
    public static boolean solution(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2;
            }
            else {
                i++;
            }
        }
        return i == n - 1;
    }
    
    public static void main(String[] args) {
        int[] bits = new int[] {1, 0, 0};
        System.out.println(OneBitAndTwoBitCharacters.solution(bits));
        
        int[] bits2 = new int[] {1, 1, 1, 0};
        System.out.println(OneBitAndTwoBitCharacters.solution(bits2));
    }

}
