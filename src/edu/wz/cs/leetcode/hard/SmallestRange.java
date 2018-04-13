package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 632. Smallest Range<br/>
 * 
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number
 * from each of the k lists. We define the range [a, b] is smaller than range [c,d] if b - a < d - c or a < c if
 * b - a == d - c.<br/><br/>
 * 
 * Note:<br/>
 * 1. The given list may contain duplicates, so ascending order means >= here.<br/>
 * 2. 1 <= k <= 3500<br/>
 * 3. -105 <= value of elements <= 105.<br/>
 * 
 * For Java users, please note that the input type has been changed to List<List<Integer>>. And after you reset the code
 * template, you'll see this point.
 */
public class SmallestRange {
    
    private static class Pair {
        public int num;
        public int list;
        public Pair(int num, int list) {
            this.num = num;
            this.list = list;
        }
        public String toString() {
            return num + " -> " + list;
        }
    }
    
    public static int[] solution(List<List<Integer>> nums) {
        int[] result = {-106, 106};
        
        List<Pair> list = new ArrayList<>();
        int k = nums.size();
        for (int i = 0; i < k; i++) {
            for (int num : nums.get(i)) {
                list.add(new Pair(num, i));  // put all numbers in one list of num -> list no. pair
            }
        }
        
        // sort the list by Pair's number
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.num - p2.num;
            }
        });
        System.out.println(list);
        
        int n = list.size();
        int left = 0;
        int count = 0;
        int diff = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int rl = list.get(right).list;
            if (!map.containsKey(rl)) {
                count++;
                map.put(rl, 1);
            }
            else {
                map.put(rl, map.get(rl) + 1);
            }
            
            while (count == k && left <= right) {
                if (diff > list.get(right).num - list.get(left).num) {
                    diff = list.get(right).num - list.get(left).num;
                    result[0] = list.get(left).num;
                    result[1] = list.get(right).num;
                }
                
                // more left one step toward right
                int ll = list.get(left).list;
                left++;
                if (map.get(ll) == 1) {
                    map.remove(ll);
                    count--;
                }
                else {
                    map.put(ll, map.get(ll) - 1);
                }   
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 10, 15, 24, 26);
        List<Integer> list2 = Arrays.asList(0, 9, 12, 20);
        List<Integer> list3 = Arrays.asList(5, 18, 22, 30);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        
        System.out.println(Arrays.toString(SmallestRange.solution(list)));
        
    }

}
