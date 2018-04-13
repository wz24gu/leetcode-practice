package edu.wz.cs.leetcode.easy;

/**
 * 551. Student Attendance Record I<br>
 * https://leetcode.com/problems/student-attendance-record-i<br><br>
 * 
 * You are given a string representing an attendance record for a student. The record only contains the following three
 * characters:<br>
 * 1. 'A': absent<br>
 * 2. 'L': late<br>
 * 3. 'P': present<br>
 * 
 * A student could be rewarded if his attendance record does not contain more that one 'A' or more than two continuous
 * 'L'. You need to return whether the student could be rewarded according to his attendance record.
 */
public class StudentAttendanceRecordI {

    public static boolean solution(String record) {        
        int countA = 0;        
        int countL = 0;
        int currL = 0;
        
        for (char c : record.toCharArray()) {
            if (c == 'A') {
                countA++;
                currL = 0;
            }
            else if (c == 'L') {
                currL++;
                countL = Math.max(countL, currL);
            }
            else {
                currL = 0;
            }
        }
        
        return countA <= 1 && countL <= 2;
    }
    
    public static void main(String[] args) {
        System.out.println(StudentAttendanceRecordI.solution("PPALLP"));
        System.out.println(StudentAttendanceRecordI.solution("LLLALL"));
    }

}
