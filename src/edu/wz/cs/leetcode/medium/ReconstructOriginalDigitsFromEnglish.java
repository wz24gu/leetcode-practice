package edu.wz.cs.leetcode.medium;

/**
 * 423. Reconstruct Original Digits from English<br>
 * https://leetcode.com/problems/reconstruct-original-digits-from-english<br><br>
 * 
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in 
 * ascending order.<br><br>
 * 
 * Note:<br>
 * 1. Input contains only lowercase English letters.<br>
 * 2. Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as 
 * "abc" or "zerone" are not permitted.<br>
 * 3. Input length is less than 50,000.
 */
public class ReconstructOriginalDigitsFromEnglish {
    
    public static String solution(String s) {        
        int[] index = new int[26];
        for (char c : s.toCharArray()) {
            index[c - 'a']++;
        }
        
        int[] nums = new int[10];
        nums[0] = index['z' - 'a'];
        nums[2] = index['w' - 'a'];
        nums[4] = index['u' - 'a'];
        nums[6] = index['x' - 'a'];
        nums[8] = index['g' - 'a'];
        nums[1] = index['o' - 'a'] - nums[0] - nums[2] - nums[4];
        nums[3] = index['h' - 'a'] - nums[8];
        nums[5] = index['f' - 'a'] - nums[4];
        nums[7] = index['s' - 'a'] - nums[6];
        nums[9] = index['i' - 'a'] - nums[5] - nums[6] - nums[8];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(ReconstructOriginalDigitsFromEnglish.solution("owoztneoer"));
        System.out.println(ReconstructOriginalDigitsFromEnglish.solution("fviefuro"));
    }

}
