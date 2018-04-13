package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 475. Heaters<br>
 * https://leetcode.com/problems/heaters<br><br>
 * 
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm 
 * all the houses.<br>
 * 
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that 
 * all houses could be covered by those heaters.<br>
 * 
 * So, your input will be the positions of houses and heaters separately, and your expected output will be the minimum 
 * radius standard of heaters.<br><br>
 * 
 * Note:<br>
 * 1. Numbers of houses and heaters you are given are non-negative and will not exceed 25000.<br>
 * 2. Positions of houses and heaters you are given are non-negative and will not exceed 10^9.<br>
 * 3. As long as a house is in the heaters' warm radius range, it can be warmed.<br>
 * 4. All the heaters follow your radius standard and the warm radius will the same.
 */
public class Heaters {
    
    public static int solution(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                    && Math.abs(heaters[j+1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            result = Math.max(result, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return result;        
    }
    
    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        System.out.println(Heaters.solution(houses, heaters));
        
        int[] houses2 = {1, 2, 3, 4};
        int[] heaters2 = {1, 4};
        System.out.println(Heaters.solution(houses2, heaters2));
    }

}
