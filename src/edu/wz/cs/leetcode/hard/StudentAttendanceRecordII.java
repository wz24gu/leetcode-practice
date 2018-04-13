package edu.wz.cs.leetcode.hard;

/**
 * 552. Student Attendance Record II<br/>
 * https://leetcode.com/problems/student-attendance-record-ii<br/><br/>
 * 
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be 
 * regarded as rewardable. The answer may be very large, return it after mod 10 ^ 9 + 7.<br/>
 * 
 * A student attendance record is a string that only contains the following three characters:<br/>
 * 1. 'A' : Absent.<br/>
 * 2. 'L' : Late.<br/>
 * 3. 'P' : Present.<br/>
 * 
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' 
 * (late).<br/>
 * 
 * Note: The value of n won't exceed 100,000.
 */
public class StudentAttendanceRecordII {

    public static int solution(int n) {
        int m = 1000000007;
        long[] A = new long[n];
        long[] P = new long[n];
        long[] L = new long[n];
        
        P[0] = 1;
        L[0] = 1;        
        A[0] = 1;
        
        if (n == 1) {
            return 3;
        }
        if (n == 2) {            
            return 8;
        }
                
        L[1] = 3;
        A[1] = 2;
        A[2] = 4;
        
        for (int i = 1; i < n; i++) {
            P[i] = A[i-1] + P[i-1] + L[i-1];  // P can add to all
            if (i > 1) {
                L[i] = A[i-1] + P[i-1] + A[i-2] + P[i-2];
            }
            if (i > 2) {
                A[i] = A[i-1] + A[i-2] + A[i-3];
            }
        }
        
        return (int) ((A[n-1] + P[n-1] + L[n-1]) % m);        
    }
    
    public static void main(String[] args) {
        System.out.println(StudentAttendanceRecordII.solution(3));
    }
    
}
