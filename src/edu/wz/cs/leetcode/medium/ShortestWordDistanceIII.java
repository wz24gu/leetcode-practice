package edu.wz.cs.leetcode.medium;

/**
 * 245. Shortest Word Distance III<br>
 * https://leetcode.com/problems/shortest-word-distance-iii<br><br>
 * 
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.<br>
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the
 * list. word1 and word2 may be the same and they represent two individual words in the list.<br>
 * 
 * For example,<br> * 
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].<br>
 * Given word1 = “makes”, word2 = “coding”, return 1.<br>
 * Given word1 = "makes", word2 = "makes", return 3.<br>
 * 
 * Note: You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {
    
    public static int solution(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int n = words.length;
        int min = n;
        
        for (int i = 0; i < n; i++) {
            int t = p1;
            if (word1.equals(words[i])) {
                p1 = i;
            }
            if (word2.equals(words[i])) {
                p2 = i;
            }
            
            if (p1 != -1 && p2 != -1) {
                if (word1.equals(word2) && t != -1 && t != p1) {
                    min = Math.min(min, Math.abs(t - p2));
                }
                else if (p1 != p2) {
                    min = Math.min(min, Math.abs(p1 - p2));
                }
            }
        }
        
        return min;
    }
    
    public static int solutionX(String[] words, String word1, String word2) {
        int index = -1;
        int n = words.length;
        int min = n;
        
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1
                        && (word1.equals(word2) || !words[i].equals(words[index]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(ShortestWordDistanceIII.solution(words, "makes", "coding"));
        System.out.println(ShortestWordDistanceIII.solution(words, "makes", "makes"));
        
        System.out.println(ShortestWordDistanceIII.solutionX(words, "makes", "coding"));
        System.out.println(ShortestWordDistanceIII.solutionX(words, "makes", "makes"));
    }

}
