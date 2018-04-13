package edu.wz.cs.leetcode.easy;

/**
 * 383. Ransom Note<br>
 * https://leetcode.com/problems/ransom-note<br><br>
 * 
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazine; otherwise, it will return false.<br>
 * 
 * Each letter in the magazine string can only be used once in your ransom note.<br>
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 */
public class RandomNote {

    public static boolean solution(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            freq[c-'a']--;
        }
        
        for (int f : freq) {
            if (f < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(RandomNote.solution("a", "b"));
        System.out.println(RandomNote.solution("aa", "ab"));
        System.out.println(RandomNote.solution("aa", "aab"));
    }

}
