package edu.wz.cs.leetcode.sql;

/**
 * 184. Department Highest Salary<br>
 * https://leetcode.com/problems/department-highest-salary<br><br>
 * 
 * The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.<br>
 * 
 * +----+-------+--------+--------------+<br>
 * | Id | Name  | Salary | DepartmentId |<br>
 * +----+-------+--------+--------------+<br>
 * | 1  | Joe   | 70000  | 1            |<br>
 * | 2  | Henry | 80000  | 2            |<br>
 * | 3  | Sam   | 60000  | 2            |<br>
 * | 4  | Max   | 90000  | 1            |<br>
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
 * Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, 
 * Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.<br>
 * 
 * +------------+----------+--------+<br>
 * | Department | Employee | Salary |<br>
 * +------------+----------+--------+<br>
 * | IT         | Max      | 90000  |<br>
 * | Sales      | Henry    | 80000  |<br>
 * +------------+----------+--------+<br>
 * 
 */
public class DepartmentHighestSalary {
    
    public static final String SQL = "SELECT d.Name as Department, e.Name as Employee, e.Saraly as Salary"
                                   + "FROM Employee e, Department d"
                                   + "Where e.DepartmentId = d.Id"
                                   + "AND e.Salary = (SELECT MAX(Salary) FROM Employee e2 WHERE e2.DepartmentId = d.Id);";

}
