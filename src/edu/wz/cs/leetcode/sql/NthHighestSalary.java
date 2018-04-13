package edu.wz.cs.leetcode.sql;

/**
 * 177. Nth Highest Salary (Medium)<br>
 * https://leetcode.com/problems/nth-highest-salary<br><br>
 * 
 * Write a SQL query to get the nth highest salary from the Employee table.<br>
 * 
 * +----+--------+<br>
 * | Id | Salary |<br>
 * +----+--------+<br>
 * | 1  | 100    |<br>
 * | 2  | 200    |<br>
 * | 3  | 300    |<br>
 * +----+--------+<br>
 * 
 * For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest 
 * salary, then the query should return null.<br>
 * 
 * +------------------------+<br>
 * | getNthHighestSalary(2) |<br>
 * +------------------------+<br>
 * | 200                    |<br>
 * +------------------------+<br>
 * 
 */
public class NthHighestSalary {
    
    public static final String SQL = "CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT"
                                   + "BEGIN"
                                   + " SET N = N - 1;"
                                   + " RETURN ("
                                   + "  SELECT DISTINCT Salary FROM Employee GROUP BY Salary"
                                   + "  ORDER BY Salary DESC LIMIT 1 OFFSET N"
                                   + " );"
                                   + "END";

}
