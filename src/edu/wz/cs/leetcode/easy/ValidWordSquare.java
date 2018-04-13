package edu.wz.cs.leetcode.easy;

/**
 * 422. Valid Word Square<br>
 * https://leetcode.com/problems/valid-word-square<br><br>
 * 
 * Given a sequence of words, check whether it forms a valid word square.<br>
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 
 * 0 <= k < max (numRows, numColumns).<br><br>
 * 
 * Note:<br>
 * 1. The number of words given is at least 1 and does not exceed 500.<br>
 * 2. Word length will be at least 1 and does not exceed 500.<br>
 * 3. Each word contains only lowercase English alphabet a-z.
 */
public class ValidWordSquare {

    public static boolean solution(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words.length || i >= words[j].length()
                        || words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean solutionAlt(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (words[j].length() > i) {
                    sb.append(words[j].charAt(i));
                }
            }
            if (!word.equals(sb.toString())) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] words = { "abcd",
                           "bnrt",
                           "crmy",
                           "dtye" };
        System.out.println(ValidWordSquare.solution(words));
        System.out.println(ValidWordSquare.solutionAlt(words));
        
        String[] words1 = { "abcd",
                            "bnrt",
                            "crm",
                            "dt" };
        System.out.println(ValidWordSquare.solution(words1));
        System.out.println(ValidWordSquare.solutionAlt(words1));
        
        String[] words2 = { "ball",
                            "area",
                            "read",
                            "lady" };
        System.out.println(ValidWordSquare.solution(words2));
        System.out.println(ValidWordSquare.solutionAlt(words2));
    }

}
