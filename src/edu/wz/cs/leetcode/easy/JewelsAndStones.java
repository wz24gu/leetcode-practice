package edu.wz.cs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones<br>
 * https://leetcode.com/problems/jewels-and-stones<br><br>
 * 
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have. 
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.<br>
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so 
 * "a" is considered a different type of stone from "A".<br><br>
 * 
 * Note:<br>
 * 1. S and J will consist of letters and have length at most 50.<br>
 * 2. The characters in J are distinct.
 */
public class JewelsAndStones {
    
    public static int solution(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        
        int count = 0;
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(JewelsAndStones.solution("aA", "aAAbbbb"));
        System.out.println(JewelsAndStones.solution("z", "ZZ"));
    }

}
