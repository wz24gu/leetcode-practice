package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer<br>
 * https://leetcode.com/problems/roman-to-integer<br><br>
 * 
 * Given a Roman numeral, convert it to an integer.<br>
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    
    public static int solution(String s) {        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) {
                result += map.get(s.charAt(i));
            }
            else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(RomanToInteger.solution("IX"));
        System.out.println(RomanToInteger.solution("XIV"));
        System.out.println(RomanToInteger.solution("VIII"));
    }

}
