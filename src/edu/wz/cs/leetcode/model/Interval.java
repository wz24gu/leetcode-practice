package edu.wz.cs.leetcode.model;

public class Interval {
    
    public int start;
    public int end;
    
    public Interval() {
        this(0, 0);
    }
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

}
