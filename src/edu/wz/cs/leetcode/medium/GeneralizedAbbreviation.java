package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 320. Generalized Abbreviation<br>
 * https://leetcode.com/problems/generalized-abbreviation<br><br>
 * 
 * Write a function to generate the generalized abbreviations of a word.
 */
public class GeneralizedAbbreviation {
    
    public static List<String> solution(String word) {
        List<String> result = new ArrayList<>();
        int n = word.length();
        int size = (int) Math.pow(2, n);
        
        for (int i = 0; i < size; i++) {
            String out = "";
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    count++;
                }
                else {
                    if (count != 0) {
                        out += count;
                        count = 0;
                    }
                    out += word.charAt(j);
                }
            }
            
            if (count > 0) {
                out += count;
            }
            result.add(out);
        }
        
        return result;
    }
    
    public static List<String> solutionAlt(String word) {
        List<String> result = new ArrayList<>();        
        helper(word, 0, 0, "", result);
        return result;
    }
    
    private static void helper(String word, int pos, int count, String out, List<String> result) {
        if (pos == word.length()) {
            if (count > 0) {
                out += count;
            }
            result.add(out);
        }
        else {
            helper(word, pos + 1, count + 1, out, result);
            helper(word, pos + 1, 0, out + (count > 0 ? count : "") + word.charAt(pos), result);
        }
    }
    
    // this implementation may be wrong
    public static List<String> solutionAlt2(String word) {
        List<String> result = new ArrayList<>();
        helper(word, 0, result);
        return result;
    }
    
    private static void helper(String word, int pos, List<String> result) {
        int n = word.length();
        for (int i = pos; i < n; i++) {
            for (int j = 1; i + j <= n; j++) {
                String out = word.substring(0, i) + j + word.substring(i + j);
                result.add(out);
                helper(out, i + 1 + String.valueOf(j).length(), result);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(GeneralizedAbbreviation.solution("word"));
        System.out.println(GeneralizedAbbreviation.solutionAlt("word"));
        System.out.println(GeneralizedAbbreviation.solutionAlt2("word"));
    }

}
