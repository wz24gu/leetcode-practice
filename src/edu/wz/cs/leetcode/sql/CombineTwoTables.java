package edu.wz.cs.leetcode.sql;

/**
 * 175. Combine Two Tables<br/>
 * 
 * Table: Person<br/>
 * +-------------+---------+<br/>
 * | Column Name | Type    |<br/>
 * +-------------+---------+<br/>
 * | PersonId    | int     |<br/>
 * | FirstName   | varchar |<br/>
 * | LastName    | varchar |<br/>
 * +-------------+---------+<br/>
 * PersonId is the primary key column for this table.<br/><br/>
 * 
 * Table: Address<br/>
 * +-------------+---------+<br/>
 * | Column Name | Type    |<br/>
 * +-------------+---------+<br/>
 * | AddressId   | int     |<br/>
 * | PersonId    | int     |<br/>
 * | City        | varchar |<br/>
 * | State       | varchar |<br/>
 * +-------------+---------+<br/>
 * AddressId is the primary key column for this table.<br/><br/>
 * 
 * Write a SQL query for a report that provides the following information for each person in the Person table,
 * regardless if there is an address for each of those people:<br/> * 
 * FirstName, LastName, City, State
 */
public class CombineTwoTables {
    
    public static final String SQL = "SELECT p.FirstName, p.LastName, a.City, a.State FROM Person p LEFT JOIN Address a ON p.PersonId = a.PersonId";

}
