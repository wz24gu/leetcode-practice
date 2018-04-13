package edu.wz.cs.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 732. My Calendar III<br>
 * https://leetcode.com/problems/my-calendar-iii<br><br>
 * 
 * Implement a MyCalendarThree class to store your events. A new event can always be added.<br>
 * 
 * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval 
 * [start, end), the range of real numbers x such that start <= x < end.<br>
 * 
 * A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all K events.)<br>
 * 
 * For each call to the method MyCalendar.book, return an integer K representing the largest integer such that there exists 
 * a K-booking in the calendar.<br>
 * 
 * Your class will be called like this: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)<br><br>
 * 
 * Note:<br>
 * 1. The number of calls to MyCalendarThree.book per test case will be at most 400.<br>
 * 2. In calls to MyCalendarThree.book(start, end), start and end are integers in the range [0, 10^9].
 */
public class MyCalendarIII {
    
    private Map<Integer, Integer> map;
    
    public MyCalendarIII() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int ongoing = 0;
        int max = 0;
        for (int event : map.values()) {
            ongoing += event;
            max = Math.max(max, ongoing);
        }
        return max;
    }
    
    public static void main(String[] args) {
        MyCalendarIII myCalendarIII = new MyCalendarIII();
        System.out.println(myCalendarIII.book(10, 20));
        System.out.println(myCalendarIII.book(50, 60));
        System.out.println(myCalendarIII.book(10, 40));
        System.out.println(myCalendarIII.book(5, 15));
        System.out.println(myCalendarIII.book(5, 10));
        System.out.println(myCalendarIII.book(25, 55));
    }

}
