package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import edu.wz.cs.leetcode.model.Interval;

/**
 * 352. Data Stream as Disjoint Intervals<br/>
 * 
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list 
 * of disjoint intervals.<br/>
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:<br/>
 * [1, 1]<br/>
 * [1, 1], [3, 3]<br/>
 * [1, 1], [3, 3], [7, 7]<br/>
 * [1, 3], [7, 7]<br/>
 * [1, 3], [6, 7]<br/>
 * 
 * Follow up:<br/>
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class DataStreamAsDisjointIntervals {
    
    private List<Interval> intervals;
    
    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        intervals = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        Interval current = new Interval(val, val);
        List<Interval> list = new ArrayList<>();
        
        int pos = 0;
        for (Interval i : intervals) {
            if (current.end + 1 < i.start) {
                list.add(i);
            }
            else if (i.end + 1 < current.start) {
                list.add(i);
                pos++;
            }
            else {
                current.start = Math.min(current.start, i.start);
                current.end = Math.max(current.end, i.end);
            }
        }
        list.add(pos, current);
        intervals = list;    
    }
    
    public List<Interval> getIntervals() {
        return intervals;
    }
    
    public static void main(String[] args) {
        DataStreamAsDisjointIntervals data = new DataStreamAsDisjointIntervals();
        data.addNum(1);
        System.out.println(data.getIntervals());
        data.addNum(3);
        System.out.println(data.getIntervals());
        data.addNum(7);
        System.out.println(data.getIntervals());
        data.addNum(2);
        System.out.println(data.getIntervals());
        data.addNum(6);
        System.out.println(data.getIntervals());
    }

}
