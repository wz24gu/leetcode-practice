package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number<br>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number<br><br>
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.<br>
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.<br>
 * 
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfPhoneNumber {
    
    public static List<String> solution(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, dict, 0, "", result);
        return result;
    }
    
    private static void backtrack(String digits, String[] dict, int k, String out, List<String> result) {
        if (k == digits.length()) {
            result.add(out);
            return;
        }
        
        String str = dict[digits.charAt(k) - '0'];
        for (int i = 0; i < str.length(); i++) {
            out += str.charAt(i);
            backtrack(digits, dict, k + 1, out, result);
            out = out.substring(0, out.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(LetterCombinationsOfPhoneNumber.solution("23"));
    }

}
