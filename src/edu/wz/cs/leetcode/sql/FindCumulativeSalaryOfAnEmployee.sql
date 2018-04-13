/**
 * 579. Find Cumulative Salary of an Employee<br>
 * https://leetcode.com/problems/find-cumulative-salary-of-an-employee<br><br>
 * 
 * The Employee table holds the salary information in a year.<br>
 * 
 * Write a SQL to get the cumulative sum of an employee's salary over a period of 3 months but exclude the most recent month.<br>
 * 
 * The result should be displayed by 'Id' ascending, and then by 'Month' descending.<br>
 * 
 * Example:<br>
 * | Id | Month | Salary |<br>
 * |----|-------|--------|<br>
 * | 1  | 1     | 20     |<br>
 * | 2  | 1     | 20     |<br>
 * | 1  | 2     | 30     |<br>
 * | 2  | 2     | 30     |<br>
 * | 3  | 2     | 40     |<br>
 * | 1  | 3     | 40     |<br>
 * | 3  | 3     | 60     |<br>
 * | 1  | 4     | 60     |<br>
 * | 3  | 4     | 70     |<br>
 * 
 * Output<br>
 * | Id | Month | Salary |<br>
 * |----|-------|--------|<br>
 * | 1  | 3     | 90     |<br>
 * | 1  | 2     | 50     |<br>
 * | 1  | 1     | 20     |<br>
 * | 2  | 1     | 20     |<br>
 * | 3  | 3     | 100    |<br>
 * | 3  | 2     | 40     |<br>
 * 
 * Explanation:<br>
 * Employee '1' has 3 salary records for the following 3 months except the most recent month '4':
 * salary 40 for month '3', 30 for month '2' and 20 for month '1'
 * So the cumulative sum of salary of this employee over 3 months is 90(40+30+20), 50(30+20) and 20 respectively.<br>
 * 
 * | Id | Month | Salary |<br>
 * |----|-------|--------|<br>
 * | 1  | 3     | 90     |<br>
 * | 1  | 2     | 50     |<br>
 * | 1  | 1     | 20     |<br>
 *
 * Employee '2' only has one salary record (month '1') except its most recent month '2'.<br>
 * | Id | Month | Salary |<br>
 * |----|-------|--------|<br>
 * | 2  | 1     | 20     |<br>
 *
 * Employ '3' has two salary records except its most recent pay month '4': month '3' with 60 and month '2' with 40. So 
 * the cumulative salary is as following.<br>
 * | Id | Month | Salary |<br>
 * |----|-------|--------|<br>
 * | 3  | 3     | 100    |<br>
 * | 3  | 2     | 40     |<br>
 */

SELECT A.Id, max(B.Month) AS Month, sum(B.Salary) AS Salary
FROM Employee A, Employee B
WHERE A.Id = B.Id AND B.Month BETWEEN (A.Month-3) AND (A.Month-1)
GROUP BY A.Id, A.Month
ORDER BY Id, Month DESC;
