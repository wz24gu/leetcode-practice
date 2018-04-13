package edu.wz.cs.leetcode.sql;

/**
 * 182. Duplicate Emails<br/>
 * 
 * Write a SQL query to find all duplicate emails in a table named Person for duplicated emails<br/>
 * +----+---------+<br/>
 * | Id | Email   |<br/>
 * +----+---------+<br/>
 * | 1  | a@b.com |<br/>
 * | 2  | c@d.com |<br/>
 * | 3  | a@b.com |<br/>
 * +----+---------+<br/>
 * 
 * Note: All emails are in lowercase.
 */
public class DuplicateEmails {
    
    public static final String SQL = "SELECT Email FROM Person GROUP BY Email HAVING count(*) > 1";
    
    public static final String SQL_ALT = "SELECT p1.Email FROM Person p1 JOIN Person p2 ON p1.Email = p2.Email WHERE p1.Id <> p2.Id";

}
