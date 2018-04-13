package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateAnagram {
    
    public List<String> anagram(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        backtrack(s, "", result);
        return result;
    }
    
    private void backtrack(String s, String out, List<String> result) {
        if (out.length() == s.length()) {
            result.add(new String(out));
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                if (out.contains(s.charAt(i) + "")) {
                    continue;
                }
                backtrack(s, out + s.charAt(i), result);
            }
        }
    }
    
    public static void main(String[] args) {
        GenerateAnagram anagram = new GenerateAnagram();
        System.out.println(anagram.anagram("ab"));
        System.out.println(anagram.anagram("ab").size());
    }

}
