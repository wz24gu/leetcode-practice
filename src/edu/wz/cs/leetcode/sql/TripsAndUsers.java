package edu.wz.cs.leetcode.sql;

/**
 * 262. Trips and Users<br>
 * https://leetcode.com/problems/trips-and-users<br><br>
 * 
 * The Trips table holds all taxi trips. Each trip has a unique Id, while Client_Id and Driver_Id are both foreign keys 
 * to the Users_Id at the Users table. Status is an ENUM type of (‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’).<br><br>
 * 
 * +----+-----------+-----------+---------+--------------------+----------+<br>
 * | Id | Client_Id | Driver_Id | City_Id |        Status      |Request_at|<br>
 * +----+-----------+-----------+---------+--------------------+----------+<br>
 * | 1  |     1     |    10     |    1    |     completed      |2013-10-01|<br>
 * | 2  |     2     |    11     |    1    | cancelled_by_driver|2013-10-01|<br>
 * | 3  |     3     |    12     |    6    |     completed      |2013-10-01|<br>
 * | 4  |     4     |    13     |    6    | cancelled_by_client|2013-10-01|<br>
 * | 5  |     1     |    10     |    1    |     completed      |2013-10-02|<br>
 * | 6  |     2     |    11     |    6    |     completed      |2013-10-02|<br>
 * | 7  |     3     |    12     |    6    |     completed      |2013-10-02|<br>
 * | 8  |     2     |    12     |    12   |     completed      |2013-10-03|<br>
 * | 9  |     3     |    10     |    12   |     completed      |2013-10-03|<br>
 * | 10 |     4     |    13     |    12   | cancelled_by_driver|2013-10-03|<br>
 * +----+-----------+-----------+---------+--------------------+----------+<br>
 * 
 * The Users table holds all users. Each user has an unique Users_Id, and Role is an ENUM type of (‘client’, ‘driver’, ‘partner’).<br><br>
 * 
 * +----------+--------+--------+<br>
 * | Users_Id | Banned |  Role  |<br>
 * +----------+--------+--------+<br>
 * |    1     |   No   | client |<br>
 * |    2     |   Yes  | client |<br>
 * |    3     |   No   | client |<br>
 * |    4     |   No   | client |<br>
 * |    10    |   No   | driver |<br>
 * |    11    |   No   | driver |<br>
 * |    12    |   No   | driver |<br>
 * |    13    |   No   | driver |<br>
 * +----------+--------+--------+<br>
 * 
 * Write a SQL query to find the cancellation rate of requests made by unbanned clients between Oct 1, 2013 and Oct 3, 2013. 
 * For the above tables, your SQL query should return the following rows with the cancellation rate being rounded to two 
 * decimal places.<br><br>
 * 
 * +------------+-------------------+<br>
 * |     Day    | Cancellation Rate |<br>
 * +------------+-------------------+<br>
 * | 2013-10-01 |       0.33        |<br>
 * | 2013-10-02 |       0.00        |<br>
 * | 2013-10-03 |       0.50        |<br>
 * +------------+-------------------+<br>
 */
public class TripsAndUsers {

    public static String SQL = "SELECT t.Request_at Day, ROUND(SUM(CASE WHEN t.Status LIKE 'cancelled%' THEN 1 ELSE 0 END)/COUNT(*), 2) 'Cancellation Rate' "
                             + "FROM Trips t JOIN Users u ON t.Client_Id = u.Users_Id AND u.Banned = 'No' "
                             + "WHERE t.Request_at BETWEEN '2013-10-01' AND '2013-10-03' GROUP BY t.Request_at";
    
}
