package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 638. Shopping Offers<br>
 * https://leetcode.com/problems/shopping-offers<br><br>
 * 
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.<br>
 * 
 * However, there are some special offers, and a special offer consists of one or more different kinds of items with a 
 * sale price.<br>
 * 
 * You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is 
 * to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of 
 * the special offers.<br>
 * 
 * Each special offer is represented in the form of an array, the last number represents the price you need to pay for 
 * this special offer, other numbers represents how many specific items you could get if you buy this offer.<br>
 * 
 * You could use any of special offers as many times as you want.<br><br>
 * 
 * Note:<br>
 * 1. There are at most 6 kinds of items, 100 special offers.<br>
 * 2. For each item, you need to buy at most 6 of them.<br>
 * 3. You are not allowed to buy more items than you want, even if that would lower the overall price.
 */
public class ShoppingOffers {
    
    public static int solution(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += price.get(i) * needs.get(i);  // get the regular price
        }
        
        for (List<Integer> offer : special) {
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if (needs.get(i) < offer.get(i)) {
                    valid = false;
                }
                needs.set(i, needs.get(i) - offer.get(i));
            }
            if (valid) {
                result = Math.min(result, solution(price, special, needs) + offer.get(n));  // last element in offer is the price
            }
            // BT, set back
            for (int i = 0; i < n; i++) {
                needs.set(i, needs.get(i) + offer.get(i));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(new Integer[] {2, 5});
        List<Integer> needs = Arrays.asList(new Integer[] {3, 2});
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> offer1 = Arrays.asList(new Integer[] {3, 0, 5});
        List<Integer> offer2 = Arrays.asList(new Integer[] {1, 2, 10});
        special.add(offer1);
        special.add(offer2);
        System.out.println(ShoppingOffers.solution(price, special, needs));
        
        List<Integer> price2 = Arrays.asList(new Integer[] {2, 3, 4});
        List<Integer> needs2 = Arrays.asList(new Integer[] {1, 2, 1});
        List<List<Integer>> special2 = new ArrayList<>();
        List<Integer> offer21 = Arrays.asList(new Integer[] {1, 1, 0, 4});
        List<Integer> offer22 = Arrays.asList(new Integer[] {2, 2, 1, 9});
        special2.add(offer21);
        special2.add(offer22);
        System.out.println(ShoppingOffers.solution(price2, special2, needs2));        
    }

}
