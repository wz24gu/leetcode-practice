package edu.wz.cs.leetcode.medium;

/**
 * 809. Expressive Words<br>
 * https://leetcode.com/problems/expressive-words<br><br>
 * 
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, 
 * we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different. 
 * A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" 
 * would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", 
 * and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.<br>
 * 
 * For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups. Formally, 
 * we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character 
 * c to it so that the length of the group is 3 or more. Note that we cannot extend a group of size one like "h" to a 
 * group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.<br>
 * 
 * Given a list of query words, return the number of words that are stretchy.<br><br>
 * 
 * Notes:<br>
 * 1. 0 <= len(S) <= 100.<br>
 * 2. 0 <= len(words) <= 100.<br>
 * 3. 0 <= len(words[i]) <= 100.<br>
 * 4. S and all words in words consist only of lowercase letters
 */
public class ExpressiveWords {
    
    public static int solution(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (check(S, word)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean check(String S, String word) {
        int m = word.length();
        int n = S.length();
        if (m > n) {
            return false;
        }
        if (m == n && !S.equals(word)) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        boolean valid = true;
        while (i < m && j < n) {
            if (word.charAt(i) == S.charAt(j)) {
                int t1 = i;
                int t2 = j;
                char c = word.charAt(i);
                while (i < m && word.charAt(i) == c) {
                    i++;
                }
                while (j < n && S.charAt(j) == c) {
                    j++;
                }
                
                if (j - t2 < 3 && !S.substring(t2, j).equals(word.substring(t1, i))) {
                    valid = false;
                    break;
                }
            }
            else {
                break;
            }
        }
        
        return i == m && j == n && valid;
    }
    
    public static void main(String[] args) {
        String[] words = {"hello", "hi", "helo"};
        System.out.println(ExpressiveWords.solution("heeellooo", words));
    }

}
