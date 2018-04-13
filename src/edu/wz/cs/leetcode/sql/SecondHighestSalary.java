package edu.wz.cs.leetcode.sql;

/**
 * 176. Second Highest Salary<br/>
 * https://leetcode.com/problems/second-highest-salary<br/><br/>
 * 
 * Write a SQL query to get the second highest salary from the Employee table.<br/>
 * 
 * +----+--------+<br/>
 * | Id | Salary |<br/>
 * +----+--------+<br/>
 * | 1  | 100    |<br/>
 * | 2  | 200    |<br/>
 * | 3  | 300    |<br/>
 * +----+--------+<br/>
 * 
 * For example, given the above Employee table, the query should return 200 as the second highest salary. If there is 
 * no second highest salary, then the query should return null.<br/>
 * 
 * +---------------------+<br/>
 * | SecondHighestSalary |<br/>
 * +---------------------+<br/>
 * | 200                 |<br/>
 * +---------------------+
 */
public class SecondHighestSalary {
    
    public static final String SQL = "SELECT Salary FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET 1";
    
    public static final String SQL_ALT = "SELECT MAX(Salary) FROM Employee WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee)";

}
