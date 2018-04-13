package edu.wz.cs.leetcode.sql;

/**
 * 196. Delete Duplicate Emails<br/>
 * https://leetcode.com/problems/delete-duplicate-emails<br/><br/>
 * 
 * Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on 
 * its smallest Id.<br/>
 * 
 * +----+------------------+<br/>
 * | Id | Email            |<br/>
 * +----+------------------+<br/>
 * | 1  | john@example.com |<br/>
 * | 2  | bob@example.com  |<br/>
 * | 3  | john@example.com |<br/>
 * +----+------------------+<br/>
 * 
 * Id is the primary key column for this table.<br/>
 * 
 * For example, after running your query, the above Person table should have the following rows:<br/>
 * 
 * +----+------------------+<br/>
 * | Id | Email            |<br/>
 * +----+------------------+<br/>
 * | 1  | john@example.com |<br/>
 * | 2  | bob@example.com  |<br/>
 * +----+------------------+<br/>
 */
public class DeleteDuplicateEmails {
    
    public static final String SQL = "DELETE p2 from Person p1, Person p2 WHERE p1.Email = p2.Email AND p2.Id <> p1.Id";

}
