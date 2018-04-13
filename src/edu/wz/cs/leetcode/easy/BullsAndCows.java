package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 299. Bulls and Cows<br/>
 * https://leetcode.com/problems/bulls-and-cows<br/><br/>
 * 
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to 
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in 
 * said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match 
 * the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints 
 * to eventually derive the secret number.<br/>
 * 
 * For example:<br/>
 * Secret number:  "1807"<br/>
 * Friend's guess: "7810"<br/>
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)<br/>
 * 
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls 
 * and B to indicate the cows. In the above example, your function should return "1A3B".<br/>
 * 
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:<br/> * 
 * Secret number:  "1123"<br/>
 * Friend's guess: "0111"<br/>
 * 
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".<br/>
 * 
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsAndCows {
    
    public static String solution(String secret, String guess) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int n = secret.length();
        for (int i = 0; i < n; i++) {
            char c = secret.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
            }
            map.get(c).add(i);
        }
        
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < n; i++) {
            char c = guess.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c).contains(i)) {
                    countA++;
                    map.get(c).remove(new Integer(i));  // make it an object, otherwise it will remove the index
                }
                else {
                    countB++;
                    map.get(c).remove(0);  // remove index 0
                }
                
                if (map.get(c).isEmpty()) {
                    map.remove(c);
                }
            }
        }
        
        return countA + "A" + countB + "B";
    }
    
    public static void main(String[] args) {
        System.out.println(BullsAndCows.solution("1807", "7810"));
        System.out.println(BullsAndCows.solution("1123", "0111"));
    }

}
