package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 691. Stickers to Spell Word<br/>
 * https://leetcode.com/problems/stickers-to-spell-word<br/><br/>
 * 
 * We are given N different types of stickers. Each sticker has a lowercase English word on it. You would like to spell 
 * out the given target string by cutting individual letters from your collection of stickers and rearranging them.<br/>
 * 
 * You can use each sticker more than once if you want, and you have infinite quantities of each sticker. What is the 
 * minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.<br/><br/>
 * 
 * Note:<br/>
 * 1. stickers has length in the range [1, 50].<br/>
 * 2. stickers consists of lowercase English words (without apostrophes).<br/>
 * 3. target has length in the range [1, 15], and consists of lowercase English letters.<br/>
 * 4. In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was 
 * chosen as a concatenation of two random words.<br/>
 * 5. The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 
 * 35ms on average.
 */
public class StickersToSpellWord {
    
    public static int solution(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return helper(dp, mp, target);
    }
    
    private static int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }
        
        int[] tar = new int[26];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }
        
        int result = Integer.MAX_VALUE;
        int m = mp.length;
        for (int i = 0; i < m; i++) {
            if (mp[i][target.charAt(0)-'a'] == 0) {
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0) {
                    for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            int temp = helper(dp, mp, sb.toString());
            if (temp != -1) {
                result = Math.min(result, temp + 1);
            }
        }
        
        dp.put(target, result == Integer.MAX_VALUE ? -1 : result);
        return dp.get(target);
    }
    
    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        System.out.println(StickersToSpellWord.solution(stickers, "thehat"));
        
        String[] stickers2 = {"notice", "possible"};
        System.out.println(StickersToSpellWord.solution(stickers2, "basicbasic"));
    }

}
