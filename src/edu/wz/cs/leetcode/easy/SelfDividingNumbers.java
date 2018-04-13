package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. Self Dividing Numbers<br/>
 * https://leetcode.com/problems/self-dividing-numbers<br/><br/>
 * 
 * A self-dividing number is a number that is divisible by every digit it contains.<br/>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.<br/>
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.<br/>
 * 
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if 
 * possible.<br/>
 * 
 * Note: The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers {
    
    public static List<Integer> solution(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left > right) {
            return result;
        }
        
        outer:
        for (int i = left; i <= right; i++) {
            int num = i;  // tricky, need a copy of i, otherwise i will be reset to 0 in the while loop
            while (num > 0) {
                int d = num % 10;
                if (d == 0 || i % d != 0) {
                    continue outer;
                }
                num /= 10;
            }
            result.add(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(SelfDividingNumbers.solution(1, 22));
    }

}
