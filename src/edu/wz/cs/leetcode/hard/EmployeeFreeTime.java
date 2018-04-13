package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 759. Employee Free Time<br>
 * https://leetcode.com/problems/employee-free-time<br><br>
 * 
 * We are given a list schedule of employees, which represents the working time for each employee.<br>
 * 
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.<br>
 * 
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted 
 * order.<br><br>
 * 
 * Note:<br>
 * 1. schedule and schedule[i] are lists with lengths in range [1, 50].<br>
 * 2. 0 <= schedule[i].start < schedule[i].end <= 10^8.
 */
public class EmployeeFreeTime {
    
    public static List<Interval> solution(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> timeline = new ArrayList<>();
        
        for (List<Interval> list : schedule) {
            timeline.addAll(list);
        }
        Collections.sort(timeline, (a, b) -> a.start - b.start);
        
        Interval tmp = timeline.get(0);
        for (Interval i : timeline) {
            if (tmp.end < i.start) {
                res.add(new Interval(tmp.end, i.start));
                tmp = i;
            }
            else {
                tmp = tmp.end < i.end ? i : tmp;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedule.add(Arrays.asList(new Interval(1, 3)));
        schedule.add(Arrays.asList(new Interval(4, 10)));
        System.out.println(EmployeeFreeTime.solution(schedule));
        
        List<List<Interval>> schedule2 = new ArrayList<>();
        schedule2.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        schedule2.add(Arrays.asList(new Interval(2, 4)));
        schedule2.add(Arrays.asList(new Interval(2, 5), new Interval(9, 12)));
        System.out.println(EmployeeFreeTime.solution(schedule2));
    }

}
