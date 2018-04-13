package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code<br>
 * https://leetcode.com/problems/gray-code<br><br>
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.<br>
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A 
 * gray code sequence must begin with 0.<br>
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:<br>
 * 00 - 0<br>
 * 01 - 1<br>
 * 11 - 3<br>
 * 10 - 2<br>
 * 
 * Note:<br>
 * 1. For a given n, a gray code sequence is not uniquely defined.<br>
 * 2. For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.<br>
 * 3. For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {    
    
    public static List<Integer> solution(int n) {
        List<Integer> result = new ArrayList<>();
        
        int len = (int) Math.pow(2, n);
        for (int i = 0; i < len; i++) {
            result.add((i >> 1) ^ i);  // gray code to binary  G = B / 2 XOR B
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(GrayCode.solution(2));
        System.out.println(GrayCode.solution(3));
    }

}
