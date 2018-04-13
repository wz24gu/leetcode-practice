package edu.wz.cs.leetcode.medium;

import java.util.TreeMap;

/**
 * 729. My Calendar I<br>
 * https://leetcode.com/problems/my-calendar-i<br><br>
 * 
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a 
 * double booking.<br>
 * 
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open 
 * interval [start, end), the range of real numbers x such that start <= x < end.<br>
 * 
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to 
 * both events.)<br>
 * 
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully 
 * without causing a double booking. Otherwise, return false and do not add the event to the calendar.<br>
 * 
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)<br><br>
 * 
 * Note:<br>
 * 1. The number of calls to MyCalendar.book per test case will be at most 1000.<br>
 * 2. In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class MyCalendarI {
    
    private TreeMap<Integer, Integer> map;
    
    public MyCalendarI() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        if (floor != null && map.get(floor) > start) {
            return false;
        }
        Integer ceiling = map.ceilingKey(start);
        if (ceiling != null && ceiling < end) {
            return false;
        }
        
        map.put(start, end);
        return true;
    }
    
    public static void main(String[] args) {
        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(10, 20));
        System.out.println(myCalendarI.book(15, 25));
        System.out.println(myCalendarI.book(20, 30));
    }

}
