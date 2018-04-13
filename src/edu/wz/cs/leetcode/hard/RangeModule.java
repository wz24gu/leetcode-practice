package edu.wz.cs.leetcode.hard;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 715. Range Module<br>
 * https://leetcode.com/problems/range-module<br><br>
 * 
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following 
 * interfaces in an efficient manner.<br>
 * 
 * 1. addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval.
 * Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval 
 * [left, right) that are not already tracked.<br>
 * 2. queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is 
 * currently being tracked.<br>
 * 3. removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).<br><br>
 * 
 * Note:<br>
 * 1. A half open interval [left, right) denotes all real numbers left <= x < right.<br>
 * 2. 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.<br>
 * 3. The total number of calls to addRange in a single test case is at most 1000.<br>
 * 4. The total number of calls to queryRange in a single test case is at most 5000.<br>
 * 5. The total number of calls to removeRange in a single test case is at most 1000.
 */
public class RangeModule {
    
    private TreeMap<Integer, Integer> map;
    
    public RangeModule() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public void addRange(int left, int right) {
        if (right <= left) {
            return;
        }
        
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        }
        else if (start != null && map.get(start) >= left) {
            map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
        }
        else {
            map.put(left, Math.max(map.get(end), right));
        }
        
        Map<Integer, Integer> remove = map.subMap(left, false, right, true);
        Set<Integer> set = new HashSet<>(remove.keySet());
        map.keySet().removeAll(set);
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start == null) {
            return false;
        }
        return map.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        if (right <= left) {
            return;
        }
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }
        
        Map<Integer, Integer> remove = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet<>(remove.keySet());
        map.keySet().removeAll(set);
    }
    
    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        System.out.println(rangeModule.queryRange(10, 14));
        System.out.println(rangeModule.queryRange(13, 15));
        System.out.println(rangeModule.queryRange(16, 17));
    }

}
