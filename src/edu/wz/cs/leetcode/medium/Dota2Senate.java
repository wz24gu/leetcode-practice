package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 Senate<br>
 * https://leetcode.com/problems/dota2-senate<br><br>
 * 
 * In the world of Dota 2, there are two parties: the Radiant and the Dire.<br>
 * 
 * The Dota 2 senate consists of senators coming from two parties. Now the senate wants to make a decision about a change 
 * in the Dota 2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise 
 * one of the two rights:<br>
 * 
 * 1. Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.<br>
 * 2. Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, 
 * he can announce the victory and make the decision about the change in the game.<br>
 * 
 * Given a string representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party 
 * and the Dire party respectively. Then if there are n senators, the size of the given string will be n.<br>
 * 
 * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will 
 * last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.<br>
 * 
 * Suppose every senator is smart enough and will play the best strategy for his own party, you need to predict which 
 * party will finally announce the victory and make the change in the Dota2 game. The output should be Radiant or Dire.<br>
 * 
 * Note: The length of the given string will in the range [1, 10,000].
 */
public class Dota2Senate {
    
    public static String solution(String senate) {
        int n = senate.length();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                q1.offer(i);
            }
            else {
                q2.offer(i);
            }
        }
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int i = q1.poll();
            int j = q2.poll();
            if (i < j) {
                q1.offer(n + i);
            }
            else {
                q2.offer(n + j);
            }
        }
        
        return (q1.size() > q2.size()) ? "Radiant" : "Dire";
    }
    
    public static void main(String[] args) {
        System.out.println(Dota2Senate.solution("RD"));
        System.out.println(Dota2Senate.solution("RDD"));
    }

}
