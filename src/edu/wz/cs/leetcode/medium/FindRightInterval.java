package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 436. Find Right Interval<br>
 * https://leetcode.com/problems/find-right-interval<br><br>
 * 
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger 
 * than or equal to the end point of the interval i, which can be called that j is on the "right" of i.<br>
 * 
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the 
 * minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for 
 * the interval i. Finally, you need output the stored value of each interval as an array.<br><br>
 * 
 * Note:<br>
 * 1. You may assume the interval's end point is always bigger than its start point.<br>
 * 2. You may assume none of these intervals have the same start point.
 */
public class FindRightInterval {
    
    public static int[] solution(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        int[] start = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i].start, i);
            start[i] = intervals[i].start;
        }        
        Arrays.sort(start);
        
        for (int i = 0; i < n; i++) {
            int j;
            for (j = n - 1; j >= 0; j--) {
                if (start[j] < intervals[i].end) {                   
                    break;
                }                
            }
            if (j < n - 1) {
                result[i] = map.get(start[j+1]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(1, 2) };
        System.out.println(Arrays.toString(FindRightInterval.solution(intervals)));
        
        Interval[] intervals2 = new Interval[] {
                                    new Interval(3, 4),
                                    new Interval(2, 3),
                                    new Interval(1, 2) };
        System.out.println(Arrays.toString(FindRightInterval.solution(intervals2)));
        
        Interval[] intervals3 = new Interval[] {
                                    new Interval(1, 4),
                                    new Interval(2, 3),
                                    new Interval(3, 4) };
        System.out.println(Arrays.toString(FindRightInterval.solution(intervals3)));
    }

}
