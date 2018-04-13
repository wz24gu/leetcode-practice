package edu.wz.cs.leetcode.easy;

/**
 * 605. Can Place Flowers<br>
 * https://leetcode.com/problems/can-place-flowers<br><br>
 * 
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot 
 * be planted in adjacent plots - they would compete for water and both would die.<br>
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a 
 * number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.<br><br>
 * 
 * Note:<br>
 * 1. The input array won't violate no-adjacent-flowers rule.<br>
 * 2. The input array size is in the range of [1, 20000].<br>
 * 3. n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers {
    
    public static boolean solution(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {           
           int prev = (i == 0) ? 0 : flowerbed[i-1];
           int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i+1];           
           if (prev + next + flowerbed[i] == 0) {
               flowerbed[i] = 1;
               n--;
           }
          
        }
        return n <= 0;
    }
    
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(CanPlaceFlowers.solution(flowerbed, 1));
        
        int[] flowerbed2 = {1, 0, 0, 0, 1};
        System.out.println(CanPlaceFlowers.solution(flowerbed2, 2));
    }

}
