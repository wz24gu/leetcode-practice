package edu.wz.cs.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {
    
    public List<List<Character>> frequency(String s) {
        List<List<Character>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        @SuppressWarnings("unchecked")
        List<Character>[] buckets = (List<Character>[]) new List[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Character>();
            }
            buckets[freq].add(c);
        }
        
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                result.add(buckets[i]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        BucketSort bucket = new BucketSort();
        System.out.println(bucket.frequency("aabdtddgadgaetadagetloeqerje"));
    }

}
