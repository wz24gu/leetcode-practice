package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. Minimum Index Sum Of Two Lists<br>
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists<br><br>
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurant
 * represented by strings. You need to help them find out their common interest with the least list index sum. If there
 * is a choice tie between answers, output all of them with no order requirement. You could assume there always exists
 * an answer.<br><br>
 * 
 * Note:<br>
 * 1. The length of both lists will be in the range of [1, 1000].<br>
 * 2. The length of strings in both lists will be in the range of [1, 30].<br>
 * 3. The index is starting from 0 to the list length minus 1.<br>
 * 4. No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists {

    public static String[] solution(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int n1 = list1.length;
        for (int i = 0; i < n1; i++) {
            map.put(list1[i], i);
        }        
        
        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        int n2 = list2.length;        
        for (int i = 0; i < n2; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum <= min) {
                    if (sum < min) {
                        min = sum;
                        list.clear();
                    }
                    list.add(list2[i]);
                }
            }
        }
        
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(MinimumIndexSumOfTwoLists.solution(list1, list2)));
        
        String[] list3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list4 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(MinimumIndexSumOfTwoLists.solution(list3, list4)));
    }

}
