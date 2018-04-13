package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification<br>
 * https://leetcode.com/problems/text-justification<br><br>
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully 
 * (left and right) justified.<br>
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra 
 * spaces ' ' when necessary so that each line has exactly L characters.<br>
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not 
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.<br>
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.<br>
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {
    
    public static List<String> solution(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        int n = words.length;
        int i = 0;
        while (i < n) {
            int j = i;
            int len = 0;
            while (j < n && len + words[j].length() + j - i <= maxWidth) {
                len += words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            int space = maxWidth - len;
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (space > 0) {
                    int insert = 0;
                    if (j == n) {  // last line
                        if (j - k == 1) {  // last word
                            insert = space;
                        }
                        else {
                            insert = 1;
                        }
                    }
                    else {
                        if (j - k == 1) {
                            insert = space;
                        }                        
                        else {
                            if (space % (j - k - 1) == 0) {
                                insert = space / (j - k - 1);
                            }
                            else {
                                insert = space / (j - k - 1) + 1;
                            }
                        }
                    }
                    
                    for (int t = 0; t < insert; t++) {
                        sb.append(" ");
                    }
                    space -= insert;
                }
            }            
            res.add(sb.toString());
            i = j;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(TextJustification.solution(words, 16));
    }

}
