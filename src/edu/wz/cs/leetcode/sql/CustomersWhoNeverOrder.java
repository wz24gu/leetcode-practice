package edu.wz.cs.leetcode.sql;

/**
 * 183. Customers Who Never Order<br/>
 * 
 * Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all 
 * customers who never order anything.<br/>
 * 
 * Table: Customers.<br/>
 * +----+-------+<br/>
 * | Id | Name  |<br/>
 * +----+-------+<br/>
 * | 1  | Joe   |<br/>
 * | 2  | Henry |<br/>
 * | 3  | Sam   |<br/>
 * | 4  | Max   |<br/>
 * +----+-------+<br/>
 * 
 * Table: Orders.<br/>
 * +----+------------+<br/>
 * | Id | CustomerId |<br/>
 * +----+------------+<br/>
 * | 1  | 3          |<br/>
 * | 2  | 1          |<br/>
 * +----+------------+<br/>
 * 
 * Using the above tables as example, return the following:<br/>
 * +-----------+<br/>
 * | Customers |<br/>
 * +-----------+<br/>
 * | Henry     |<br/>
 * | Max       |<br/>
 * +-----------+<br/>
 */
public class CustomersWhoNeverOrder {
    
    public static final String SQL = "SELECT c.Name AS Customers FROM Customers c LEFT OUTER JOIN Orders o ON c.Id = o.CustomerId WHERE o.CustomerId IS NULL";
    
    public static final String SQL_ALT = "SELECT Name AS Customers FROM Customers WHERE Id NOT IN (SELECT CustomerId FROM Orders)";

}
