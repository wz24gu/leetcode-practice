package edu.wz.cs.leetcode.medium;

/**
 * 777. Swap Adjacent in LR String<br>
 * https://leetcode.com/problems/swap-adjacent-in-lr-string<br><br>
 * 
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one 
 * occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the 
 * ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.<br><br>
 * 
 * Note:<br>
 * 1. 1 <= len(start) = len(end) <= 10000.<br>
 * 2. Both start and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class SwapAdjacentInLRString {
    
    public static boolean solution(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s.length && j < e.length) {
            while (i < s.length && s[i] == 'X') {
                i++;
            }
            while (j < e.length && e[j] == 'X') {
                j++;
            }
            
            if (i < s.length && j < e.length) {
                if (s[i] != e[j]) {
                    return false;
                }
                if (s[i] == 'L' && i < j) {
                    return false;
                }
                if (s[i] == 'R' && i > j) {
                    return false;
                }
            }
            else {
                return false;
            }
            i++;
            j++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(SwapAdjacentInLRString.solution("RXXLRXRXL", "XRLXXRRLX"));
    }

}
