package edu.wz.cs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words<br>
 * https://leetcode.com/problems/unique-morse-code-words<br><br>
 * 
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as 
 * follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.<br>
 * 
 * For convenience, the full table for the 26 letters of the English alphabet is given below:<br>
 * [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
 * "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]<br>
 * 
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, 
 * "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a 
 * concatenation, the transformation of a word.<br>
 * 
 * Return the number of different transformations among all words we have.<br><br>
 * 
 * Note:<br>
 * 1. The length of words will be at most 100.<br>
 * 2. Each words[i] will have length in range [1, 12].<br>
 * 3. words[i] will only consist of lowercase letters.
 */
public class UniqueMorseCodeWords {
    
    public static int solution(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        
        String[] dict = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(dict[c - 'a']);
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
    
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(UniqueMorseCodeWords.solution(words));
    }

}
