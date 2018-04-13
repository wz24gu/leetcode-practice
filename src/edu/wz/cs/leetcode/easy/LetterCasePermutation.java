package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation<br>
 * https://leetcode.com/problems/letter-case-permutation<br><br>
 * 
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
 * Return a list of all possible strings we could create.<br><br>
 * 
 * Note:<br>
 * S will be a string with length at most 12.<br>
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {
    
    public static List<String> solution(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toLowerCase().toCharArray(), 0, res);
        return res;
    }
    
    private static void backtrack(char[] arr, int pos, List<String> res) {
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        
        backtrack(arr, pos + 1, res);
        if (arr[pos] >= 'a' && arr[pos] <= 'z') {
            arr[pos] = (char) (arr[pos] - 'a' + 'A');
            backtrack(arr, pos + 1, res);
            arr[pos] = (char) (arr[pos] - 'A' + 'a');
        }
    }
    
    public static void main(String[] args) {
        System.out.println(LetterCasePermutation.solution("a1b2"));
        System.out.println(LetterCasePermutation.solution("3z4"));
        System.out.println(LetterCasePermutation.solution("12345"));
    }

}
