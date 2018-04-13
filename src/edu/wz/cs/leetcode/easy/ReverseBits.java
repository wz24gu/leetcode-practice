package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 190. Reverse Bits<br>
 * https://leetcode.com/problems/reverse-bits<br><br>
 * 
 * Reverse bits of a given 32 bits unsigned integer.<br>
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 
 * (represented in binary as 00111001011110000010100101000000).<br>
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    
    public static int solution(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {            
            result += (n & 1);
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }
    
    public static int solutionAlt(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }
    
    private Map<Byte, Integer> cache = new HashMap<>();
    
    public int solutionX(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) ((n >>> 8 * i) & 0xff);
        }
        
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result <<= 8;
            result += helper(bytes[i]);
        }
        return result;
    }
    
    private int helper(byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        
        int value = 0;
        for (int i = 0; i < 8; i++) {
            value <<= 1;
            value += ((b >>> i) & 1);            
        }
        cache.put(b, value);
        return value;
    }    
    
    public static void main(String[] args) {        
        System.out.println(ReverseBits.solution(1));
        System.out.println(ReverseBits.solution(43261596));
        
        ReverseBits reverse = new ReverseBits();
        System.out.println(reverse.solutionX(1));
        
        System.out.println(ReverseBits.solutionAlt(1));
    }

}
