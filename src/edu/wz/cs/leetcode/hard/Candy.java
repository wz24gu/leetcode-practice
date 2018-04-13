package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 135. Candy<br>
 * https://leetcode.com/problems/candy<br><br>
 * 
 * There are N children standing in a line. Each child is assigned a rating value.<br>
 * 
 * You are giving candies to these children subjected to the following requirements:<br><br>
 * 1. Each child must have at least one candy.<br>
 * 2. Children with a higher rating get more candies than their neighbors.<br>
 * 
 * What is the minimum candies you must give?
 */
public class Candy {
    
    public static int solution(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }        
        
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i+1] > ratings[i]) {
                candies[i+1] = candies[i] + 1;
            }
        }        
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
            }
        }        
        
        int result = 0;
        for (int candy : candies) {
            result += candy;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] ratings = {1, 3, 2, 1};
        System.out.println(Candy.solution(ratings));
    }

}
