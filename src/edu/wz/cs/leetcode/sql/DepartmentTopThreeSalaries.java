package edu.wz.cs.leetcode.sql;

/**
 * 185. Department Top Three Salaries<br>
 * https://leetcode.com/problems/department-top-three-salaries<br><br>
 * 
 * The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.<br>
 * 
 * +----+-------+--------+--------------+<br>
 * | Id | Name  | Salary | DepartmentId |<br>
 * +----+-------+--------+--------------+<br>
 * | 1  | Joe   | 70000  | 1            |<br>
 * | 2  | Henry | 80000  | 2            |<br>
 * | 3  | Sam   | 60000  | 2            |<br>
 * | 4  | Max   | 90000  | 1            |<br>
 * | 5  | Janet | 69000  | 1            |<br>
 * | 6  | Randy | 85000  | 1            |<br>
 * +----+-------+--------+--------------+<br>
 * 
 * The Department table holds all departments of the company.<br>
 * 
 * +----+----------+<br>
 * | Id | Name     |<br>
 * +----+----------+<br>
 * | 1  | IT       |<br>
 * | 2  | Sales    |<br>
 * +----+----------+<br>
 * 
 * Write a SQL query to find employees who earn the top three salaries in each of the department. For the above tables, 
 * your SQL query should return the following rows.<br>
 * 
 * +------------+----------+--------+<br>
 * | Department | Employee | Salary |<br>
 * +------------+----------+--------+<br>
 * | IT         | Max      | 90000  |<br>
 * | IT         | Randy    | 85000  |<br>
 * | IT         | Joe      | 70000  |<br>
 * | Sales      | Henry    | 80000  |<br>
 * | Sales      | Sam      | 60000  |<br>
 * +------------+----------+--------+<br>
 */
public class DepartmentTopThreeSalaries {

    public static final String SQL =
            "SELECT d.Name AS Department, e.Name AS Employee, e.Salary FROM Employee e "
          + "JOIN Department d on e.DepartmentId = d.Id"
          + "WHERE (SELECT COUNT(DISTINCT Salary) FROM Employee WHERE Salary > e.Salary AND DepartmentId = d.Id) < 3 "
          + "ORDER BY d.Name, e.Salary DESC;";
    
}
