package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz<br/>
 * 
 * Write a program that outputs the string representation of numbers from 1 to n. But for multiples of 3 it should
 * output 'Fizz' instead of the number, and for the multiples of 5 output 'Buzz'. For numbers which are multiples of
 * both 3 and 5 output 'FizzBuzz'.
 */
public class FizzBuzz {
    
    public static List<String> solution(int n) {        
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            }
            else if (i % 5 == 0) {
                result.add("Buzz");
            }
            else if (i % 3 == 0) {
                result.add("Fizz");
            }
            else {
                result.add(i + "");
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(FizzBuzz.solution(15));
    }

}
