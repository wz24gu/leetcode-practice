package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences<br>
 * https://leetcode.com/problems/repeated-dna-sequences<br><br>
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying 
 * DNA, it is sometimes useful to identify repeated sequences within the DNA.<br>
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 */
public class RepeatedDNASequences {
    
    public static List<String> solution(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        
        Set<Integer> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        int i = 0;
        int n = s.length();
        int mask = 0;
        while (i < 9) {
            mask = mask << 2 | map.get(s.charAt(i++)); 
        }
        
        while (i < n) {
            mask = ((mask & 0x3ffff) << 2 | map.get(s.charAt(i++)));
            if (set.contains(mask)) {
                res.add(s.substring(i - 10, i));
            }
            else {
                set.add(mask);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(RepeatedDNASequences.solution("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

}
