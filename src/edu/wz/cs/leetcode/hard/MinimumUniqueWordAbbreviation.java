package edu.wz.cs.leetcode.hard;

import java.util.PriorityQueue;

/**
 * 411. Minimum Unique Word Abbreviation<br>
 * https://leetcode.com/problems/minimum-unique-word-abbreviation<br><br>
 * 
 * A string such as "word" contains the following abbreviations:<br>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]<br>
 * 
 * Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the 
 * smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.<br>
 * 
 * Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.<br><br>
 * 
 * Note:<br>
 * 1. In the case of multiple answers as shown in the second example below, you may return any one of them.<br>
 * 2. Assume length of target string = m, and dictionary size = n. You may assume that m <= 21, n <= 1000, and log2(n) + m <= 20.
 */
public class MinimumUniqueWordAbbreviation {
    
    private static class Pair {
        public int first;
        public String second;
        public Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public static String solution(String target, String[] dict) {
        if (dict == null || dict.length == 0) {
            return target.length() + "";
        }
        
        PriorityQueue<Pair> queue = generate(target);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            
            boolean conflict = false;
            for (String word : dict) {
                if (valid(word, pair.second)) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict) {
                return pair.second;
            }
        }
        
        return "";
    }
    
    private static PriorityQueue<Pair> generate(String target) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.first - p2.first);
                
        int n = target.length();
        int len = (int) Math.pow(2, n);
        for (int i = 0; i < len; i++) {
            String out = "";
            int count = 0;
            int size = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    count++;
                }
                else {
                    if (count != 0) {
                        out += count;
                        count = 0;
                        size++;
                    }
                    out += target.charAt(j);
                    size++;
                }
            }
            if (count > 0) {
                out += count;
                size++;
            }
            queue.offer(new Pair(size, out));
        }
        
        return queue;
    }
    
    private static boolean valid(String word, String abbr) {
        int m = word.length();
        int n = abbr.length();
        int p = 0;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                if (count == 0 && abbr.charAt(i) == '0') {
                    return false;                    
                }
                count = 10 * count + (abbr.charAt(i) - '0');
            }
            else {
                p += count;
                if (p >= m || word.charAt(p++) != abbr.charAt(i)) {
                    return false;
                }
                count = 0;
            }
        }
        
        return p + count == m;
    }
    
    public static void main(String[] args) {
        String[] dict = {"blade"};
        System.out.println(MinimumUniqueWordAbbreviation.solution("apple", dict));
        
        String[] dict2 = {"plain", "amber", "blade"};
        System.out.println(MinimumUniqueWordAbbreviation.solution("apple", dict2));
    }

}
