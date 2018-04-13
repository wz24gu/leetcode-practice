package edu.wz.cs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. Distribute Candies<br/>
 * 
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to
 * brother and sister. Return the maximum number of kinds of candies the sister could gain.<br/><br/>
 * 
 * Note:<br/>
 * 1. The length of the given array is in range [2, 10,000], and will be even.<br/>
 * 2. The number in given array is in range [-100,000, 100,000].
 */
public class DistributeCandies {
    
    public static int solution(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        return Math.min(set.size(), candies.length / 2);  // one person can get n/2 different candies or less
    }
    
    public static int solutionX(int[] candies) {
        int half = candies.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
            if (set.size() >= half) {
                return half;
            }
        }
        return set.size();
    }
    
    public static void main(String[] args) {
        int[] candies = {1, 1, 2, 2, 3, 3};
        System.out.println(DistributeCandies.solution(candies));
        System.out.println(DistributeCandies.solutionX(candies));
    }

}
