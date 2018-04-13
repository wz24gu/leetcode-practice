package edu.wz.cs.leetcode.easy;

/**
 * 520. Detect Capital<br>
 * https://leetcode.com/problems/detect-capital<br><br>
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right or not. We define the usage of capitals
 * in a word to be right when one of the following cases holds:<br>
 * 
 * 1. All letters in this word are capitals, like "USA".<br>
 * 2. All letters in this word are not capitals, like "leetcode".<br>
 * 3. Only the first letter in this word is capital if it has more than one letter, like "Google".<br>
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.<br>
 * 
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
    
    public static boolean solution(String word) {
        return word.matches("[A-Z]+|[A-Z][a-z]+|[a-z]+");
    }
    
    public static boolean solutionAlt(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        
        char c1 = word.charAt(0);
        return count == 0
            || count == word.length()
            || count == 1 && c1 >= 'A' && c1 <= 'Z';
    }
    
    public static boolean solutionAlt2(String word) {
        boolean first = false;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            first = true;
        }
        
        int n = word.length();
        int lower = 0;
        int upper = 0;
        for (int i = 1; i < n; i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upper++;
            }
            else if (c >= 'a' && c <= 'z') {
                lower++;
            }
        }
        
        if (first) {
            return upper == 0 || lower == 0;
        }
        else {
            return upper == 0;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(DetectCapital.solution("USA"));
        System.out.println(DetectCapital.solution("FlaG"));
        System.out.println(DetectCapital.solution("Flag"));
        System.out.println(DetectCapital.solution("leetcode"));
        
        System.out.println(DetectCapital.solutionAlt("USA"));
        System.out.println(DetectCapital.solutionAlt("FlaG"));
        System.out.println(DetectCapital.solutionAlt("Flag"));
        System.out.println(DetectCapital.solutionAlt("leetcode"));
        
        System.out.println(DetectCapital.solutionAlt2("USA"));
        System.out.println(DetectCapital.solutionAlt2("FlaG"));
        System.out.println(DetectCapital.solutionAlt2("Flag"));
        System.out.println(DetectCapital.solutionAlt2("leetcode"));
    }

}
