package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. My Calendar II<br>
 * https://leetcode.com/problems/my-calendar-ii<br><br>
 * 
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a 
 * triple booking.<br>
 * 
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open 
 * interval [start, end), the range of real numbers x such that start <= x < end.<br>
 * 
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common 
 * to all 3 events.)<br>
 * 
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully 
 * without causing a triple booking. Otherwise, return false and do not add the event to the calendar.<br>
 * 
 * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)<br>
 * 
 * Note:<br>
 * 1. The number of calls to MyCalendar.book per test case will be at most 1000.<br>
 * 2. In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class MyCalendarII {
    
    private List<int[]> bookings;
    
    public  MyCalendarII() {
        bookings = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        MyCalendarI overlaps = new MyCalendarI();
        for (int[] b : bookings) {
            int os = Math.max(b[0], start);
            int oe = Math.min(b[1], end);
            if (os < oe) {
                if (!overlaps.book(os, oe)) {
                    return false;
                }
            }            
        }
        bookings.add(new int[] {start, end});
        return true;
    }
    
    public static void main(String[] args) {
        MyCalendarII myCalendarII = new MyCalendarII();
        System.out.println(myCalendarII.book(10, 20));
        System.out.println(myCalendarII.book(50, 60));
        System.out.println(myCalendarII.book(10, 40));
        System.out.println(myCalendarII.book(5, 15));
        System.out.println(myCalendarII.book(5, 10));
        System.out.println(myCalendarII.book(25, 55));
    }

}
