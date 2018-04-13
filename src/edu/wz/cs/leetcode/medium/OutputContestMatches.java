package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 544. Output Contest Matches<br>
 * https://leetcode.com/problems/output-contest-matches<br><br>
 * 
 * During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the
 * rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting. Now, you're
 * given n teams, you need to output their final contest matches in the form of a string.<br>
 * 
 * The n teams are given in the form of positive integers from 1 to n, which represents their initial rank. (Rank 1 is
 * the strongest team and Rank n is the weakest team.) We'll use parentheses('(', ')') and commas(',') to represent the
 * contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition. During the pairing process
 * in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.<br><br>
 * 
 * Note:<br><br>
 * 1. The n is in range [2, 212].
 * 2. We ensure that the input n can be converted into the form 2k, where k is a positive integer.
 */
public class OutputContestMatches {
    
    public static String solution(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i + "");
        }
        
        while (list.size() > 1) {
            List<String> temp = new ArrayList<>();
            int i = 0;
            int j = list.size() - 1;
            while (i < j) {
                temp.add("(" + list.get(i++) + "," + list.get(j--) + ")");
            }
            list = temp;
        }
        
        return list.get(0);
    }
    
    public static void main(String[] args) {
        System.out.println(OutputContestMatches.solution(8));
    }

}
