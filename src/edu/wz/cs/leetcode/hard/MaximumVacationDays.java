package edu.wz.cs.leetcode.hard;

/**
 * 568. Maximum Vacation Days<br/>
 * 
 * LeetCode wants to give one of its best employees the option to travel among N cities to collect algorithm problems.
 * But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks. Your
 * job is to schedule the traveling to maximize the number of vacation days you could take, but there are certain rules
 * and restrictions you need to follow.<br/>
 * 
 * Rules and restrictions:<br/>
 * 1. You can only travel among N cities, represented by indexes from 0 to N-1. Initially, you are in the city indexed
 * 0 on Monday.<br/>
 * 2. The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical),
 * called flights representing the airline status from the city i to the city j. If there is no flight from the city i
 * to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1. Also, flights[i][i] = 0 for all i.<br/>
 * 3. You totally have K weeks (each week has 7 days) to travel. You can only take flights at most once per day and
 * can only take flights on each week's Monday morning. Since flight time is so short, we don't consider the impact of
 * flight time. For each city, you can only have restricted vacation days in different weeks, given an N*K matrix called
 * days representing this relationship. For the value of days[i][j], it represents the maximum days you could take
 * vacation in the city i in the week j.<br/>
 * 
 * You're given the flights matrix and days matrix, and you need to output the maximum vacation days you could take
 * during K weeks.<br/>
 * 
 * Note:<br/>
 * 1. N and K are positive integers, which are in the range of [1, 100].<br/>
 * 2. In the matrix flights, all the values are integers in the range of [0, 1].<br/>
 * 3. In the matrix days, all the values are integers in the range [0, 7].<br/>
 * 4. You could stay at a city beyond the number of vacation days, but you should work on the extra days, which won't
 * be counted as vacation days.<br/>
 * 5. If you fly from the city A to the city B and take the vacation on that day, the deduction towards vacation days
 * will count towards the vacation days of city B in that week.<br/>
 * 6. We don't consider the impact of flight hours towards the calculation of vacation days.
 */
public class MaximumVacationDays {
    
    public static int solution(int[][] flights, int[][] days) {
        int city_cnt = days.length;
        int week_cnt = days[0].length;
        
        int[][] dp = new int[week_cnt][city_cnt];
        
        // set first week
        for (int city = 0; city < city_cnt; city++) {
            if (city == 0 || flights[0][city] == 1) {
                dp[0][city] = days[city][0];
            }
        }
        
        // from second week
        for (int week = 1; week < week_cnt; week++) {
            for (int city = 0; city < city_cnt; city++) {
                // for each city, find which city can fly to the current city
                for (int i = 0; i < city_cnt; i++) {
                    if (dp[week-1][i] != 0 && (i == city || flights[i][city] == 1)) {
                        dp[week][city] = Math.max(dp[week][city], dp[week-1][i] + days[city][week]);
                    }
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[week_cnt-1].length; i++) {
            if (max < dp[week_cnt-1][i]) {
                max = dp[week_cnt-1][i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[][] flights = { {0, 1, 1},
                            {1, 0, 1},
                            {1, 1, 0} };
        int[][] days =    { {1, 3, 1},
                            {6, 0, 3},
                            {3, 3, 3} };
        System.out.println(MaximumVacationDays.solution(flights, days));
        
        int[][] flights2 = { {0, 0, 0},
                             {0, 0, 0},
                             {0, 0, 0} };
        int[][] days2 =    { {1, 1, 1},
                             {7, 7, 7},
                             {7, 7, 7} };
        System.out.println(MaximumVacationDays.solution(flights2, days2));
        
        int[][] flights3 = { {0, 1, 1},
                             {1, 0, 1},
                             {1, 1, 0} };
        int[][] days3 =    { {7, 0, 0},
                             {0, 7, 0},
                             {0, 0, 7} };
        System.out.println(MaximumVacationDays.solution(flights3, days3));
    }

}
