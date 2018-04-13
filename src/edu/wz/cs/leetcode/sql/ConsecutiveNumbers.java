package edu.wz.cs.leetcode.sql;

/**
 * 180. Consecutive Numbers<br>
 * https://leetcode.com/problems/consecutive-numbers<br><br>
 * 
 * Write a SQL query to find all numbers that appear at least three times consecutively.
 */
public class ConsecutiveNumbers {
    
    public static String SQL = "SELECT DISTINCT t1.num from table t1"
                             + "JOIN table2 t2 on t1.id = t2.id - 1"
                             + "JOIN table3 t2 on t1.id = t3.id - 2"
                             + "WHERE t1.num = t2.num AND t2.num = t3.num";

}
