package edu.wz.cs.leetcode.medium;

/**
 * 418. Sentence Screen Fitting<br>
 * https://leetcode.com/problems/sentence-screen-fitting<br><br>
 * 
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given 
 * sentence can be fitted on the screen.<br><br>
 * 
 * Note:<br>
 * 1. A word cannot be split into two lines.<br>
 * 2. The order of words in the sentence must remain unchanged.<br>
 * 3. Two consecutive words in a line must be separated by a single space.<br>
 * 4. Total words in the sentence won't exceed 100.<br>
 * 5. Length of each word is greater than 0 and won't exceed 10.<br>
 * 6. 1 <= rows, cols <= 20,000.
 */
public class SentenceScreenFitting {
    
    public static int solution(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (String word : sentence) {
            sb.append(word).append(" ");
        }
        
        int start = 0;
        int len = sb.length();
        
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (sb.charAt(start % len) == ' ') {
                start++;
            }
            else {
                while (start > 0 && sb.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }            
        }
        
        return start / len;
    }
    
    public static void main(String[] args) {
        String[] sentence = {"hello", "world"};
        System.out.println(SentenceScreenFitting.solution(sentence, 2, 8));
        
        String[] sentence2 = {"a", "bcd", "e"};
        System.out.println(SentenceScreenFitting.solution(sentence2, 3, 6));
        
        String[] sentence3 = {"I", "had", "apple", "pie"};
        System.out.println(SentenceScreenFitting.solution(sentence3, 4, 5));
    }

}
