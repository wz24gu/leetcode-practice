package edu.wz.cs.leetcode.sql;

/**
 * 181. Employees Earning More Than Their Managers<br/>
 * 
 * The Employee table holds all employees including their managers. Every employee has an Id, and there is also a 
 * column for the manager Id.<br/>
 * +----+-------+--------+-----------+<br/>
 * | Id | Name  | Salary | ManagerId |<br/>
 * +----+-------+--------+-----------+<br/>
 * | 1  | Joe   | 70000  | 3         |<br/>
 * | 2  | Henry | 80000  | 4         |<br/>
 * | 3  | Sam   | 60000  | NULL      |<br/>
 * | 4  | Max   | 90000  | NULL      |<br/>
 * +----+-------+--------+-----------+<br/>
 * 
 * Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the 
 * above table, Joe is the only employee who earns more than his manager.
 */
public class EmployeesEarningMoreThanTheirManagers {

    public static final String SQL =
        "SELECT e1.Name from employee e1 " +
        "JOIN employee e2 ON e1.ManagerId = e2.Id " +
        "where e1.salary > e2.salary";
}
