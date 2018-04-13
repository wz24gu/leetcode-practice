package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 500. Keyboard Row<br/>
 * 
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard like the image below.<br/><br/>
 * 
 * Note:<br/>
 * 1. You may use one character in the keyboard more than once.<br/>
 * 2. You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {
    
    public static String[] solution(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        
        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";        
        List<String> list = new ArrayList<>();
        
        
        for (String word : words) {            
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            
            for (char c : word.toCharArray()) {
                if (row1.contains(c + "")) {
                    count1 = 1;
                }
                else if (row2.contains(c + "")) {
                    count2 = 1;
                }
                else if (row3.contains(c + "")) {
                    count3 = 1;
                }
                
                if (count1 + count2 + count3 > 1) {
                    break;
                }
            }
            
            if (count1 + count2 + count3 == 1) {
                list.add(word);
            }
        }
        
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(KeyboardRow.solution(words)));
    }

}
